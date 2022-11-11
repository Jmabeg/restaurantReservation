package solera.berny.dev.project.backend.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import solera.berny.dev.project.backend.dto.CustomerDTO;
import solera.berny.dev.project.backend.model.Customer;
import solera.berny.dev.project.backend.model.Restaurant;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-14T15:17:15+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toEntity(CustomerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( dto.getId() );
        customer.setName( dto.getName() );
        customer.setSurname( dto.getSurname() );
        customer.setPassword( dto.getPassword() );
        customer.setCardNumber( dto.getCardNumber() );
        customer.setEmail( dto.getEmail() );
        List<Restaurant> list = dto.getRestaurants();
        if ( list != null ) {
            customer.setRestaurants( new ArrayList<Restaurant>( list ) );
        }

        return customer;
    }

    @Override
    public CustomerDTO toDto(Customer entity) {
        if ( entity == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId( entity.getId() );
        customerDTO.setName( entity.getName() );
        customerDTO.setSurname( entity.getSurname() );
        customerDTO.setPassword( entity.getPassword() );
        customerDTO.setCardNumber( entity.getCardNumber() );
        customerDTO.setEmail( entity.getEmail() );
        List<Restaurant> list = entity.getRestaurants();
        if ( list != null ) {
            customerDTO.setRestaurants( new ArrayList<Restaurant>( list ) );
        }

        return customerDTO;
    }

    @Override
    public List<Customer> toEntity(List<CustomerDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Customer> list = new ArrayList<Customer>( dtoList.size() );
        for ( CustomerDTO customerDTO : dtoList ) {
            list.add( toEntity( customerDTO ) );
        }

        return list;
    }

    @Override
    public List<CustomerDTO> toDto(List<Customer> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CustomerDTO> list = new ArrayList<CustomerDTO>( entityList.size() );
        for ( Customer customer : entityList ) {
            list.add( toDto( customer ) );
        }

        return list;
    }
}
