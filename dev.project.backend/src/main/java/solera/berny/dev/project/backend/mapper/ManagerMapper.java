package solera.berny.dev.project.backend.mapper;

import org.mapstruct.Mapper;

import solera.berny.dev.project.backend.dto.ManagerDTO;
import solera.berny.dev.project.backend.model.Manager;

@Mapper(componentModel = "spring")
public interface ManagerMapper extends EntityMapper<Manager, ManagerDTO> {

}
