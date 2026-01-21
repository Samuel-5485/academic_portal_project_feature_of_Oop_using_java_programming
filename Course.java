package AcademicPortal;
import java.util.ArrayList;

/*Represents an academic Course in the portal 
  manages relationship with Students(roster) and Faculty(instructor)*/

public class Course{
    //private fields for encapsulation
    private String courseId;
    private String courseName;
    private int creditHours;
    private Faculty faculty; //The faculty teaching this course
    private ArrayList<Student> roster; //List of erolled students

    //Constructor to initialize a Course object 
    public Course(String courseId, String courseName, int creditHours){
        this.courseId = courseId;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.faculty = null; // No faculty assigned initially
        this.roster = new ArrayList<>(); //initialize empty roster
    }

    //------------Setters and Getters-----------------
    public void setCourseId(String courseId){
        this.courseId = courseId;
    }
    public String getCourseId(){
        return courseId;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    public String getCourseName(){
        return courseName;
    }

    public void setCreditHours(int creditHours){
        if(creditHours > 0){
            this.creditHours = creditHours;
        }else{
            System.out.println("Error: Credit hours must be positive!");
        }
    }
    public int getCreditHours(){
        return creditHours;
    }

    public Faculty getFaculty(){
        return faculty;
    }

    public ArrayList<Student> getRoster(){
        return roster;
    }

    //-------------Critical Relationshihp Methods----------------
    /*
        *Adds a student to this course's roster and updates the student's
         enrolledCourses list
        *This maintains the two-way relationship (Course <-> Student )
        * @param student the student to enroll */
    
    public void addStudent(Student student){
        //Check if student is already enrolled
        if (roster.contains(student)){
            System.out.println(student.getName() + " is already enrolled in " + this.courseName);
        }    
        //Add to course roster
        roster.add(student);
        
        //Update the student's course list (two-way relationship)
        student.enrollInCourse(this);
        System.out.println(student.getName() + " Successfully enrolled in " + this.courseName);
    }
    /*Removes a student from the course roster and updaes their enrolledInCourses 
      @param student the student to remove*/

    public void removeStudent(Student student){
        if(roster.contains(student)){
            roster.remove(student);
            //Note: Student class should have a dropCourse() method
            //student.dropCourse(this); //we'll implement this when needed
            System.out.println(student.getName() + " removed from " + this.courseName);
        }else{
            System.out.println(student.getName() + " is not enrolled in " + this.courseName);
        }
    }
    /*Assigns a faculty member to teach this course and updates the faculty's teachingCourses
      *This maintains the two-way relationshp (Course<->Faculty) 
      *@param faculty the faculty member to assign 
    */
    public void assignFaculy(Faculty faculty){
        //If there's already a faculty assigned, remove this course from their list
        if(this.faculty != null){
            this.faculty.removeCourse(this);
        }
        //Assign new faculty
        this.faculty = faculty;
        //update faculty's course list (two-way relationship)
        if(faculty != null){
            faculty.assignCourse(this);
        }

        if(faculty != null){
            System.out.println(faculty.getName() + " assigned as instructor for " + this.courseName);

        }else{
            System.out.println("Instructor removed from " + this.courseName);
        }
    }
    //Display course information including instructor and enrolled students 
    
    public void displayCourseInfo(){
        System.out.println("\n==== Course Information =====");
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Credit Hours: " + creditHours);

        //Display faculty information
        if(faculty != null){
            System.out.println("Instructor: " + faculty.getName() + " (" + faculty.getTitle() + ")"); //Check this

        }else{
            System.out.println("Instructor: Not assigned!");
        }

        //Display roster
        System.out.println("Enrolled Students (" + roster.size() + "):");
        if(roster.isEmpty()){
            System.out.println(" No Students enrolled");
        }else{
            for(Student student : roster){
                System.out.println("  -  " + student.getName() + " (" + student.getId() +")");
            }
        }
        System.out.println("---------------------------\n");
    }
    /* *Helper method to check if a student is enrolled
        *@param student the student to check
        *@return true if student is enrolled 
    */
    public boolean isStudentEnrolled(Student student){
        return roster.contains(student);
    }
    
    /*Returns the number of students enrolled
      @return Enrollment count 
    */
    public int getEnrollmentCount(){
        return roster.size();
    }
}