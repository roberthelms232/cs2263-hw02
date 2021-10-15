

package edu.isu.cs.cs2263;

import java.util.ArrayList;

public class Student{
    private String firstName;
    private String lastName;
    private ArrayList<Course> courList;

    public Student(String firstName, String lastName, ArrayList<Course>courList){
        setFirstName(firstName);
        setLastName(lastName);
        setCourList(courList);
    }
    public static void main(String[] args) {

    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String toString(){
        return getFirstName() + " " + getLastName();
    }
    public ArrayList<Course> getCourList(){
        return courList;
    }
    public void setFirstName(String fName){
        this.firstName = fName;
    }
    public void setLastName(String lName){
        this.lastName = lName;
    }
    public void setCourList(ArrayList<Course> cList){
        this.courList = cList;
    }

}