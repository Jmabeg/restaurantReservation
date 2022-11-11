package solera.berny.dev.project.backend.mapper;

import org.mapstruct.Mapper;
import solera.berny.dev.project.backend.dto.ChefDTO;
import solera.berny.dev.project.backend.model.Chef;

@Mapper(componentModel = "spring")
public interface ChefMapper extends EntityMapper<Chef, ChefDTO> {

}
