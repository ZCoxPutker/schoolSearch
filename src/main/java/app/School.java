package app;

import org.springframework.data.annotation.Id;

public class School {
    @Id
    public String id;

    public String city;
    public String name;

    public School(){}

    public School(String city, String name){
        this.city = city;
        this.name = name;
    }

    public String getCity(){
        return city;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return String.format(
                "School[id=%s, city=%s, name=%s]", id,city,name);
    }

}
