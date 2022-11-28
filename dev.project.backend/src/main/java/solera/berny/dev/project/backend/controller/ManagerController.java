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

import solera.berny.dev.project.backend.dto.ManagerDTO;
import solera.berny.dev.project.backend.service.ManagerService;

@RestController
@RequestMapping("/managers")
@CrossOrigin(origins = "http://localhost:3000/")
public class ManagerController {

    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }


    @GetMapping
    public List<ManagerDTO> findAll(){return this.managerService.findAll();}

    @GetMapping("/{id}")
    public ManagerDTO findById(@PathVariable("id") Long id){return this.managerService.findById(id);}

    @PostMapping
    public ManagerDTO save(ManagerDTO chef){return this.managerService.save(chef);}

    @PutMapping("/{id}")
    public ManagerDTO update(@PathVariable("id") Long id, @RequestBody ManagerDTO chefDto){return this.managerService.update(id, chefDto);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){this.managerService.delete(id);}

}
