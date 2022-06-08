package com.example.Med.Service;

import com.example.Med.entity.Cita;
import com.example.Med.entity.Diagnostico;
import com.example.Med.entity.Medico;

import java.util.List;

public interface IMedicoSer {
    public List<Medico> getMedicos();
    public void createMedico(Medico medico);
    public Medico getMedico(Long id);
    public void updateMedico(Long id, Medico medico);
    public void deleteMedico(Long id);
}
