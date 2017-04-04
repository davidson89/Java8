package hu.java.eight.optional.domain;

import java.util.Optional;

public final class Car {
    private Insurance insurance;

    public Car(final Insurance carInsurance) {
        this.insurance = carInsurance;
    }

    public Optional<Insurance> getInsurance() {
        return Optional.ofNullable(insurance);
    }

    public void setInsuranceToNull() {
        this.insurance = null;
    }
}
