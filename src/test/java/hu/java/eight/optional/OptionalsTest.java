package hu.java.eight.optional;

import hu.java.eight.optional.domain.Car;
import hu.java.eight.optional.domain.Insurance;
import hu.java.eight.optional.domain.Person;
import org.testng.annotations.Test;

public final class OptionalsTest {
    private final Person alex;

    public OptionalsTest() {
        final Insurance insurance = new Insurance();
        final Car car = new Car(insurance);
        this.alex = new Person(car);
    }

    @Test
    public void shouldGetNameOfInsurance() {
        assert "Tony Hoare".equals(alex.getCar()
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown")
        );
    }

    @Test
    public void shouldNotGetNameOfNonExistentInsurance() {
        alex.getCar().ifPresent(Car::setInsuranceToNull);

        assert "Unknown".equals(alex.getCar()
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown")
        );
    }

    @Test
    public void shouldNotGetNameOfInsuranceWithNonExistentCar() {
        alex.setCarToNull();

        assert "Unknown".equals(alex.getCar()
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown")
        );
    }
}
