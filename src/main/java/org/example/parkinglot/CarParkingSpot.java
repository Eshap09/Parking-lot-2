package org.example.parkinglot;

import org.example.Vehicle.Vehicle;

public class CarParkingSpot extends ParkingSpot{
    public CarParkingSpot(int spotNumber) {
        super(spotNumber, "Car");
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return "Car".equals(vehicle.getVehicleType());
    }
}
