package com.example.Med.Service.Imp;

import com.example.Med.Service.IPacienteSer;
import com.example.Med.entity.Cita;
import com.example.Med.entity.Paciente;
import com.example.Med.repository.CitaRepos;
import com.example.Med.repository.PacienteRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteSer implements IPacienteSer {

    @Autowired
    PacienteRepos pacienteRepos;

    @Override
    @Transactional
    public void createPaciente(Paciente paciente) {
         pacienteRepos.save(paciente);
    }

    @Override
    @Transactional
    public void updatePaciente(Long Id, Paciente paciente) {
        if(pacienteRepos.findById(Id).isPresent()){
            Paciente p = pacienteRepos.findById(Id).get();
            p.setNombre(paciente.getNombre());
            p.setApellidos(paciente.getApellidos());
            p.setUser(paciente.getUser());
            p.setClave(paciente.getClave());
            p.setDireccion(paciente.getDireccion());
            p.setNss(paciente.getNss());
            p.setNumTarjeta(paciente.getNumTarjeta());
            p.setTelefono(paciente.getTelefono());
            pacienteRepos.save(p);
        }
    }

    @Override
    @Transactional
    public List<Paciente> getPacientes() {
        return pacienteRepos.findAll();
    }

    @Override
    @Transactional
    public void deletePaciente(Long id) {

            pacienteRepos.deleteById(id);

    }
    @Override
    @Transactional
    public Paciente getPaciente(Long id) {
        return pacienteRepos.findById(id).get();
    }
}
