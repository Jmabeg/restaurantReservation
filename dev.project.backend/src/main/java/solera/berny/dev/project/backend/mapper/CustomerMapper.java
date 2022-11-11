package solera.berny.dev.project.backend.mapper;

import org.mapstruct.Mapper;
import solera.berny.dev.project.backend.dto.CustomerDTO;
import solera.berny.dev.project.backend.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends EntityMapper<Customer, CustomerDTO> {

}
