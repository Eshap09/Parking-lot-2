package org.example.gates;

import org.example.parkinglot.ParkingLot;
import org.example.parkinglot.ParkingSpot;
import org.example.parkinglot.Ticket;
import org.example.payment.PaymentService;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ExitGate {
    private ParkingLot parkingLot;
    private PaymentService paymentService;

    public ExitGate(ParkingLot parkingLot, PaymentService paymentService) {
        this.parkingLot = parkingLot;
        this.paymentService = paymentService;
    }

    public void processExit(Ticket ticket){
        int hoursStayed = LocalDateTime.now().getHour() - ticket.getStartTime().getHour();
        double fee = ticket.getVehicle().calculateFee(hoursStayed+1);
        paymentService.processPayment(fee);
        parkingLot.vacate(ticket.getParkingSpot(), ticket.getVehicle());
        System.out.println("Spot vacated successfully");
    }
}
