package com.example.Med.Service;

import com.example.Med.entity.Cita;
import com.example.Med.entity.Medico;
import com.example.Med.entity.Paciente;

import java.util.List;

public interface IPacienteSer {
    public List<Paciente> getPacientes();
    public void createPaciente(Paciente paciente);
    public Paciente getPaciente(Long id);
    public void updatePaciente(Long id, Paciente paciente);
    public void deletePaciente(Long id);
}
