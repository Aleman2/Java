package com.example.Med.Service.Imp;

import com.example.Med.Service.ICitaSer;
import com.example.Med.entity.Cita;
import com.example.Med.repository.CitaRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CitaSer implements ICitaSer {

    @Autowired
    private CitaRepos citaRepos;

    @Override
    @Transactional
    public void createCita(Cita cita) {
         citaRepos.save(cita);
    }
    @Override
    @Transactional
    public void updateCita(Long id,Cita cita) {
        if(citaRepos.findById(id).isPresent()){
            Cita c = citaRepos.findById(id).get();
            c.setMotivoCita(cita.getMotivoCita());
            c.setFechaHora(cita.getFechaHora());
            c.setPaciente(cita.getPaciente());
            c.setMedico(cita.getMedico());
            citaRepos.save(c);
        }}
    @Override
    @Transactional
    public List<Cita> getCitas() {
        return citaRepos.findAll();
    }
    @Override
    @Transactional
    public void deleteCita(Long Id) {
        citaRepos.deleteById(Id);
    }
    @Override
    @Transactional
    public Cita getCita(Long id) {
        return citaRepos.findById(id).get();
    }
}
