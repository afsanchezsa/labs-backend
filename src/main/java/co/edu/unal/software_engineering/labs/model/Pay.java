package co.edu.unal.software_engineering.labs.model;

public class Pay {
    private PaymentMethod paymentMethod;
    private double balance_to_pay;
    public Pay(PaymentMethod paymentMethod,double balance_to_pay){
        this.paymentMethod=paymentMethod;
        this.balance_to_pay=balance_to_pay;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    private void setBalance_to_pay(double balance_to_pay) {
        this.balance_to_pay = balance_to_pay;
    }

    public double getBalance_to_pay() {
        return balance_to_pay;
    }

    void ApplyPay(double amount){

        setBalance_to_pay(getBalance_to_pay()-this.paymentMethod.MoneyToPay(amount));
    }

}
