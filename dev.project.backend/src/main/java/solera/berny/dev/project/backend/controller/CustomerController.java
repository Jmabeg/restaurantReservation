package solera.berny.dev.project.backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public List<Customer> findAll(){return this.customerService.findAll();}

    @GetMapping("/{id}")
    public Customer findById(@PathVariable("id") Long id){return this.customerService.findById(id);}

    @PostMapping
    public Customer save(Customer customer){return this.customerService.save(customer);}

    @PutMapping("/{id}")
    public Customer update(@PathVariable("id") Long id, @RequestBody Customer customer){return this.customerService.update(id, customer);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){this.customerService.delete(id);}

}
