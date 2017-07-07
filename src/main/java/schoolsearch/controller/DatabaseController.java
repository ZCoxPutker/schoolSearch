package schoolsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import schoolsearch.model.Response;
import schoolsearch.service.DatabaseService;

import java.sql.SQLException;

@RestController
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;

    @RequestMapping(value = "/database/tables", method = RequestMethod.GET)
    public ResponseEntity<Response> findAllTables() throws SQLException, ClassNotFoundException {

        return databaseService.findTableNames();

    }

    @RequestMapping(value = "/database/tables/insert", method = RequestMethod.GET)
    public ResponseEntity<Response> insertToDatabase() throws SQLException, ClassNotFoundException {

        return databaseService.insertToDatabase();
    }
}
