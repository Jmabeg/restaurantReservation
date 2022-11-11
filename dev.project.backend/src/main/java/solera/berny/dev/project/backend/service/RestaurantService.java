package solera.berny.dev.project.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solera.berny.dev.project.backend.dto.CustomerDTO;
import solera.berny.dev.project.backend.dto.RestaurantDTO;
import solera.berny.dev.project.backend.mapper.CustomerMapper;
import solera.berny.dev.project.backend.mapper.RestaurantMapper;
import solera.berny.dev.project.backend.model.Chef;
import solera.berny.dev.project.backend.model.Customer;
import solera.berny.dev.project.backend.model.Restaurant;
import solera.berny.dev.project.backend.repository.CustomerRepository;
import solera.berny.dev.project.backend.repository.RestaurantRepository;

@Service
public class RestaurantService extends AbstractService<Long, Restaurant, RestaurantRepository, RestaurantDTO, RestaurantMapper> {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, CustomerRepository customerRepository,
            RestaurantMapper mapper, CustomerMapper customerMapper) {
        super(restaurantRepository, mapper);
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }


    public RestaurantDTO makeRestaurantReservation(RestaurantDTO restaurantDto, CustomerDTO customerDto) {
        this.getMapper().toEntity(restaurantDto).getCustomersWithReservation().add(this.customerMapper.toEntity(customerDto));
        return this.getMapper().toDto(this.getRepository().save(this.getMapper().toEntity(restaurantDto)));

    }

    public Restaurant cancelRestaurantReservation(Restaurant restaurant, Customer customer) {
        restaurant.getCustomersWithReservation().remove(customer);
        return this.restaurantRepository.save(restaurant);

    }

    public Restaurant assignChefToRestaurant(Restaurant restaurant, Chef chef) {
        restaurant.setChef(chef);
        return this.restaurantRepository.save(restaurant);
    }

    public Restaurant unassignChefToRestaurant(Restaurant restaurant, Chef chef) {
        restaurant.setChef(null);
        return this.restaurantRepository.save(restaurant);
    }
}
