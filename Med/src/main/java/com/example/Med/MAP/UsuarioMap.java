package com.example.Med.MAP;

import com.example.Med.DTO.PacienteDto;
import com.example.Med.DTO.UsuarioDto;
import com.example.Med.entity.Paciente;
import com.example.Med.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UsuarioMap{
    UsuarioMap INSTANCE = Mappers.getMapper(UsuarioMap.class);
    UsuarioDto toUsuarioDto(Usuario usuario);
    Usuario toUsuario(UsuarioDto usuariodto);
    List<UsuarioDto> toUsuarioDtos(List<Usuario> usuarios);
}