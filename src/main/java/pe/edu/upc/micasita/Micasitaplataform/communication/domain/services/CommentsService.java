package pe.edu.upc.micasita.Micasitaplataform.communication.domain.services;

import org.springframework.stereotype.Service;
import pe.edu.upc.micasita.Micasitaplataform.communication.domain.model.entities.Comments;
import pe.edu.upc.micasita.Micasitaplataform.communication.repository.CommentsRepository;


import java.util.List;
import java.util.Optional;

@Service
public class CommentsService {
    private CommentsRepository repository;

    public List<Comments> findAll() {
        return repository.findAll();
    }

    public Optional<Comments> findById(int id) {
        return repository.findById(id);
    }

    public Comments save(Comments comment) {
        return repository.save(comment);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
