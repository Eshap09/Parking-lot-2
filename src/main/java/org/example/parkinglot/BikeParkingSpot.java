package org.example.parkinglot;

import org.example.Vehicle.Vehicle;

public class BikeParkingSpot extends ParkingSpot{
    public BikeParkingSpot(int spotNumber) {
        super(spotNumber, "bike");
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return "bike".equals(vehicle.getVehicleType());
    }
}
