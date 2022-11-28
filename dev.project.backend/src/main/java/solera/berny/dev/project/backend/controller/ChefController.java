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
import solera.berny.dev.project.backend.dto.ChefDTO;
import solera.berny.dev.project.backend.model.Chef;
import solera.berny.dev.project.backend.service.ChefService;

@RestController
@RequestMapping("/chefs")
@CrossOrigin(origins = "http://localhost:3000/")
public class ChefController {

    private final ChefService chefService;

    @Autowired
    public ChefController(ChefService chefService) {
        this.chefService = chefService;
    }


    @GetMapping
    public List<ChefDTO> findAll(){return this.chefService.findAll();}

    @GetMapping("/{id}")
    public ChefDTO findById(@PathVariable("id") Long id){return this.chefService.findById(id);}

    @PostMapping
    public ChefDTO save(ChefDTO chef){return this.chefService.save(chef);}

    @PutMapping("/{id}")
    public ChefDTO update(@PathVariable("id") Long id, @RequestBody ChefDTO chefDto){return this.chefService.update(id, chefDto);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){this.chefService.delete(id);}

}
