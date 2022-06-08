package com.example.Med.controller;

import com.example.Med.DTO.CitaDto;
import com.example.Med.MAP.CitaMap;
import com.example.Med.Service.Imp.CitaSer;
import com.example.Med.Service.Imp.MedicoSer;
import com.example.Med.Service.Imp.PacienteSer;
import com.example.Med.entity.Cita;
import com.example.Med.entity.Medico;
import com.example.Med.entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5080"})
@RestController
@RequestMapping({"/Cita"})
public class CitaCon {
    @Autowired
    private CitaMap citamap;
    @Autowired
    private CitaSer citaser;
    @Autowired
    private PacienteSer pacienteser;
    @Autowired
    private MedicoSer medicoser;

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        citaser.deleteCita(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping("/Edit/{id}")
    public ResponseEntity<CitaDto> update(@PathVariable Long id, @RequestBody CitaDto citadto){
        Cita cita = citamap.toCita(citadto);
        Paciente paciente = pacienteser.getPaciente(citadto.getPacienteId());
        Medico medico = medicoser.getMedico(citadto.getMedicoId());
        cita.setPaciente(paciente);
        cita.setMedico(medico);
        citaser.updateCita(id, cita);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(citadto);
    }

    @GetMapping("/GetCita/{id}")
    public ResponseEntity<CitaDto> find(@PathVariable Long id){
        CitaDto cita = citamap.toCitaDto(citaser.getCita(id));
        return ResponseEntity.ok(cita);
    }

    @GetMapping("/GetCitas")
    public ResponseEntity<List<CitaDto>> all(){
        List<CitaDto> listaCitas = citamap.toCitaDtos(citaser.getCitas());
        return ResponseEntity.ok(listaCitas);
    }
    @PostMapping("/Create")
    public ResponseEntity<CitaDto> create(@RequestBody CitaDto citadto) {
        Cita cita = this.citamap.toCita(citadto);
        Paciente paciente = this.pacienteser.getPaciente(citadto.getPacienteId());
        Medico medico = this.medicoser.getMedico(citadto.getMedicoId());
        cita.setPaciente(paciente);
        cita.setMedico(medico);
        citaser.createCita(cita);
        return ResponseEntity.status(HttpStatus.CREATED).body(citadto);
    }
}




