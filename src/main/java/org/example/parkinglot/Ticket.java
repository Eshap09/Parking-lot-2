package org.example.parkinglot;

import org.example.Vehicle.Vehicle;

import java.time.LocalDateTime;

public class Ticket {

    private ParkingSpot parkingSpot;
    private Vehicle vehicle;
    private LocalDateTime startTime;

    public Ticket(ParkingSpot parkingSpot, Vehicle vehicle){
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        this.startTime = LocalDateTime.now();
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
}
