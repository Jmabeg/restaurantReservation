package solera.berny.dev.project.backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import solera.berny.dev.project.backend.dto.CustomerDTO;
import solera.berny.dev.project.backend.model.Customer;
import solera.berny.dev.project.backend.service.CustomerService;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "http://localhost:3000/")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    public List<CustomerDTO> findAll(){return this.customerService.findAll();}

    @GetMapping("/{id}")
    public CustomerDTO findById(@PathVariable("id") Long id){return this.customerService.findById(id);}

    @PostMapping
    public CustomerDTO save(CustomerDTO customerDto){return this.customerService.save(customerDto);}

    @PutMapping("/{id}")
    public CustomerDTO update(@PathVariable("id") Long id, @RequestBody CustomerDTO customerDto){return this.customerService.update(id, customerDto);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){this.customerService.delete(id);}

}
