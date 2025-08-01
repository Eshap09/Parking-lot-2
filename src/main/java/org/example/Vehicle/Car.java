package org.example.Vehicle;

public class Car extends Vehicle{

    private static final String vehicleType = "CAR";
    public Car(String licensePlate) {
        super(licensePlate, "Car");
    }

    @Override
    public double calculateFee(int hoursStayed) {
        return 20.00 * hoursStayed;
    }
}
