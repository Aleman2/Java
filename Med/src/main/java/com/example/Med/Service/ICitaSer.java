package com.example.Med.Service;

import com.example.Med.entity.Cita;

import java.util.List;

public interface ICitaSer {
    public List<Cita> getCitas();
    public void createCita(Cita cita);
    public Cita getCita(Long id);
    public void updateCita(Long id, Cita cita);
    public void deleteCita(Long id);
}
