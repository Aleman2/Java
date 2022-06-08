package com.example.Med.MAP;

import com.example.Med.DTO.MedicoDto;
import com.example.Med.entity.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicoMap{
    MedicoMap INSTANCE = Mappers.getMapper(MedicoMap.class);
    MedicoDto toMedicoDto(Medico medico);
    Medico toMedico(MedicoDto medicodto);
    List<MedicoDto> toMedicoDtos(List<Medico> medicos);
}
