package AcademicPortal;
import java.util.ArrayList;

/*Represents a Faculty (teachers/professor) member in the Academic Portal 
Faculty inherit from Person class */
public class Faculty extends Person{
    //Aditional fields unique to Faculty
    private String departement;
    private String title;  //professional title (eg; Professor, Lecturer)
    private ArrayList<Course> teachingCourses; //Relationship within Course class

    //Constructor for Faculty
    public Faculty(String id, String name, String email, String departement, String title){
        super(id, name, email); //call the superclass Person constructor
        this.departement = departement;
        this.title = title;
        this.teachingCourses = new ArrayList<>(); // Initialize empty course list

    }

    //---------------Setters and Getters----------------

    public void setDepartement(String departement){
        this.departement = departement;
    }
    public String getDepartement(){
        return departement;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }

    public ArrayList<Course> getTeachingCourses(){
        return teachingCourses;
    }
    //---------Faculty-Specific-Methods-------------
    /* Assigns course for this faculty member to teach
        @param course the course to teach */

    public void assignCourse(Course course){
        if(!teachingCourses.contains(course)){
            teachingCourses.add(course);
            System.out.println(this.getName() + " assigned to teach " + course.getCourseName());
        }else{
            System.out.println(this.getName() + " is already teaching " + course.getCourseName());
        }
    }
    /*Removes a course from the faculty's teaching load 
      @param course the course to remove*/

    public void removeCourse(Course course){
        if(teachingCourses.contains(course)){
            teachingCourses.remove(course);
            System.out.println(this.getName() + " removed from teaching " + course.getCourseName());
        }
    }
    /*Overrides the displayInfo method from Person to add faculty-specific details */
    @Override
    public void displayInfo(){
        super.displayInfo(); //Call superclass Person constructor
        System.out.println("Departement: " + departement);
        System.out.println("Title: " + title);
        System.out.println("Number of courses teaching: " + teachingCourses.size());
        System.out.println("------------------------");
    }
}

