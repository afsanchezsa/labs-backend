package co.edu.unal.software_engineering.labs.model;

public class Interest extends RecargoDecorator {
    private double discountToApply;
    public Interest(PaymentMethod paymentMethod,double discountToApply){
        super(paymentMethod);
        this.discountToApply=discountToApply;

    }




    @Override
    public double MoneyToPay(double amount) {
        return 0;
    }
}
