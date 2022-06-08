package com.example.Med.Service.Imp;

import com.example.Med.Service.IDIagnosticoSer;
import com.example.Med.entity.Diagnostico;
import com.example.Med.repository.DiagnosticoRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DiagnosticoSer implements IDIagnosticoSer {

    @Autowired
    DiagnosticoRepos diagnosticoRepos;

    @Override
    @Transactional
    public void createDiagnostico(Diagnostico diagnostico) {
         diagnosticoRepos.save(diagnostico);
    }

    @Override
    @Transactional
    public void updateDiagnostico(Long Id, Diagnostico diagnostico) {
        if(diagnosticoRepos.existsById(Id)){
            Diagnostico d = diagnosticoRepos.findById(Id).get();
            d.setEnfermedad(diagnostico.getEnfermedad());
            d.setValoracionEspecialista(diagnostico.getValoracionEspecialista());
            d.setCita(diagnostico.getCita());
            diagnosticoRepos.save(d);
        }
    }


    @Override
    @Transactional
    public List<Diagnostico> getDiagnosticos() {
        return diagnosticoRepos.findAll();
    }

    @Override
    @Transactional
    public void deleteDiagnostico(Long id) {

            diagnosticoRepos.deleteById(id);

    }

    @Override
    @Transactional
    public Diagnostico getDiagnostico(Long id) {
        return diagnosticoRepos.findById(id).get();
    }
}
