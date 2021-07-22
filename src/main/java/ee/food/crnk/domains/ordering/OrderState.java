package ee.food.crnk.domains.ordering;

import static strman.Strman.underscored;

public enum OrderState {

    ARRIVED_AT_CLIENT,
    ARRIVED_AT_RESTAURANT,
    CANCELLED,
    CLIENT_REJECTED,
    CLOSED,
    CONFIRMED,
    DELIVERED,
    DRAFT,
    DRIVER_AT_CLIENT,
    DRIVER_AT_RESTAURANT,
    DRIVER_CONFIRMED,
    FINALIZED,
    GROUP_BUILDING,
    GROUP_LOCKED,
    PICKED_UP,
    PRE_QUOTE,
    QUOTED,
    REPORTED,
    PAYMENT_FAILED,
    PAYMENT_PROCESSING,
    RESTAURANT_REJECTED,
    SCHEDULED,
    SUBMITTED;


    public String toString() {
        return underscored(super.toString());
    }

}
