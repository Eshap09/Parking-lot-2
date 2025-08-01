package org.example.payment;

public class UPI implements PaymentStrategy{
    @Override
    public void processPayment(Double amount) {
        System.out.println("UPI");
    }
}
