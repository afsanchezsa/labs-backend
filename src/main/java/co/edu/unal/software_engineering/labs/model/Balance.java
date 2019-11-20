package co.edu.unal.software_engineering.labs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="balance",schema ="public")
public class Balance {
    @Id
    @SequenceGenerator( name = "PAYMENT_METHOD_ID_GENERATOR",
            sequenceName = "public.payment_method_payment_method_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "PAYMENT_METHOD_ID_GENERATOR" )
    @Column( name = "balance_id" )
private Integer id;
@Column(name = "balance_payed")
private Integer balance_payed;
@Column(name="total_cost")
private Integer total_cost;
@JsonIgnore
@OneToOne(mappedBy = "balance")
private Association association;
    public Balance(Integer total_cost) {
        this.total_cost = total_cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBalance_payed() {
        return balance_payed;
    }

    public void setBalance_payed(Integer balance_payed) {
        this.balance_payed = balance_payed;
    }

    public Integer getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(Integer total_cost) {
        this.total_cost = total_cost;
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    public double getPercentage(){
        return this.balance_payed/this.total_cost;
    }
}
