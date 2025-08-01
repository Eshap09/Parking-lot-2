package org.example.parkinglot;

import org.example.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingFloor> parkingFloors;

    public ParkingLot(List<ParkingFloor> floors){
        this.parkingFloors = floors;
    }

    public ParkingSpot findAvailableSpot(String vehicleType){
        for(ParkingFloor floor: parkingFloors){
            ParkingSpot spot = floor.findAvailableSpot(vehicleType);
            if(spot!=null){
                return spot;
            }
        }
        return null;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle){
        ParkingSpot spot = findAvailableSpot(vehicle.getVehicleType());
        if(spot!=null){
            spot.parkVehicle(vehicle);
            System.out.println("Vehicle parked successfully");
            return spot;
        }
        System.out.println("No Spot available");
        return null;
    }

    public void vacate(ParkingSpot spot, Vehicle vehicle){
       if(spot !=null && spot.isOccupied() && spot.getVehicle().equals(vehicle)){
           spot.vacate();
           System.out.println(vehicle.getVehicleType()+" vacated the spot: "+ spot.getSpotNumber());
       }
       else {
           System.out.println("Invalid operation");
       }
    }

    public ParkingSpot getSpotByNumber(int spotNumber){
        for(ParkingFloor floor: parkingFloors){
            for(ParkingSpot spot: floor.getSpots()){
                if(spot.getSpotNumber() == spotNumber){
                    return spot;
                }
            }
        }
        return null;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }
}
