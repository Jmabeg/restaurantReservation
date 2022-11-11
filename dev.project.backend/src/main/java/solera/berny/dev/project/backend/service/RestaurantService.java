package solera.berny.dev.project.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solera.berny.dev.project.backend.dto.ChefDTO;
import solera.berny.dev.project.backend.dto.CustomerDTO;
import solera.berny.dev.project.backend.dto.RestaurantDTO;
import solera.berny.dev.project.backend.mapper.ChefMapper;
import solera.berny.dev.project.backend.mapper.CustomerMapper;
import solera.berny.dev.project.backend.mapper.RestaurantMapper;
import solera.berny.dev.project.backend.model.Chef;
import solera.berny.dev.project.backend.model.Restaurant;
import solera.berny.dev.project.backend.repository.CustomerRepository;
import solera.berny.dev.project.backend.repository.RestaurantRepository;

@Service
public class RestaurantService extends AbstractService<Long, Restaurant, RestaurantRepository, RestaurantDTO, RestaurantMapper> {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final ChefMapper chefMapper;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, CustomerRepository customerRepository,
            RestaurantMapper mapper, CustomerMapper customerMapper,
            ChefMapper chefMapper) {
        super(restaurantRepository, mapper);
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.chefMapper = chefMapper;
    }


    public RestaurantDTO makeRestaurantReservation(RestaurantDTO restaurantDto, CustomerDTO customerDto) {
        this.getMapper().toEntity(restaurantDto).getCustomersWithReservation().add(this.customerMapper.toEntity(customerDto));
        return this.getMapper().toDto(this.getRepository().save(this.getMapper().toEntity(restaurantDto)));

    }

    public RestaurantDTO cancelRestaurantReservation(RestaurantDTO restaurantDto, CustomerDTO customerDto) {
        this.getMapper().toEntity(restaurantDto).getCustomersWithReservation().remove(this.customerMapper.toEntity(customerDto));
        return this.getMapper().toDto(this.getRepository().save(this.getMapper().toEntity(restaurantDto)));

    }

    public Restaurant assignChefToRestaurant(RestaurantDTO restaurantDto, ChefDTO chefDto) {

        this.getMapper().toEntity(restaurantDto).setChef(this.chefMapper.toEntity(chefDto));

        return this.getRepository().save(this.getMapper().toEntity(restaurantDto));
    }

    public Restaurant unassignChefToRestaurant(RestaurantDTO restaurantDto) {
        this.getMapper().toEntity(restaurantDto).setChef(null);

        return this.getRepository().save(this.getMapper().toEntity(restaurantDto));
    }
}
