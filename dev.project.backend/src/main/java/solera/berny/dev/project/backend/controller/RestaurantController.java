package solera.berny.dev.project.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solera.berny.dev.project.backend.model.Chef;
import solera.berny.dev.project.backend.model.Customer;
import solera.berny.dev.project.backend.model.Restaurant;
import solera.berny.dev.project.backend.service.ChefService;
import solera.berny.dev.project.backend.service.CustomerService;
import solera.berny.dev.project.backend.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
@CrossOrigin(origins = "http://localhost:3000/")
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final CustomerService customerService;
    private final ChefService chefService;


    @Autowired
    public RestaurantController(RestaurantService restaurantService,
            CustomerService customerService, ChefService chefService) {
        this.restaurantService = restaurantService;
        this.customerService = customerService;
        this.chefService = chefService;
    }


    @GetMapping
    public List<Restaurant> findAll(){return this.restaurantService.findAll();}

    @GetMapping("/{id}")
    public Restaurant findById(@PathVariable("id") Long id){return this.restaurantService.findById(id);}

    @PostMapping
    public Restaurant save(Restaurant restaurant){return this.restaurantService.save(restaurant);}

    @PutMapping("/{id}")
    public Restaurant update(
            @PathVariable("id") Long id,
            @RequestBody Restaurant restaurant
    ) {
        return this.restaurantService.update(id, restaurant);
    }

    @PutMapping("/{restaurantId}/customers/{customerId}")
    public Restaurant makeRestaurantReservation(
            @PathVariable("restaurantId") Long restaurantId,
            @PathVariable("customerId") Long customerId
    ) {
        Restaurant restaurant = this.restaurantService.findById(restaurantId);
        Customer customer = this.customerService.findById(customerId);
        return this.restaurantService.makeRestaurantReservation(restaurant, customer);
    }

    @PutMapping("/{restaurantId}/customers/{customerId}/cancel")
    public Restaurant cancelRestaurantReservation(
            @PathVariable("restaurantId") Long restaurantId,
            @PathVariable("customerId") Long customerId
    ) {
        Restaurant restaurant = this.restaurantService.findById(restaurantId);
        Customer customer = this.customerService.findById(customerId);
        return this.restaurantService.cancelRestaurantReservation(restaurant, customer);
    }

    @PutMapping("/{restaurantId}/chefs/{chefId}")
    public Restaurant assignChefToRestaurant(
            @PathVariable("restaurantId") Long restaurantId,
            @PathVariable("chefId") Long chefId
    ) {
        Restaurant restaurant = this.restaurantService.findById(restaurantId);
        Chef chef = this.chefService.findById(chefId);
        return this.restaurantService.assignChefToRestaurant(restaurant, chef);
    }

    @PutMapping("/{restaurantId}/chefs/{chefId}/unassign")
    public Restaurant unassignChefToRestaurant(
            @PathVariable("restaurantId") Long restaurantId,
            @PathVariable("chefId") Long chefId
    ) {
        Restaurant restaurant = this.restaurantService.findById(restaurantId);
        Chef chef = this.chefService.findById(chefId);
        return this.restaurantService.unassignChefToRestaurant(restaurant, chef);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){this.restaurantService.delete(id);}

}
