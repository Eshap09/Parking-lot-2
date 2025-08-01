package org.example.Vehicle;

public class VehicleFactory {

    public static Vehicle createVehicle(String type, String licensePlate){
        if(type.equalsIgnoreCase("Car")){
            return new Car(licensePlate);
        }
        else if(type.equalsIgnoreCase("BIKE")){
            return new Bike(licensePlate);
        }
        return null;
    }
}
