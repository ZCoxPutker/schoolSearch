package app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {

    @Autowired
    private SchoolRepository repository;

    @RequestMapping("/school")
    public School school(@RequestParam(value="city", defaultValue="Utrecht")String city) {
        return repository.findByCity(city);
    }
}