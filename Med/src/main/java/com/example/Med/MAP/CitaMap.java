package com.example.Med.MAP;

import com.example.Med.DTO.CitaDto;
import com.example.Med.entity.Cita;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CitaMap{
CitaMap INSTANCE = Mappers.getMapper(CitaMap.class);
    @Mapping(source = "paciente.id", target = "pacienteId")
    @Mapping(source = "medico.id", target = "medicoId")
    @Mapping(source = "diagnostico", target = "diagnosticoDto")
CitaDto toCitaDto(Cita cita);
Cita toCita(CitaDto citadto);
List<CitaDto> toCitaDtos(List<Cita> citas);
}
