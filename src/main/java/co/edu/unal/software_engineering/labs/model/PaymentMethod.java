package co.edu.unal.software_engineering.labs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="payment_method",schema = "public")
public class PaymentMethod {
    @Id
    @SequenceGenerator( name = "PAYMENT_METHOD_ID_GENERATOR",
            sequenceName = "public.payment_method_payment_method_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "PAYMENT_METHOD_ID_GENERATOR" )
    @Column( name = "payment_method_id" )
    private Integer id;
    @Column(name="name")
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "paymentMethod")//en mapped by va el nombre de la variable que referencia a payment method en el modelo associatons(no el nombre de la columna)
    private List<Association> associations;


    public PaymentMethod(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Association> getAssociations() {
        return associations;
    }

    public void setAssociations(List<Association> associations) {
        this.associations = associations;
    }
}
