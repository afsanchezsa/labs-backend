package co.edu.unal.software_engineering.labs.model;

public class CashPayment implements PaymentMethod{


        @Override
        public double MoneyToPay(double amount) {
            return amount;
        }

}
