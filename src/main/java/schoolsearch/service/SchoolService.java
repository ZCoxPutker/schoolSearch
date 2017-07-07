//package schoolsearch.service;
//
//import schoolsearch.rabbitmq.RabbitMQRunner;
//import schoolsearch.repository.SchoolRepository;
//import schoolsearch.model.School;
//import schoolsearch.model.Response;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.List;
//
//@Service
//public class SchoolService {
//
//    @Autowired
//    private SchoolRepository schoolRepository;
//
//    @Autowired
//    private RabbitMQRunner rabbitMQRunner;
//
//    public ResponseEntity<Response> populateMongo() {
//
//        try {
//            schoolRepository.deleteAll();
//
//            schoolRepository.save(new School(1234, "Utrecht", "Jan Kristus"));
//            schoolRepository.save(new School(4321, "Rotterdam", "De Bilt"));
//            schoolRepository.save(new School(7563, "Den Haag", "St Antonius"));
//            schoolRepository.save(new School(4326, "Utrecht", "De Sloot"));
//
//            rabbitMQRunner.run("Saved new schools!");
//        } catch(Exception ex) {
//            throw new RuntimeException();
//        }
//        return ResponseEntity.ok().body(new Response(true));
//
//    }
//
//    public ResponseEntity<Response> newSchool(@RequestBody School school) {
//
//        try {
//            schoolRepository.save(school);
//            rabbitMQRunner.run("New school added!");
//
//        } catch(Exception ex) {
//            throw new RuntimeException();
//        }
//        return ResponseEntity.ok().body(new Response(true));
//    }
//
//    public ResponseEntity<Response> findByName(String name) {
//
//        try {
//            List<School> foundSchools = schoolRepository.findByName(name);
//            rabbitMQRunner.run("Found " + foundSchools.size() + " schools with name " +
//                    name + ".");
//
//            return ResponseEntity.ok().body(new Response(foundSchools));
//
//        } catch(Exception ex) {
//            throw new RuntimeException();
//        }
//    }
//
//    public ResponseEntity<Response> findByCity(String city) {
//
//        try {
//            List<School> foundSchools = schoolRepository.findByCity(city);
//            rabbitMQRunner.run("Found " + foundSchools.size() + " schools in city " +
//                    city + ".");
//
//            return ResponseEntity.ok().body(new Response(foundSchools));
//
//        } catch(Exception ex) {
//            throw new RuntimeException();
//        }
//    }
//
//    public ResponseEntity<Response> findAll() {
//
//        try {
//            List<School> schools = schoolRepository.findAll();
//            rabbitMQRunner.run("Found all schools!");
//
//            return ResponseEntity.ok().body(new Response(schools));
//
//        } catch(Exception ex) {
//            throw new RuntimeException();
//        }
//    }
//}
