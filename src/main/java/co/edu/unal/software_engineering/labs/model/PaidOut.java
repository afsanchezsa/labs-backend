package co.edu.unal.software_engineering.labs.model;

public class PaidOut implements State {
    private static Integer id=1;
private static String name="paidout";

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
