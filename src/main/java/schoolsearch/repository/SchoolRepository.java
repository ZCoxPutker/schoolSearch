package schoolsearch.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository <School, String> {
    List<School> findByCity(String city);
    List<School> findByName(String name);
}
