package edu.isu.cs.cs2263;

public class Course {
    private int number;
    private String subject;
    private String title;

    public static void main(String[] args){

    }
    public void course(){

    }

    public int getNumber() {
        return number;
    }

    public String getSubject() {
        return subject;
    }

    public String getTitle() {
        return title;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Course{" +
                "subject='" + subject + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
