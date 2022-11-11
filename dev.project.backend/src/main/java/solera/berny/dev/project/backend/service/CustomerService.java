package solera.berny.dev.project.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solera.berny.dev.project.backend.dto.CustomerDTO;
import solera.berny.dev.project.backend.mapper.CustomerMapper;
import solera.berny.dev.project.backend.model.Customer;
import solera.berny.dev.project.backend.repository.CustomerRepository;

@Service
public class CustomerService extends AbstractService<Long, Customer, CustomerRepository, CustomerDTO, CustomerMapper> {

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper mapper) {
        super(customerRepository, mapper);
    }

}
