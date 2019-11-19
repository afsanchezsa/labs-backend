package co.edu.unal.software_engineering.labs.model;

public class OutStanding implements State {
    private static Integer id=3;
    private static String name="outstanding";

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
