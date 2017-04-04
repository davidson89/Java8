package hu.java.eight.optional.domain;

import java.util.Optional;

public final class Person {
    private Car car;

    public Person(final Car carOfPerson) {
        this.car = carOfPerson;
    }

    public Optional<Car> getCar() {
        return Optional.ofNullable(car);
    }

    public void setCarToNull() {
        this.car = null;
    }
}
