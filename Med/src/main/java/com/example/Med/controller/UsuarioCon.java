package com.example.Med.controller;

import com.example.Med.DTO.UsuarioDto;
import com.example.Med.MAP.UsuarioMap;
import com.example.Med.Service.Imp.UsuarioSer;
import com.example.Med.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/Usuario")
public class UsuarioCon {
    @Autowired
    private UsuarioMap usuariomap;
    @Autowired
    private UsuarioSer usuarioser;

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        usuarioser.deleteUsuario(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping("/Edit/{id}")
    public ResponseEntity<UsuarioDto> update(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto){
        Usuario usuario = usuariomap.toUsuario(usuarioDto);
        usuarioser.updateUsuario(id, usuario);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarioDto);
    }

    @GetMapping("/GetUsuario/{id}")
    public ResponseEntity<UsuarioDto> find(@PathVariable("id") Long id){
        UsuarioDto usuario = usuariomap.toUsuarioDto(usuarioser.getUsuario(id));
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/GetUsuarios")
    public ResponseEntity<List<UsuarioDto>> all(){
        List<UsuarioDto> listaUsuarios = usuariomap.toUsuarioDtos(usuarioser.getUsuarios());
        return ResponseEntity.ok(listaUsuarios);
    }

    @PostMapping("/Create")
    public ResponseEntity<UsuarioDto> create(@RequestBody UsuarioDto usuarioDto){
        Usuario usuario = usuariomap.toUsuario(usuarioDto);
        usuarioser.createUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDto);
    }

}