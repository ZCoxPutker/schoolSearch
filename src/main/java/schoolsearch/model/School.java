package schoolsearch.model;

import org.springframework.data.annotation.Id;

public class School {
    @Id
    public int id;

    public String city;
    public String name;

    public School(){}

    public School(int id, String city, String name){
        this.id = id;
        this.city = city;
        this.name = name;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getCity(){
        return city;
    }

    public void setCity(String city) { this.city = city; }

    public String getName(){
        return name;
    }

    public void setName(String name) { this.name = name; }

}
