package org.example.gates;

import org.example.Vehicle.Vehicle;
import org.example.Vehicle.VehicleFactory;
import org.example.parkinglot.ParkingLot;
import org.example.parkinglot.ParkingSpot;
import org.example.parkinglot.Ticket;

import java.util.Scanner;

public class EntranceGates {

    private ParkingLot parkingLot;

    public EntranceGates(ParkingLot parkingLot){
        this.parkingLot =parkingLot;
    }

    public Ticket processEntrance(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter license plate");
        String licensePlate = scanner.next();
        System.out.println("Enter Vehicle type");
        String vehicleType = scanner.next();

        Vehicle vehicle = VehicleFactory.createVehicle(vehicleType, licensePlate);
        if(vehicle == null){
            System.out.println("Invalid vehicle type");
            return null;
        }

        ParkingSpot spot = parkingLot.findAvailableSpot(vehicle.getVehicleType());
        if(spot!=null){
            parkingLot.parkVehicle(vehicle);
            System.out.println("Vehicle parked succesfully");
        } else{
            System.out.println("No availble spots");
        }


        Ticket ticket = new Ticket(spot, vehicle);
        return ticket;

    }
}
