package com.example.Med.entity;

/*import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;*/

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity (name = "Cita")
@Table(name = "Citas")
public class Cita {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "Id")
    private Long Id;
    @Column(name= "fechaHora", nullable = false)
    private java.util.Date fechaHora;
    @Column(name= "motivoCita", nullable = false)
    private String motivoCita;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEDI_id", nullable = false)
    private Medico medico;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PACI_id", nullable = false)
    private Paciente paciente;
    @OneToOne(mappedBy = "cita", cascade = CascadeType.ALL)
    private Diagnostico diagnostico;

    public Cita(Long id, Date fechaHora, String motivoCita, Medico medico, Paciente paciente, Diagnostico diagnostico) {
        this.Id = id;
        this.fechaHora = fechaHora;
        this.motivoCita = motivoCita;
        this.medico = medico;
        this.paciente = paciente;
        this.diagnostico = diagnostico;
    }

    public Cita() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivoCita() {
        return motivoCita;
    }

    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "Id=" + Id +
                " fechaHora=" + fechaHora +
                " motivoCita='" + motivoCita +
                " paciente=" + paciente +
                " medico=" + medico +
                " diagnostico=" + diagnostico +    '}';

    }

}
