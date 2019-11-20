package co.edu.unal.software_engineering.labs.model.Objects.Pay.State;

import co.edu.unal.software_engineering.labs.model.Interfaces.PaymentState;

public class OutStanding implements PaymentState {
    private final static String name="OutStanding";
    @Override
    public String getName() {
        return name;
    }
}
