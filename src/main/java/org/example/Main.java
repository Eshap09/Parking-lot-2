package org.example;

import org.example.gates.EntranceGates;
import org.example.gates.ExitGate;
import org.example.parkinglot.ParkingFloor;
import org.example.parkinglot.ParkingLot;
import org.example.parkinglot.Ticket;
import org.example.payment.PaymentService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);

        ParkingFloor floor = new ParkingFloor(1, 4,2);
        ArrayList<ParkingFloor> floors = new ArrayList<>();
        floors.add(floor);
        ParkingLot parkingLot = new ParkingLot(floors);

        PaymentService paymentService = new PaymentService(scanner);
        EntranceGates entranceGates = new EntranceGates(parkingLot);
        ExitGate exitGate = new ExitGate(parkingLot,paymentService);

        System.out.println("Welcome to Parking Lot");
        Ticket ticket = null;
        boolean exit = false;
        while(!exit){
            showMenu();
            int choice = getUserChoice(scanner);
            switch (choice) {
                case 1:
                    // Park a vehicle via the entrance gate
                    ticket = parkVehicle(entranceGates);
                    break;

                case 2:
                    // Vacate a parking spot via the exit gate
                    vacateSpot(exitGate, ticket);
                    break;

                case 3:
                    // Exit the session
                    exit = true;
                    System.out.println("Thank you for using the Parking Lot System!");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
                    break;
            }
        }
    }

    private static Ticket parkVehicle(EntranceGates entranceGate) {
        return entranceGate.processEntrance();
    }

    private static int getUserChoice(Scanner scanner) {
        return scanner.nextInt();
    }

    private static void vacateSpot(ExitGate exitGate, Ticket ticket) {

        exitGate.processExit(ticket);
    }


    private static void showMenu() {
        System.out.println("\n******************************************************");
        System.out.println("Please choose an option from below:");
        System.out.println("1. Park a vehicle");
        System.out.println("2. Vacate a vehicle spot");
        System.out.println("3. Exit the system");
        System.out.println("******************************************************");
    }
}