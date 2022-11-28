package solera.berny.dev.project.backend.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import solera.berny.dev.project.backend.dto.ChefDTO;
import solera.berny.dev.project.backend.model.Chef;
import solera.berny.dev.project.backend.model.Restaurant;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-14T15:17:15+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
@Component
public class ChefMapperImpl implements ChefMapper {

    @Override
    public Chef toEntity(ChefDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Chef chef = new Chef();

        chef.setId( dto.getId() );
        chef.setName( dto.getName() );
        chef.setSurname( dto.getSurname() );
        chef.setPassword( dto.getPassword() );
        chef.setEmail( dto.getEmail() );
        List<Restaurant> list = dto.getRestaurants();
        if ( list != null ) {
            chef.setRestaurants( new ArrayList<Restaurant>( list ) );
        }

        return chef;
    }

    @Override
    public ChefDTO toDto(Chef entity) {
        if ( entity == null ) {
            return null;
        }

        ChefDTO chefDTO = new ChefDTO();

        chefDTO.setId( entity.getId() );
        chefDTO.setName( entity.getName() );
        chefDTO.setSurname( entity.getSurname() );
        chefDTO.setPassword( entity.getPassword() );
        chefDTO.setEmail( entity.getEmail() );
        List<Restaurant> list = entity.getRestaurants();
        if ( list != null ) {
            chefDTO.setRestaurants( new ArrayList<Restaurant>( list ) );
        }

        return chefDTO;
    }

    @Override
    public List<Chef> toEntity(List<ChefDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Chef> list = new ArrayList<Chef>( dtoList.size() );
        for ( ChefDTO chefDTO : dtoList ) {
            list.add( toEntity( chefDTO ) );
        }

        return list;
    }

    @Override
    public List<ChefDTO> toDto(List<Chef> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ChefDTO> list = new ArrayList<ChefDTO>( entityList.size() );
        for ( Chef chef : entityList ) {
            list.add( toDto( chef ) );
        }

        return list;
    }
}
