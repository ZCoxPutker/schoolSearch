package schoolsearch.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import schoolsearch.model.School;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface SchoolRepository extends MongoRepository<School, String> {
    List<School> findByCity(String city);
    List<School> findByName(String name);
}
