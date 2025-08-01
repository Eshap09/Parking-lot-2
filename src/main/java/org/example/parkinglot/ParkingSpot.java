package org.example.parkinglot;

import org.example.Vehicle.Vehicle;

public abstract class ParkingSpot {
    private int spotNumber;
    private boolean isOccupied;
    private Vehicle vehicle;
    private String spotType;

    public ParkingSpot(int spotNumber, String spotType){
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        this.isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getSpotType() {
        return spotType;
    }
    public int getSpotNumber() {
        return spotNumber;
    }


    public abstract boolean canParkVehicle(Vehicle vehicle);

    public void parkVehicle(Vehicle vehicle){
        if(isOccupied){
            throw new IllegalStateException("Spot is already occupied");
        }
        if(!canParkVehicle(vehicle)){
            throw new IllegalStateException("Spot not suitable for vehicle type");
        }
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void vacate(){
        if(!isOccupied){
            throw new IllegalStateException("Spot is already vacant");
        }
        this.vehicle = null;
        this.isOccupied = false;
    }


    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotNumber=" + spotNumber +
                ", isOccupied=" + isOccupied +
                ", vehicle=" + vehicle +
                ", spotType='" + spotType + '\'' +
                '}';
    }
}
