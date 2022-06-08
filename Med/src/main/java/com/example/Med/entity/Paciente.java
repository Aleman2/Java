package com.example.Med.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity (name = "Paciente")
@Table(name="Paciente")
@PrimaryKeyJoinColumn(name = "PACI_Id")

public class Paciente extends Usuario {
    @Column(length =25,name= "Nss", nullable = false)
    private String Nss;
    @Column(length =25,name= "NumTarjeta", nullable = false)
    private String NumTarjeta;
    @Column(length =15,name= "Telefono", nullable = false)
    private String Telefono;
    @Column(length =45,name= "Direccion", nullable = false)
    private String Direccion;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "PACIENTES_MEDICOS",
            joinColumns = {@JoinColumn(name = "PACI_Id")},
            inverseJoinColumns = {@JoinColumn(name = "MEDI_Id")})
    private List<Medico> medicos;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;




    public Paciente(String nombre, String apellidos, String user, String clave, String nss, String numTarjeta, String telefono, String direccion)
    {
        super(nombre,apellidos,user,clave);
        this.Nss = nss;
        this.NumTarjeta = numTarjeta;
        this.Telefono = telefono;
        this.Direccion = direccion;
    }


    public Paciente()
    {

    }

    public String getNss() {
        return Nss;
    }

    public void setNss(String nss) {
        Nss = nss;
    }

    public String getNumTarjeta() {
        return NumTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        NumTarjeta = numTarjeta;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "NSS:'" + Nss +
                " numTarjeta:'" + NumTarjeta +
                " telefono:'" + Telefono +
                " direccion:'" + Direccion + '}';


    }
}
