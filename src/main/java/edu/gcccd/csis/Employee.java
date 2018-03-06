package edu.gcccd.csis;

public class Employee {

    // private instance variables
    private String name;
    private String jobTitle;
    private Organization org;
    private Birthday birthday;

    public Employee(String name, String jobTitle, Organization org, Birthday b)
    {
        this.name = name;
        this.jobTitle = jobTitle;
        this.org = org;
        this.birthday = b;
    }

    public Birthday getBirthday()
    {
        return this.birthday;
    }

    /*
     * To be considered equal, employees must have the same name, organization, and birthday
     * First, check identity, then check if the Object being passed in is an instance of Employee
     */

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o instanceof Employee) {
            Employee e = (Employee) o;
            return (this.name.equals(e.name) &&
                    this.org.equals(e.org) &&
                    this.birthday.equals(e.birthday));
        }
        return false;

    }
}
