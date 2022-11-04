package solera.berny.dev.project.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solera.berny.dev.project.backend.exception.NotFoundException;
import solera.berny.dev.project.backend.model.Customer;
import solera.berny.dev.project.backend.model.Restaurant;
import solera.berny.dev.project.backend.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll(){return this.customerRepository.findAll();}

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Customer save(Customer customer){return this.customerRepository.save(customer);}

    public Customer update(Long id, Customer customer){
        this.customerRepository.findById(id).orElseThrow(NotFoundException::new);
        return this.customerRepository.save(customer);
    }

    public void delete(Long id){this.customerRepository.deleteById(id);}

}
