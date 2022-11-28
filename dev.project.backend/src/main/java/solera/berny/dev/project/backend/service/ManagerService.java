package solera.berny.dev.project.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import solera.berny.dev.project.backend.dto.ManagerDTO;
import solera.berny.dev.project.backend.mapper.ManagerMapper;
import solera.berny.dev.project.backend.model.Manager;
import solera.berny.dev.project.backend.repository.ManagerRepository;

@Service
public class ManagerService extends AbstractService<Long, Manager, ManagerRepository, ManagerDTO, ManagerMapper> {

    @Autowired
    public ManagerService(ManagerRepository chefRepository, ManagerMapper mapper) {
        super(chefRepository, mapper);
    }

}
