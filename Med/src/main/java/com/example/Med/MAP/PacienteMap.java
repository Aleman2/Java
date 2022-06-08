package com.example.Med.MAP;

import com.example.Med.DTO.PacienteDto;
import com.example.Med.entity.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PacienteMap{
    PacienteMap INSTANCE = Mappers.getMapper(PacienteMap.class);
    PacienteDto toPacienteDto(Paciente paciente);
    Paciente toPaciente(PacienteDto pacientedto);
    List<PacienteDto> toPacienteDtos(List<Paciente> pacientes);
}