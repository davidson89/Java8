package hu.java.eight.exercise.domain;

public class Trader {

    private final String city;
    private final String name;

    public Trader(String city, String name) {
        this.city = city;
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Trader: " + this.name + " in " + this.city;
    }
}
