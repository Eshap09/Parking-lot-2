package org.example.payment;

public class Payment {

    private double amount;
    private PaymentStrategy paymentStrategy;

    public Payment(PaymentStrategy paymentStrategy, Double amount){
        this.paymentStrategy = paymentStrategy;
        this.amount = amount;
    }

    public void processPayment(){
        this.paymentStrategy.processPayment(amount);
    }

}
