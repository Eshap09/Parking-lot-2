package org.example.payment;

public class CreditCard implements PaymentStrategy{
    @Override
    public void processPayment(Double amount) {
        System.out.println("Credit Card");
    }
}
