package solera.berny.dev.project.backend.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import solera.berny.dev.project.backend.model.Restaurant;

@Getter
@Setter
public class ChefDTO {
    private Long id;

    private String name;
    private String surname;
    private String password;
    private String email;
    private LocalDateTime shiftStarts;

    private List<Restaurant> restaurants;
}
