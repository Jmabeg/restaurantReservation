package solera.berny.dev.project.backend.service;

import java.util.List;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import solera.berny.dev.project.backend.dto.ChefDTO;
import solera.berny.dev.project.backend.exception.NotFoundException;
import solera.berny.dev.project.backend.mapper.ChefMapper;
import solera.berny.dev.project.backend.model.Chef;
import solera.berny.dev.project.backend.repository.ChefRepository;

@Service
public class ChefService {

    private final ChefRepository chefRepository;
    private final ChefMapper mapper;

    @Autowired
    public ChefService(ChefRepository chefRepository, ChefMapper mapper) {
        this.chefRepository = chefRepository;
        this.mapper = mapper;
    }

    public List<ChefDTO> findAll(){return mapper.toDto(this.chefRepository.findAll());}

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
