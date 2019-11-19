package co.edu.unal.software_engineering.labs.model;

public class OutStanding implements State {
    private static String name="outstanding";
    @Override
    public String getName() {
        return name;
    }
}
