package com.example.Med.controller;

import com.example.Med.DTO.DiagnosticoDto;
import com.example.Med.MAP.DiagnosticoMap;
import com.example.Med.Service.Imp.CitaSer;
import com.example.Med.Service.Imp.DiagnosticoSer;
import com.example.Med.entity.Cita;
import com.example.Med.entity.Diagnostico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5080")
@RestController
@RequestMapping("/Diagnostico")
public class DiagnosticoCon {

    @Autowired
    private DiagnosticoMap diagnosticomap;
    @Autowired
    private DiagnosticoSer diagnosticoser;
    @Autowired
    private CitaSer citaser;

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        diagnosticoser.deleteDiagnostico(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @PutMapping("/Edit/{id}")
    public ResponseEntity<DiagnosticoDto> update(@PathVariable Long id, @RequestBody DiagnosticoDto diagnosticoDTO){
        Diagnostico diagnostico = diagnosticomap.toDiagnostico(diagnosticoDTO);
        diagnosticoser.updateDiagnostico(id, diagnostico);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(diagnosticoDTO);
    }

    @GetMapping("/GetDiagnostico/{id}")
    public ResponseEntity<DiagnosticoDto> find(@PathVariable Long id){
        DiagnosticoDto diagnostico = diagnosticomap.toDiagnosticoDto(diagnosticoser.getDiagnostico(id));
        return ResponseEntity.ok(diagnostico);
    }

    @GetMapping("/GetDiagnosticos")
    public ResponseEntity<List<DiagnosticoDto>> all(){
        List<DiagnosticoDto> listaDiagnosticos = diagnosticomap.toDiagnosticoDtos(diagnosticoser.getDiagnosticos());
        return ResponseEntity.ok(listaDiagnosticos);
    }
    @PostMapping("/Create")
    public ResponseEntity<DiagnosticoDto> create(@RequestBody DiagnosticoDto diagnosticoDto){
        Diagnostico diagnostico = diagnosticomap.toDiagnostico(diagnosticoDto);
        Cita cita = citaser.getCita(diagnosticoDto.getCitaId());
        diagnostico.setCita(cita);
        diagnosticoser.createDiagnostico(diagnostico);
        return ResponseEntity.status(HttpStatus.CREATED).body(diagnosticoDto);
    }

}