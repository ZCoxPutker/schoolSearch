package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.DB;



@SpringBootApplication
@RestController
public class Application implements CommandLineRunner {

	@Autowired
	private SchoolRepository repository;

	private char[] password = "hello123".toCharArray();

	@RequestMapping("/")
	public String home() {
		return "Hello Docker World";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String[] args) throws Exception {

		repository.deleteAll();

		repository.save(new School("Utrecht", "Dalton School"));
		repository.save(new School("Rotterdam", "Montessori School"));
		repository.save(new School("Den Haag", "Katholieke School"));

		System.out.println("Schools found with findAll(): ");
		System.out.println("-------------------------------");
		for (School school : repository.findAll()) {
			System.out.println(school);
		}
		System.out.println();

		System.out.println("School found with findByCity('Utrecht'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByCity("Utrecht"));

		System.out.println("Customers found with findName('Montessori School'):");
		System.out.println("--------------------------------");
		for (School school : repository.findByName("Montessori School")) {
			System.out.println(school);

		}

	}
}