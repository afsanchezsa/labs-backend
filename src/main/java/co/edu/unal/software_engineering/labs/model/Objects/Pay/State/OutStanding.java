package co.edu.unal.software_engineering.labs.model.Objects.Pay.State;

import co.edu.unal.software_engineering.labs.model.Objects.Pay.Interfaces.PaymentState;

public class OutStanding implements PaymentState {
    private final static String name="outstanding";
    @Override
    public String getName() {
        return name;
    }
}
