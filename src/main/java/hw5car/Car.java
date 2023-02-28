package hw5car;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Car {

    private String carBrand;
    private String carColor;
    private double carEngineSize;
    private int carMaxSpeed;
    public String getCarBrand() {
        return carBrand;
    }

    public String getCarColor() {
        return carColor;
    }

    public double getCarEngineSize() {
        return carEngineSize;
    }

    public int getCarMaxSpeed() {
        return carMaxSpeed;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public void setCarEngineSize(double carEngineSize) {
        this.carEngineSize = carEngineSize;
    }

    public void setCarMaxSpeed(int carMaxSpeed) {
        this.carMaxSpeed = carMaxSpeed;
    }


    static int noOfObjects = 0;

    {
        noOfObjects += 1;
    }

    public Car(String carBrand) {
     this.carBrand = carBrand;
    }

    public Car(String carBrand, String carColor) {
     this(carBrand);
     this.carColor = carColor;
    }

    public Car(String carBrand, String carColor, double carEngineSize) {
        this(carBrand, carColor);
        this.carEngineSize = carEngineSize;
    }

    public Car(String carBrand, String carColor, double carEngineSize, int carMaxSpeed) {
        this(carBrand, carColor, carEngineSize);
        this.carMaxSpeed = carMaxSpeed;
    }

    public String carChangeColor(String carColor) {
        this.carColor = carColor;
        return carColor;
    }


    @Override
    public String toString() {
        return String.format("Car created is: %s %s %s %s", (getCarBrand() != null ? "Brand " + getCarBrand() + ", " : " "), (getCarColor() != null ? "Color " + getCarColor() + "," : " "), (getCarEngineSize() != 0.0 ? "Car engine " + getCarEngineSize() + ", " : " "), (getCarMaxSpeed() != 0 ? "Car max speed " + getCarMaxSpeed() : " "));}
    static void printCars(Car... args) {
           for (Car arg: args) {
               System.out.println(arg);
           }
}

    private final Logger LOG = LoggerFactory.getLogger(Car.class);

    public void process(Object input) {
        LOG.info("{}", input);
}

    public void processColor(String carColor) {
        if (carColor.equalsIgnoreCase("GOLD"))  {
            LOG.error("Color changed to {} at the car {}", getCarColor(), getCarBrand());
        } else LOG.info("Color changed to {} at the car {}", getCarColor(), getCarBrand());
    }
};



