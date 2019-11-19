package co.edu.unal.software_engineering.labs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="payment_method",schema = "public")
public abstract class PaymentMethod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator( name = "PAYMENT_METHOD_ID_GENERATOR",
            sequenceName = "public.payment_method_payment_method_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "PAYMENT_METHOD_ID_GENERATOR" )
    @Column( name = "payment_method_id" )
    protected Integer id;

    @Column(name ="name")
    protected String name;

    @JsonIgnore
    @OneToMany(mappedBy = "paymentMethod")
    protected List<Pay> Pays;

    abstract public Integer getId();

    abstract public void setId(Integer id);

    abstract public String getName();

    abstract public void setName(String name);

    abstract public List<Pay> getPays() ;

    abstract public void setPays(List<Pay> pays);

    abstract Integer MoneyToPay(Integer amount);

}
