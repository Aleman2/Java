package com.example.Med.controller;

import com.example.Med.DTO.PacienteDto;
import com.example.Med.MAP.PacienteMap;
import com.example.Med.Service.Imp.PacienteSer;
import com.example.Med.entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5080")
@RestController
@RequestMapping("/Paciente")
public class PacienteCon {
    @Autowired
    private PacienteMap pacientemap;
    @Autowired
    private PacienteSer pacienteser;

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        pacienteser.deletePaciente(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping("/Edit/{id}")
    public ResponseEntity<PacienteDto> update(@PathVariable Long id, @RequestBody PacienteDto pacienteDto){
        Paciente paciente = pacientemap.toPaciente(pacienteDto);
        pacienteser.updatePaciente(id, paciente);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(pacienteDto);
    }

    @GetMapping("/GetPaciente/{id}")
    public ResponseEntity<PacienteDto> find(@PathVariable Long id){
        PacienteDto paciente = pacientemap.toPacienteDto(pacienteser.getPaciente(id));
        return ResponseEntity.ok(paciente);
    }

    @GetMapping("/GetPacientes")
    public ResponseEntity<List<PacienteDto>> all(){
        List<PacienteDto> listaPacientes = pacientemap.toPacienteDtos(pacienteser.getPacientes());
        return ResponseEntity.ok(listaPacientes);
    }

    @PostMapping("/Create")
    public ResponseEntity<PacienteDto> create(@RequestBody PacienteDto pacienteDto){
        Paciente paciente = pacientemap.toPaciente(pacienteDto);
        pacienteser.createPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteDto);
    }

}