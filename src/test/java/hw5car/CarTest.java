package hw5car;

import org.testng.annotations.Test;

public class CarTest {

        @Test
        public void test1() {
        Car rav4 = new Car("Toyota Rav4", "Orange");
        Car bmw = new Car("BMW X5", "Blue", 5.0, 280);
        Car ford = new Car("Ford Focus", "Yellow", 2.0);

        rav4.process(rav4);
        bmw.processColor(bmw.carChangeColor("Gold"));
        ford.processColor(ford.carChangeColor("White"));
    }
}

