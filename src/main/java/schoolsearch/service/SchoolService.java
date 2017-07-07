package schoolsearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import schoolsearch.model.Response;
import schoolsearch.model.School;
import schoolsearch.rabbitmq.RabbitMQRunner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolService {

    @Autowired
    private RabbitMQRunner rabbitMQRunner;

    private static Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection connection = null;
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/schoolsearch","postgres", "password");

        return connection;
    }

    public ResponseEntity<Response> findTableNames() throws Exception {
        rabbitMQRunner.run("Finding table names...");

        List<String> tableNames = new ArrayList<>();

        Connection connection = getConnection();
        DatabaseMetaData md = connection.getMetaData();
        ResultSet rs = md.getTables(null, "public", "%", new String[] {"TABLE"} );
        while (rs.next()) {
            tableNames.add(rs.getString(3));

        }
        connection.close();

        rabbitMQRunner.run("found!");

        return ResponseEntity.ok().body(new Response(tableNames));
    }

    //change input to list
    public ResponseEntity<Response> insertToDatabase(School school) throws Exception {
        rabbitMQRunner.run("Inserting data...");

        Connection connection = getConnection();

        String sql = "INSERT INTO schools VALUES (?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);

//        for(School school: school) {
            pstmt.setString(2,school.getName());
            pstmt.setString(3,school.getCity());
            pstmt.executeUpdate();
//        }

        connection.commit();
        connection.close();
        rabbitMQRunner.run("done!");

        return ResponseEntity.ok().body(new Response(true));
    }

    public ResponseEntity<Response> findAllSchools() throws Exception {
        rabbitMQRunner.run("Finding all schools...");

        List<School> schoolInfo = new ArrayList<>();
        Connection connection = getConnection();

        String sql = "SELECT * FROM schools";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            schoolInfo.add(new School(rs.getString(2), rs.getString(3)));
        }

        connection.close();
        rabbitMQRunner.run("done!");

        return ResponseEntity.ok().body(new Response(schoolInfo));
    }

    public ResponseEntity<Response> findByName(String name) throws Exception {
        rabbitMQRunner.run("Finding schools with name: " + name + "...");
        List<School> results = new ArrayList<>();

        Connection connection = getConnection();
        String sql = "SELECT * FROM schools WHERE name = ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,name);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            results.add(new School(rs.getString(2), rs.getString(3)));
        }
        rabbitMQRunner.run("found " + results.size() + " results!");

        return ResponseEntity.ok().body(new Response(results));
    }

    public ResponseEntity<Response> findByCity(String city) throws Exception {
        rabbitMQRunner.run("Finding schools with name: " + city + "...");
        List<School> results = new ArrayList<>();

        Connection connection = getConnection();
        String sql = "SELECT * FROM schools WHERE city = ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,city);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            results.add(new School(rs.getString(2), rs.getString(3)));
        }
        rabbitMQRunner.run("found " + results.size() + " results!");

        return ResponseEntity.ok().body(new Response(results));
    }

}
