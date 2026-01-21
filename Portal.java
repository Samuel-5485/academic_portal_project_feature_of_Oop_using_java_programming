package AcademicPortal;
import java.util.ArrayList;

public class Portal{
    //=================Static Members (Class-Level)==========
    /*
      *Static list holding all Person objects (Students and Faculty).
       This demonstrates: 
         1.Static member (shared across all Portal instances) 
         2.polymorphism (Student and Faculty stored as Person)
    */
   private static ArrayList<Person> allMembers = new ArrayList<Person>();
   
      //=================Instance Members===================
      /**
       * List of all courses in the system
       * Each Portal instance has its own list (non-static)
    */
   private ArrayList<Course> allCourses;
      /**
       * Constructor for Portal
       * Initializes the instance course list.   
    */
   public Portal(){
    this.allCourses = new ArrayList<>();
    System.out.println("New Portal instance created.");
   }

   //=============Static Methods (work with allMembers)==================
   /**
    * Adds any Person (Student or Faculty) to the static allMembers list. 
    * Demonstrates polymorphism - parameter is Person type. 
    * @param p The Person object to add(could be Student of Faculty) 
    */
   public static void addPerson(Person p){
    //Check if person already exists
    if(findPerson(p.getId()) != null){
        System.out.println(" Person with ID = " + p.getId() + " already exists!");
                return;
    }
    allMembers.add(p);
    System.out.println(p.getName() + " added to system.");
   }
   /**
     * Finds a person by their ID in the static allMembers list.
     * @param id The ID to search for
     * @return The Person object, or null if not found
     */
    public static Person findPerson(String id){
        for(Person person : allMembers){
            if(person.getId().equals(id)){
                return person;
            }
        }
        return null; //Not found
    }
    /**
     * Displays all members in the system (Students and Faculty).
     * Static method - can be called without creating Portal object.
     */
    public int getAllCoursesCount(){
        return allCourses.size();
    }
    public static void displayAllMembers(){
        System.out.println("\n ======== ALL SYSTEM MEMBERS =========");
        System.out.println("Total Members: " + allMembers.size());

        if(allMembers.isEmpty()){
            System.out.println("No members in the system.");
            return;
        }

        int studentCount = 0;
        int facultyCount = 0;

        for(Person person : allMembers){
            person.displayInfo();  //polymorphic call!

            //Count types
            //why we have used this 
            if(person instanceof Student){
                studentCount++;

            }else if(person instanceof Faculty){
                facultyCount++;  
            }
        }

        System.out.println(" Summary: " + studentCount + " Students, " + facultyCount + " Faculty");
        System.out.println("======================================\n");

    }

    //================ INSTANCE METHODS (Work with allCourses) ==================
    /**
     * Adds a course to this portal's course list.
     * @param course The course to add
     */
    public void addCourse(Course course){
        //Check if course already exists
        for(Course c : allCourses){
            if(c.getCourseId().equals(course.getCourseId())){
                System.out.println(" Course " + course.getCourseId() + " already exists!");
                return;
        }
    }
    allCourses.add(course);
    System.out.println("Course " + course.getCourseName() + " added to portal.");

    }
/**
     * Finds a course by ID in this portal's course list.
     * @param courseId The course ID to find
     * @return The Course object, or null if not found
*/
    public Course findCourse(String courseId){
        for(Course course : allCourses){
            if(course.getCourseId().equals(courseId)){
                return course;
            }
        }
        return null;
    }

     /**
     * Enrolls a student in a course.
     * This is a CRITICAL method that demonstrates relationship management.
     * @param studentId The ID of the student
     * @param courseId The ID of the course
     */
    public void enrollStudentInCourse(String studentId, String courseId){
        //1. Find the student
        Person person = findPerson(studentId);
        if(person == null){
            System.out.println(" Student with ID " + studentId + " not found!");
            return;
        }

        //2.Check if person is actually a Student
        if(!(person instanceof Student)){
            System.out.println(" ID " + studentId + " belongs to a Faculty member, not a Student!");
            return;          
        }

        Student student = (Student) person;  //why we have used this

        //3.Find the course
        Course course = findCourse(courseId);
        if(course == null){
            System.out.println(" Course with ID " + courseId + " not found!");
            return;
        }
        //4.Enroll student using Course's addStudent method
        //This will update both the course roster and student's enrolled Courses
        course.addStudent(student);       
    }
    /**
     * Calculates a student's GPA (simplified version).
     * In a real system, this would consider grades from all courses.
     * @param studentId The student's ID
     * @return The GPA value
     */
    public double calculateStudentGPA(String studentId){
        Person person = findPerson(studentId);

        if(person == null){
            System.out.println(" This ID belongs to a Faculty member!");
            return 0.0; 
        }

        Student student = (Student) person;
        // Simplified GPA calculation
        // In a real system, you would:
        // 1. Get all courses the student is enrolled in
        // 2. Get grades for each course
        // 3. Calculate weighted average based on credit hour

        double currentGPA = student.getGpa();
        System.out.println(" GPA for " + student.getName() + ": " + currentGPA);
        return currentGPA;
    }
    
     // Assigns a faculty member to teach a course.
      // @param facultyId The faculty member's ID
      // @param courseId The course ID
     
    public void assignFaculyToCourse(String facultyId, String courseId){
        //1. Find the faculty
        Person person = findPerson(facultyId);
            if(person == null){
                System.out.println("Faculty with ID " + facultyId + " not found!");
                return;
            }

            Faculty faculty = (Faculty) person;
            //3.Find th course
        Course course = findCourse(courseId);
            if(course == null){
                System.out.println(" Course with ID " + courseId + " not found!");
                return;
            }
            //4.Assign faculty using Course's assignFaculy method
            course.assignFaculy(faculty);
        }
      /**
        * Displays all courses in this portal.
     */
        public void displayAllCourses(){
            System.out.println("\n ======= ALL COURSES =======");
            System.out.println("Total Courses: " + allCourses.size());

            if(allCourses.isEmpty()){
                System.out.println("No course available.");
                return;
        }
        for(Course course : allCourses){
            course.displayCourseInfo();
        }

        System.out.println("===============================\n");

    }
    //============== UTILITY STATIC METHODS ==============
     /**
     * Gets the total number of members in the system.
     * @return Count of all members
     */
        public static int getTotalMembers(){
            return allMembers.size();
        }
    /**
     * Clears all members from the system (for testing/reset).
     * Use with caution!
    */
   public static void clearAllMembers(){
    allMembers.clear();
    System.out.println("All members cleared from system.");
        
   }
    }
