package solera.berny.dev.project.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solera.berny.dev.project.backend.dto.ChefDTO;
import solera.berny.dev.project.backend.mapper.ChefMapper;
import solera.berny.dev.project.backend.model.Chef;
import solera.berny.dev.project.backend.repository.ChefRepository;

@Service
public class ChefService extends AbstractService<Long, Chef, ChefRepository, ChefDTO, ChefMapper> {

    @Autowired
    public ChefService(ChefRepository chefRepository, ChefMapper mapper) {
        super(chefRepository, mapper);
    }

}
