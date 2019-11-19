package co.edu.unal.software_engineering.labs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table( name = "state", schema = "public" )
public abstract class  State implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator( name = "STATE_ID_GENERATOR",
            sequenceName = "public.state_state_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "STATE_ID_GENERATOR" )
    @Column(name="state_id")
    protected Integer id;

    @Column(name ="name")
    protected String name;

    @JsonIgnore
    @OneToMany( mappedBy = "state" )
    protected List<Association> associations;

    abstract public Integer getId();

    abstract public String getName();

    abstract List<Association> getAssociations();


    abstract public void setId(Integer id);

    public abstract void setName(String name);

    public abstract void setAssociations(List<Association> associations) ;
}
