package solera.berny.dev.project.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solera.berny.dev.project.backend.exception.NotFoundException;
import solera.berny.dev.project.backend.model.Chef;
import solera.berny.dev.project.backend.repository.ChefRepository;

@Service
public class ChefService {

    private final ChefRepository chefRepository;

    @Autowired
    public ChefService(ChefRepository chefRepository) {
        this.chefRepository = chefRepository;
    }

    public List<Chef> findAll(){return this.chefRepository.findAll();}

    public Chef findById(Long id) {
        return chefRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Chef save(Chef chef){return this.chefRepository.save(chef);}

    public Chef update(Long id, Chef chef){
        this.chefRepository.findById(id).orElseThrow(NotFoundException::new);
        return this.chefRepository.save(chef);
    }

    public void delete(Long id){this.chefRepository.deleteById(id);}

}
