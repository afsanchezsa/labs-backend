package co.edu.unal.software_engineering.labs.model.Objects.Pay.State;

import co.edu.unal.software_engineering.labs.model.Objects.Pay.Interfaces.PaymentState;

public class PaidOut implements PaymentState {
    private final static String name="paidout";
    @Override
    public String getName() {
        return name;
    }
}
