package app;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SchoolRepository extends MongoRepository<School, String> {
    public School findByCity(String City);
    public List<School> findByName(String Name);
}
