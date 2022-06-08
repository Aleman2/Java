package com.example.Med.entity;

import javax.persistence.*;
import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
@Entity (name = "Usuario")
@Table

/*Si quisiera tabla por clase, en vez de JOINED se usa TABLE_PER_CLASS, haciendo asi que los medicos o pacientes
Que se crean no salgan en la tabla usuarios (haciendo esto hay que quitar de los heredados el @PrimaryKeyJoinColumn,
 y si quiero que todos esten en una tabla, que seria usuarios seria poniendo en vez de JOINED el SINGLE_TABLE
 Y @DiscriminatorColumn( name="" ), poniendo en los heredados @DiscriminatorValue( name="" ) para que se agregue este
 valor a la columna discriminadora de la tabla principal y asi poder identificar de que tipo son
*/

@Inheritance( strategy = InheritanceType.JOINED )

public class Usuario implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "Id")
    private Long Id;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "Apellidos")
    private String Apellidos;
    @Column(name = "User")
    private String User;
    @Column(name = "Clave")
    private String Clave;



    public Usuario(  String nombre, String apellidos, String user, String clave )
    {

        this.Nombre = nombre;
        this.Apellidos = apellidos;
        this.User = user;
        this.Clave = clave;
    }


    public Usuario(){
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuId:" + Id +
                " nombre:'" + Nombre +
                " apellidos:'" + Apellidos +
                " usuario:'" + User +
                " clave:'" + Clave +  '}';

    }
}