package schoolsearch.model;

import java.sql.Date;

public class Student {

    private String name;
    private Date birthday;

    public Student() {}

    public Student(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Date getBirthday() { return birthday; }

    public void setBirthday(Date birthday) { this.birthday = birthday; }
}
