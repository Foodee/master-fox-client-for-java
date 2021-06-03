package ee.food.crnk;

import com.fasterxml.jackson.databind.util.StdDateFormat;
import ee.food.crnk.domains.ordering.commands.CreateOrder;
import ee.food.crnk.domains.ordering.commands.PublishOrder;
import ee.food.crnk.exceptions.unprocessableEntity.UnprocessableEntityMapper;
import ee.food.crnk.domains.restaurants.queries.GetActiveRestaurants;
import ee.food.crnk.resources.Restaurant;
import io.crnk.client.CrnkClient;
import io.crnk.client.http.okhttp.OkHttpAdapter;
import io.crnk.client.http.okhttp.OkHttpAdapterListener;
import io.crnk.core.module.Module;
import io.crnk.core.repository.ResourceRepository;
import io.crnk.core.resource.list.ResourceList;
import lombok.val;
import okhttp3.*;
import org.apache.log4j.BasicConfigurator;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class FoodeeClient {

    private class AuthAdapter implements OkHttpAdapterListener {


        private final String apiToken;

        public AuthAdapter(String apiToken) {
            this.apiToken = apiToken;
        }

        @Override
        public void onBuild(OkHttpClient.Builder builder) {
            val apiToken = this.apiToken;

            builder.addInterceptor(new Interceptor() {
                @NotNull
                @Override
                public Response intercept(@NotNull Chain chain) throws IOException {
                    Request.Builder builder = chain.request().newBuilder();
                    builder.addHeader("Authorization", String.format("Token token=\"%s\"", apiToken));
                    builder.addHeader("Content-Type", "application/vnd.api+json");
                    return chain.proceed(builder.build());
                }
            });
        }
    }

    private final String apiToken;
    private final String baseUrl;
    public CrnkClient jsonApiClient;

    public FoodeeClient(String baseUrl, String apiToken) {
        this.baseUrl = baseUrl;
        this.apiToken = apiToken;
        init();
    }

    private void init() {
        initClient();
        setupAuthorization();
        setupJacksonForISO8601();
    }

    private void initClient() {
        this.jsonApiClient = new CrnkClient(this.baseUrl + "/api/v3");

        this.jsonApiClient.addModule(new Module() {
            @Override
            public String getModuleName() {
                return "UnprocessableEntityMapper";
            }

            @Override
            public void setupModule(ModuleContext context) {
                context.addExceptionMapper(new UnprocessableEntityMapper());
            }
        });
    }

    private void setupJacksonForISO8601() {
        val objectMapper = this.jsonApiClient.getObjectMapper();
        objectMapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
    }

    private void setupAuthorization() {
        val adapter = (OkHttpAdapter) this.jsonApiClient.getHttpAdapter();
        adapter.addListener(new AuthAdapter(this.apiToken));
    }

    public <T, I> ResourceRepository<T, I> getRepository(Class<T> resourceClass) {
        return this.jsonApiClient.getRepositoryForType(resourceClass);
    }

    public static void main(String[] args) {
        BasicConfigurator.configure();

        // Staging
        FoodeeClient foodeeClient = new FoodeeClient("https://api-staging.food.ee", "8SMJ3XuneAsavFx7VTxujTeGY3oGtXKTHrm03HBz/W52z+SlctRwuUKUW8g=");
//         LocalHost
//         FoodeeClient foodeeClient = new FoodeeClient("http://localhost:3000", "So16OMcJfVRm1lEyWqLOqT4jnh6xrQpYvU8gLEj+gLiZPWIPKw9wB00=");
        ResourceList<Restaurant> all = new GetActiveRestaurants(foodeeClient).invoke();
//
//        for (Restaurant restaurant : all) {
//            System.out.println("Restaurant#" + restaurant.getId() + " - " + restaurant.getName());
//            System.out.println("Thumbnail " + restaurant.getThumbnailImageUrl());
//
//            Menu activeMenu = new GetActiveMenu(foodeeClient, restaurant).invoke();
//            Utils.printMenu(activeMenu);
//        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, 18);

        val restaurant = (Restaurant) all.toArray()[4];
        val basicOrderParams = new CreateOrder.BasicOrderParams(
                1L,
                22347L,
                restaurant.getId(),
                20,
                "Test Event",
                calendar.getTime()
        );
        val createdOrder = new CreateOrder(foodeeClient, basicOrderParams).invoke();
        System.out.println(createdOrder.getId());

        val publishedOrder = new PublishOrder(foodeeClient, createdOrder.getId()).invoke();
        System.out.println(createdOrder.getState());
    }

}
