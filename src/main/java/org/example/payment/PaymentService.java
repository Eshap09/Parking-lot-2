package org.example.payment;

import java.util.Scanner;

public class PaymentService {
    private Scanner scanner;

    public PaymentService(Scanner scanner){
        this.scanner = scanner;
    }

    public void processPayment(double fee){
        choosePaymentMethod(fee);
    }

    private void choosePaymentMethod(double fee) {
        System.out.println("Total fee: "+ fee);
        System.out.println("Choose payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. Upi");

        int choice = scanner.nextInt();

        Payment payment;
        switch (choice){
            case 1:
                payment = new Payment(new CreditCard(), fee);
                break;
            case 2:
                payment = new Payment(new UPI(), fee);
                break;
            default:
                payment = new Payment(new UPI(), fee);
                break;
        }
        payment.processPayment();
    }
}
