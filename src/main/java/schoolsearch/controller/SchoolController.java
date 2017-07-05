package schoolsearch.controller;


import schoolsearch.repository.SchoolRepository;
import schoolsearch.service.SchoolService;
import schoolsearch.model.School;
import schoolsearch.model.SchoolResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "Welcome to School Search!";
    }

    @RequestMapping(value = "/schools/populate")
    public ResponseEntity<SchoolResponse> populateMongo() {
        return schoolService.populateMongo();
    }

    @RequestMapping(value = "/schools/find/all", method = RequestMethod.GET)
    public ResponseEntity<SchoolResponse> findAll() {
        return schoolService.findAll();
    }

    @RequestMapping(value = "/schools/find/bycity", method = RequestMethod.POST)
    public ResponseEntity<SchoolResponse> findByCity(@RequestBody School school) {
        return schoolService.findByCity(school.getCity());
    }

    @RequestMapping(value = "/schools/find/byname", method = RequestMethod.POST)
    public ResponseEntity<SchoolResponse> findbyName(@RequestBody School school) {
        return schoolService.findByName(school.getName());
    }

    @RequestMapping(value = "/schools/new", method = RequestMethod.POST)
    public ResponseEntity<SchoolResponse> newSchool(@RequestBody School school) {
        return schoolService.newSchool(school);
    }
}