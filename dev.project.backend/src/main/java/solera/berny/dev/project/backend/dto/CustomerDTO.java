package solera.berny.dev.project.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import solera.berny.dev.project.backend.model.Restaurant;

@Getter
@Setter
public class CustomerDTO {

    private Long id;
    private String name;
    private String surname;
    private String password;
    private String cardNumber;
    private String email;

    private List<Restaurant> restaurants;
}
