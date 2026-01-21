package AcademicPortal;
import java.util.ArrayList;

/* Student inherit from Person superclass*/
public class Student extends Person{
    //Additional fields unique to Student
    private String major;
    private double gpa;
    private ArrayList<Course> enrolledInCourses;  //Relationship within Course class

    //Constructor for Student
    public Student(String id, String name, String email, String major){
        //Call the Person class constructor using super() keyword
        super(id, name, email);
        this.major = major;
        this.gpa = 0.0; //default GPA
        this.enrolledInCourses = new ArrayList<>(); //Initialize empty course
    }

    //-------Setter and Getters---------
    public void setMajor(String major){
        this.major = major;
    }
    public String getMajor(){
        return major;
    }

    public void setGpa(double gpa){
        // Basic Validation
        if(gpa >= 0.0 && gpa <= 4.0){
            this.gpa = gpa;
        }else{
            System.out.println("Error: GPA must be between 0.0 and 4.0!");
        }
    }

    public ArrayList<Course> getEnrolledInCourses(){
        return enrolledInCourses;
    }
    //method fot getGpa
    public double getGpa() {
    return gpa;
}

    // --------- Student Specific Methods ------------
    public void enrollInCourse(Course course){
        if(!enrolledInCourses.contains(course)){
            enrolledInCourses.add(course);
            System.out.println(this.getName() + " enrolled in " + course.getCourseName());
            
        }else{
            System.out.println(this.getName() + " is already enrolled in " + course.getCourseName());
        }
    }
    //Drops a course from the student's schedule
    public void dropCourse(Course course){
        if(enrolledInCourses.contains(course)){
            enrolledInCourses.remove(course);
            System.out.println(this.getName() + " dropped " + course.getCourseName());

        }else{
            System.out.println(this.getName() + " is not enrolled in " + course.getCourseName());
        }

    }

    /*Override the displayInfo method from Person to add Student-Specific details */
    @Override
    public void displayInfo(){
        super.displayInfo(); //call the superclass displayInfo
        System.out.println("Major: " + major);
        System.out.println("GPA: " + gpa);
        System.out.println("Number of enrolled courses: " + enrolledInCourses.size());
        System.out.println("-----------------------");
    }
}