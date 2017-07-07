package schoolsearch.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import schoolsearch.model.Response;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseService {

    public ResponseEntity<Response> findTableNames() throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        Connection connection = null;
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/schoolsearch","postgres", "password");


        List<String> tableNames = new ArrayList<>();
        DatabaseMetaData md = connection.getMetaData();
        ResultSet rs = md.getTables(null, "public", "%", new String[] {"TABLE"} );
        while (rs.next()) {
            tableNames.add(rs.getString(3));

        }
        rs.close();
        return ResponseEntity.ok().body(new Response(tableNames));

    }

    public ResponseEntity<Response> insertToDatabase() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = null;
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/schoolsearch","postgres", "password");

        try {

            String school1 = "Amsterdam";
            String school2 = "Utrecht";
            String school3 = "Utrecht";

            String sql = "INSERT INTO schools VALUES (?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(2, "school1");
            pstmt.setString(3, school1);
            pstmt.executeUpdate();

            pstmt.setString(2, "school2");
            pstmt.setString(3, school2);
            pstmt.executeUpdate();

            pstmt.setString(2, "school3");
            pstmt.setString(3, school3);
            pstmt.executeUpdate();

            connection.commit();
        } catch (Exception e) {

            return ResponseEntity.ok().body(new Response(e.getStackTrace()));
        }

        List<String> schoolInfo = new ArrayList<>();

        try {

            String sql = "SELECT * FROM schools";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                schoolInfo.add("School name: " + rs.getString(2) + ".\nCity: " + rs.getString(3));

            }
        } catch (Exception e) {
            return ResponseEntity.ok().body(new Response(e.getStackTrace()));
        }
        return ResponseEntity.ok().body(new Response(schoolInfo));
    }
}
