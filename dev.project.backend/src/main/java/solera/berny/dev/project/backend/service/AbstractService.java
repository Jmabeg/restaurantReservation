package solera.berny.dev.project.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import solera.berny.dev.project.backend.exception.NotFoundException;
import solera.berny.dev.project.backend.mapper.EntityMapper;

public abstract class AbstractService<Long, E, R extends JpaRepository<E, Long>, D, M extends EntityMapper<E, D>> {
    private final R repository;
    private final M mapper;


    @Autowired
    public AbstractService(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<D> findAll(){return mapper.toDto(repository.findAll());}

    public D findById(Long id){return mapper.toDto(repository.findById(id).orElseThrow(NotFoundException::new));}

    public D save(D dto){return mapper.toDto(repository.save(mapper.toEntity(dto)));}

    public D update(Long id, D d){
        repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.toDto(repository.save(mapper.toEntity(d)));
    }

    public void delete(Long id){repository.deleteById(id);}

    protected R getRepository(){return repository;}

    protected M getMapper(){return mapper;}

}
