package com.example.Med.Service;

import com.example.Med.entity.Cita;
import com.example.Med.entity.Diagnostico;

import java.util.List;

public interface IDIagnosticoSer {
    public List<Diagnostico> getDiagnosticos();
    public void createDiagnostico(Diagnostico diagnostico);
    public Diagnostico getDiagnostico(Long id);
    public void updateDiagnostico(Long id, Diagnostico diagnostico);
    public void deleteDiagnostico(Long id);
}
