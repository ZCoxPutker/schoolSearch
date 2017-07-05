package schoolsearch.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static java.util.Collections.singletonList;

@Configuration
@EnableMongoRepositories("schoolsearch.repository")
public class MongoConfig {

    private String database = "schooldb";
    private String host = "127.0.0.1";
    private int port = 27017;
    private String user = "admin";
    private String password = "password";
    private String schema = "admin";

    @Bean
    public MongoDbFactory mongoDbFactory() throws GeneralSecurityException, IOException {
        return new SimpleMongoDbFactory(new MongoClient(
                singletonList(new ServerAddress(host, port)),
                singletonList(MongoCredential.createCredential(user, schema,
                        password.toCharArray()))), database);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws GeneralSecurityException, IOException {
        return new MongoTemplate(mongoDbFactory());
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}