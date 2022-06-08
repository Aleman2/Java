package com.example.Med.MAP;

import com.example.Med.DTO.DiagnosticoDto;
import com.example.Med.entity.Diagnostico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiagnosticoMap{
    DiagnosticoMap INSTANCE = Mappers.getMapper(DiagnosticoMap.class);
    @Mapping(source = "cita.citaId", target = "citaId")
    DiagnosticoDto toDiagnosticoDto(Diagnostico diagnostico);
    Diagnostico toDiagnostico(DiagnosticoDto diagnosticodto);
    List<DiagnosticoDto> toDiagnosticoDtos(List<Diagnostico> diagnosticos);
}
