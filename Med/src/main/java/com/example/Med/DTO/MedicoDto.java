package com.example.Med.DTO;


import java.util.List;

public class MedicoDto extends UsuarioDto {
    private String NumColegiado;
    private List<PacienteDto> pacientes;
    private List<CitaDto> citas;

    public String getNumColegiado() {
        return NumColegiado;
    }

    public void setNumColegiado(String numColegiado) {
        NumColegiado = numColegiado;
    }

    public List<PacienteDto> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<PacienteDto> pacientes) {
        this.pacientes = pacientes;
    }

    public List<CitaDto> getCitas() {
        return citas;
    }

    public void setCitas(List<CitaDto> citas) {
        this.citas = citas;
    }

}
