package com.example.Med.Service.Imp;

import com.example.Med.Service.IMedicoSer;
import com.example.Med.entity.Cita;
import com.example.Med.entity.Medico;
import com.example.Med.repository.CitaRepos;
import com.example.Med.repository.MedicoRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoSer implements IMedicoSer {

    @Autowired
    MedicoRepos medicoRepos;

    @Override
    @Transactional
    public void createMedico(Medico medico) {
         medicoRepos.save(medico);
    }

    public void updateMedico(Long Id, Medico medico) {
        if(medicoRepos.findById(Id).isPresent()){
            Medico m = medicoRepos.findById(Id).get();
            m.setNombre(medico.getNombre());
            m.setApellidos(medico.getApellidos());
            m.setUser(medico.getUser());
            m.setClave(medico.getClave());
            m.setNumColegiado(medico.getNumColegiado());
            medicoRepos.save(m);
        }
    }


    public List<Medico> getMedicos() {
        return medicoRepos.findAll();
    }

    public void deleteMedico(Long id) {

            medicoRepos.deleteById(id);

    }

    public Medico getMedico(Long id) {
        return medicoRepos.findById(id).get();
    }
}
