package com.example.Med.DTO;


import com.example.Med.entity.Medico;
import com.example.Med.entity.Paciente;

import java.util.Date;

public class CitaDto {
    private Long Id;
    private Date fechaHora;
    private String motivoCita;
    private Long medicoId;
    private Long pacienteId;
    private DiagnosticoDto diagnosticoDto;

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

    public Long getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Long medicoId) {
        this.medicoId = medicoId;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public DiagnosticoDto getDiagnosticoDto() {
        return diagnosticoDto;
    }

    public void setDiagnosticoDto(DiagnosticoDto diagnosticoDto) {
        this.diagnosticoDto = diagnosticoDto;
    }
}
