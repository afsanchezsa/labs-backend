package co.edu.unal.software_engineering.labs.model;

public abstract class RecargoDecorator extends PaymentMethod {
    protected PaymentMethod paymentMethod;

    protected RecargoDecorator(PaymentMethod paymentMethod){
        this.paymentMethod=paymentMethod;
    }

}
