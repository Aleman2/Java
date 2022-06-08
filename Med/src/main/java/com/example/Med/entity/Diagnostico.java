package com.example.Med.entity;

import javax.persistence.*;


@Entity (name = "Diagnostico")
@Table(name = "Diagnostico")
public class Diagnostico {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "Id")
    private Long Id;
    @Column(name= "valoracionEspecialista", nullable = false)
    private String valoracionEspecialista;
    @Column(name= "Enfermedad", nullable = false)
    private String Enfermedad;
    @OneToOne
    @JoinColumn(name = "CITA_Id")
    private Cita cita;

    public Diagnostico(Long Id,String valoracionEspecialista, String enfermedad, Cita cita) {
        this.Id = Id;
        this.valoracionEspecialista = valoracionEspecialista;
        this.Enfermedad = enfermedad;
        this.cita = cita;
    }
//CUando esta vacio genera constructor por defecto
    public Diagnostico() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getValoracionEspecialista() {
        return valoracionEspecialista;
    }

    public void setValoracionEspecialista(String valoracionEspecialista) {
        this.valoracionEspecialista = valoracionEspecialista;
    }

    public String getEnfermedad() {
        return Enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        Enfermedad = enfermedad;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    @Override
    public String toString() {
        return "Diagnostico{" +
                "Id:" + Id +
                " valoracionEspecialista:'" + valoracionEspecialista +
                " enfermedad:'" + Enfermedad +
                " cita:" + cita +  '}';

    }

}
