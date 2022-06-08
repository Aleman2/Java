package com.example.Med.controller;

import com.example.Med.DTO.MedicoDto;
import com.example.Med.MAP.MedicoMap;
import com.example.Med.MAP.PacienteMap;
import com.example.Med.Service.Imp.MedicoSer;
import com.example.Med.entity.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5080")
@RestController
@RequestMapping("/Medico")
public class MedicoCon {
    @Autowired
    private MedicoMap medicomap;
    @Autowired
    private PacienteMap pacientemap;
    @Autowired
    private MedicoSer medicoser;

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        medicoser.deleteMedico(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping("/Edit/{id}")
    public ResponseEntity<MedicoDto> update(@PathVariable Long id, @RequestBody MedicoDto medicoDto){
        Medico medico = medicomap.toMedico(medicoDto);
        medicoser.updateMedico(id, medico);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(medicoDto);
    }

    @GetMapping("/GetMedico/{id}")
    public ResponseEntity<MedicoDto> find(@PathVariable Long id){
        MedicoDto medico = medicomap.toMedicoDto(medicoser.getMedico(id));
        return ResponseEntity.ok(medico);
    }

    @GetMapping("/GetMedicos")
    public ResponseEntity<List<MedicoDto>> all(){
        List<MedicoDto> listaMedicos = medicomap.toMedicoDtos(medicoser.getMedicos());
        return ResponseEntity.ok(listaMedicos);
    }

    @PostMapping("/Create")
    public ResponseEntity<MedicoDto> create(@RequestBody MedicoDto medicoDto){
        Medico medico = medicomap.toMedico(medicoDto);
        System.out.println(medicoDto);
        System.out.println(medico);
        medicoser.createMedico(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoDto);
    }
}