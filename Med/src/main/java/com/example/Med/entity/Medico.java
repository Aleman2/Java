package com.example.Med.entity;

import javax.persistence.*;
import java.util.List;

@Entity (name = "Medico")
@PrimaryKeyJoinColumn(name = "MEDI_Id")
public class Medico extends Usuario {


    @Column(length =16,name= "NumColegiado", nullable = false)
    private String NumColegiado;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "medicos")
    private List<Paciente> pacientes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Medico")
    private List<Cita> citas;

    public Medico(String nombre, String apellidos, String user, String clave, String numColegiado)
    {
        super(nombre,apellidos,user,clave);
        this.NumColegiado = numColegiado;
    }


    public Medico()
    {

    }


    public String getNumColegiado() {
        return NumColegiado;
    }

    public void setNumColegiado(String numColegiado) {
        NumColegiado = numColegiado;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "numColegiado:'" + NumColegiado +   '}';

    }
}