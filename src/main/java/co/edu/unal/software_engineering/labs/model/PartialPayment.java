package co.edu.unal.software_engineering.labs.model;

public class PartialPayment implements State {
    public static Integer id=2;
    public static String name="partialpayment";

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
