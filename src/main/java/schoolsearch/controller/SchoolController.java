package schoolsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import schoolsearch.model.Response;
import schoolsearch.model.School;
import schoolsearch.service.SchoolService;

@RestController
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "Welcome to School Search!";
    }

    @RequestMapping(value = "/schoolsearch", method = RequestMethod.GET)
    public ResponseEntity<Response> findAllTables() throws Exception {

        return schoolService.findTableNames();
    }

    @RequestMapping(value = "/schoolsearch/schools/find/all", method = RequestMethod.GET)
    public ResponseEntity<Response> findAllSchools() throws Exception {
            return schoolService.findAllSchools();
    }

    @RequestMapping(value = "/schoolsearch/schools/insert", method = RequestMethod.POST)
    public ResponseEntity<Response> insertToDatabase(@RequestBody School school) throws Exception {

        return schoolService.insertToDatabase(school);
    }

    @RequestMapping(value = "/schoolsearch/schools/find/byname", method = RequestMethod.POST)
    public ResponseEntity<Response> findByName(@RequestBody School school) throws Exception {
        return schoolService.findByName(school.getName());
    }

    @RequestMapping(value = "/schoolsearch/schools/find/bycity", method = RequestMethod.POST)
    public ResponseEntity<Response> findBy(@RequestBody School school) throws Exception {
        return schoolService.findByCity(school.getCity());
    }
}
