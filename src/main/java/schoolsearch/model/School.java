package schoolsearch.model;


public class School {

    public String city;
    public String name;

    public School(){}

    public School(String name, String city){
        this.city = city;
        this.name = name;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city) { this.city = city; }

    public String getName(){
        return name;
    }

    public void setName(String name) { this.name = name; }

}
