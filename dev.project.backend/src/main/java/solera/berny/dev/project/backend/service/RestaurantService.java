package solera.berny.dev.project.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solera.berny.dev.project.backend.exception.NotFoundException;
import solera.berny.dev.project.backend.model.Chef;
import solera.berny.dev.project.backend.model.Customer;
import solera.berny.dev.project.backend.model.Restaurant;
import solera.berny.dev.project.backend.repository.CustomerRepository;
import solera.berny.dev.project.backend.repository.RestaurantRepository;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository,
            CustomerRepository customerRepository) {
        this.restaurantRepository = restaurantRepository;
        this.customerRepository = customerRepository;
    }

    public List<Restaurant> findAll(){return this.restaurantRepository.findAll();}

    public Restaurant findById(Long id) {
        return restaurantRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Restaurant save(Restaurant restaurant){return this.restaurantRepository.save(restaurant);}

    public Restaurant update(Long id, Restaurant restaurant){
        this.restaurantRepository.findById(id).orElseThrow(NotFoundException::new);
        return this.restaurantRepository.save(restaurant);
    }

    public void delete(Long id){this.restaurantRepository.deleteById(id);}

    public Restaurant makeRestaurantReservation(Restaurant restaurant, Customer customer) {
        restaurant.getCustomersWithReservation().add(customer);
        return this.restaurantRepository.save(restaurant);

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
