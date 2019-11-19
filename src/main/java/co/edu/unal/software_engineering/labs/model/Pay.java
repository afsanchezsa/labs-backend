package co.edu.unal.software_engineering.labs.model;

import javax.persistence.*;

@Entity
@Table(name="pay",schema = "public")
public class Pay {
    @Id
    @SequenceGenerator( name = "PAY_ID_GENERATOR",
            sequenceName = "public.pay_pay_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "PAY_ID_GENERATOR" )
    @Column( name = "pay_id" )
    private Integer id;

    @ManyToOne
    @JoinColumn(name="payment_method_id")
    private PaymentMethod paymentMethod;

     @Column(name="balance_to_pay")
    private Integer balance_to_pay;

    public Pay(PaymentMethod paymentMethod,Integer balance_to_pay){
        this.paymentMethod=paymentMethod;
        this.balance_to_pay=balance_to_pay;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {this.paymentMethod = paymentMethod;}

    public PaymentMethod getPaymentMethod() { return paymentMethod;}

    private void setBalance_to_pay(Integer balance_to_pay) {
        this.balance_to_pay = balance_to_pay;
    }

    public Integer getBalance_to_pay() {return balance_to_pay;}

    void ApplyPay(Integer amount){

        setBalance_to_pay(getBalance_to_pay()-this.paymentMethod.MoneyToPay(amount));
    }

}
