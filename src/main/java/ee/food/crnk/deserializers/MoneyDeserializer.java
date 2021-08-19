package ee.food.crnk.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import org.javamoney.moneta.Money;

import javax.money.Monetary;
import java.io.IOException;

public class MoneyDeserializer extends StdDeserializer<Money> {

    public MoneyDeserializer() {
        this(null);
    }

    public MoneyDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Money deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        Integer cents = (Integer) ((IntNode) node.get("amount")).numberValue();
        String isoCurrency = node.get("currency").asText();

        return Money.of(Double.valueOf(cents) / 100, Monetary.getCurrency(isoCurrency));
    }
}
