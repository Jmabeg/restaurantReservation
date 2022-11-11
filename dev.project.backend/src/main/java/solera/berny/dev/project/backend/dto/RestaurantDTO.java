package solera.berny.dev.project.backend.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import solera.berny.dev.project.backend.model.Chef;
import solera.berny.dev.project.backend.model.Customer;

@Getter
@Setter
public class RestaurantDTO {
    private Long id;
    private String name;
    private Integer maxCapacity;
    private String password;
    private String email;

    private List<Customer> customersWithReservation;
    private Chef chef;
}
