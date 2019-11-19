package co.edu.unal.software_engineering.labs.model;

public class InstallmentPayment implements PaymentMethod {
    private static double interest=0.05;
    public InstallmentPayment(){
     }


    @Override
    public double MoneyToPay(double amount) {
    return amount*(1-interest);
    }
}
