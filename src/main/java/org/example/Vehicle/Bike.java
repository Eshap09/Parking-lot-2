package org.example.Vehicle;

public class Bike extends Vehicle{

    private static final String vehicleType = "bike";
    public Bike(String licensePlate) {
        super(licensePlate, "bike");
    }

    @Override
    public double calculateFee(int hoursStayed) {
        return 10.00 * hoursStayed;
    }
}
