package AcademicPortal;


public class AcademicPortalTest {
    public static void main(String[] args) {
        System.out.println(" ============================== ");
        System.out.println("    ACADEMIC PORTAL SYSTEM ");
        System.out.println("     Group 8 OOP Project Demonstaration");
        System.out.println(" ===============================\n");

        // ===================PHASE 1: SETUP PORTAL AND CREATE OBJECTS ===============
        System.out.println(" PHASE 1: SETTING UP THE SYSTEM");
        System.out.println(" ---------------------------------- ");

        //Create a Portal instance
        Portal academicPortal = new Portal();
        System.out.println();

        // ============= DEMONSTRATE INHERITANCE & CREATE OBJECTS ===================
        System.out.println(" CREATING STUDENTS AND FACULTY (INHERITANCE)");
        System.out.println("----------------------------------------");

        //Create Students (inherit from Person)
        Student student1 = new Student("S001", "Abdi Amante", "abdiamante12@ambou.edu.et", "Information Technology");
        Student student2 = new Student("S002", "Begna Rebuma", "begnarebuma23@ambou.edu", "Computer Science");
        Student student3 = new Student("S003", "Bontu Solomon", "bonisolomon13@ambou.edu.et", "Electrical Engineering");
        Student student4 = new Student("S004", "Simera Lamesa", "simeralamesa@ambou.edu.et", "Civil Engineering");
        Student student5 = new Student("S005", "Roba Taresa", "robataresa43@ambou.edu.et", "Urban Engineering");

        System.out.println("-----------------------------");

        //Create Students (inherits from Person)
        Faculty faculty1 = new Faculty("F001", "Dr.Gemachis", "gemachis@ambou.edu.et", "Data Science", "Data Scientist");
        Faculty faculty2 = new Faculty("F002", "Prof.Ebisa", "ebisa@ambou.edu.et", "SoftWare Engineering", "Associate Professor");
        Faculty faculty3 = new Faculty("F003", "Mr.Debela", "debela1@ambou.edu.et", "Electrical Engineering", "Lecturer");
        Faculty faculty4 = new Faculty("F004", "Mr.Samuel", "same@ambou.edu.et", "Computer Science", "Lecturer");


            System.out.println("\n Created 5 Students and 3 Faculty members.");

            // ============= DEMONSTRATE POLYMORPHISM & STATIC MEMBERS ======================
            System.out.println("\n🎭  PHASE 2: DEMONSTRATING POLYMORPHISM & STATIC MEMBERS");
            System.out.println("--------------------------------------------");
            
            // Add both Students and Faculty to the Same ArrayList<Person>(Polymorphism)
            System.out.println("\nAdding all members to static all Members list:");

            System.out.println("-------------------------------------");

            Portal.addPerson(student1);
            Portal.addPerson(student2);
            Portal.addPerson(student3);
            Portal.addPerson(student4);
            Portal.addPerson(student5);
            Portal.addPerson(faculty1);
            Portal.addPerson(faculty2);
            Portal.addPerson(faculty3);
             Portal.addPerson(faculty4);

            // Try to add duplicate (should show error)
            System.out.println("\nTrying to add duplicate ID (Testing validation):");
            Portal.addPerson(new Student("S001", "Duplicate", "dup@edu.et", "English"));
            System.out.println("\n Total Members in system: " + Portal.getTotalMembers() + " (Static member accessed)");

            //Display all members (Polymorphic method calls)
            System.out.println("\nDisplaying all members polymorphic display info() calls):");

            System.out.println("------------------------------------------");
            Portal.displayAllMembers();

            // ================= DEMONSTRATE ENCAPSULATION ==================
            System.out.println(" PHASE 3: DEMONSTRATING ENCAPSULATION");
            System.out.println("-------------------------------------------");

         // Accessing private fields through public getters/setters
         System.out.println("\nAccessing and modifying private fields through getters/setters:");
         
         System.out.println("Before Update - Student 1 GPA: " + student1.getGpa());
         student1.setGpa(3.9);
         System.out.println("After update - Student 1 GPA: " + student1.getGpa());
         
         // Try invalid GPA (Validation in setter)
         System.out.println("\n PHASE 4: CREATING COURSE");
         System.out.println("--------------------------");

         Course oopCourse = new Course("CSO201", "Object-Oriented Programming", 3);
         Course dataBase = new Course("CSD201", "Fundamental Data Base", 3);
         Course linearAlgebra = new Course("CSL201", "Linear Algebra", 3);
         Course staticsProbability = new Course("CST201", "Statics & Probability", 3);

         

         //Add Courses to Portal
         academicPortal.addCourse(oopCourse);
         academicPortal.addCourse(dataBase);
         academicPortal.addCourse(linearAlgebra);
         academicPortal.addCourse(staticsProbability);

         System.out.println("\nDisplaying all Courses:");
         academicPortal.displayAllCourses();

         //============== DEMONSTATE TWO-WAY RELATIONSHIP ===============
         System.out.println(" PHASE 5: DEMONSTATING TWO-WAY RELATIONSHIPS");
         System.out.println("-------------------------------------------");

         // Assign faculty to courses (Updates both Course.faculty And Faculty.teachingCourses )
         System.out.println("\n1.ASSIGNING FACULTY TO COURSES:");
         System.out.println("--------------------------------------");
         academicPortal.assignFaculyToCourse("F001", "CSO201"); //Dr.Gemachis
         academicPortal.assignFaculyToCourse("F002", "CSD201");
         academicPortal.assignFaculyToCourse("F003", "CSL201");
         academicPortal.assignFaculyToCourse("F004", "CST201");
         

        System.out.println("\n2. ENROLLING STUDENTS IN COURSES:");
        System.out.println("------------------------------------------");
        System.out.println("(Each enrollement updates both Course.roster And Student.enrolledCourses)");

        // Enroll Student (Updates both Course.roster and Student.enrolledCourses)
        academicPortal.enrollStudentInCourse("S001", "CSO201");
        academicPortal.enrollStudentInCourse("S002", "CSD201");
        academicPortal.enrollStudentInCourse("S003", "CSL201");
        academicPortal.enrollStudentInCourse("S004", "CST201");
        academicPortal.enrollStudentInCourse("S005", "CSD201");

        academicPortal.enrollStudentInCourse("S003", "CS0201");

       
        // ================ DEMONSTRATE R/Ship INTEGRITY ==================
        System.out.println("\n PHASE 6: VERIFYING TWO-WAY R/SHIP");
        System.out.println("-------------------------------------------------");

        // Check that r/ship are mainted on both sides
        System.out.println("\n. Checking OOP Course details: ");
        oopCourse.displayCourseInfo();

        System.out.println("\n2. Checking Student 1 enrolled courses:");
        System.out.println("Abdi IS enrolled in " + student1.getEnrolledInCourses().size() + " courses:");

        for (Course course : student1.getEnrolledInCourses()){
            System.out.println("  -  " + course.getCourseName());

        }

        System.out.println("\n3. Checking Faculty 1 teaching courses:"); //Dr.Gemachis
        System.out.println("Dr. Gemachis is teaching " + faculty1.getTeachingCourses().size() + " courses:");
        for (Course course : faculty1.getTeachingCourses()){
            System.out.println("  -  " + course.getCourseName());
        }
        
        // ============ DEMONSTRATE SEARCH FUNCTIONALITY ================
        System.out.println("\n  PHASE 7: DEMONSTRATING SEARCH FUNCTIONALITY");
        System.out.println("-----------------------------------------");

        // Using static findPerson method
        System.out.println("\nSearching for person with ID 'S003':");
        Person foundPerson = Portal.findPerson("S003");
        if (foundPerson != null){
            System.out.println("Found: ");
            foundPerson.displayInfo();
        }

        System.out.println("\nSeaerching for non-existent ID 'S010':");
        Person notFound = Portal.findPerson("S010");
        if (notFound == null){
            System.out.println("Person not found (returns null)");
        }

        // ============== DEMONSTRATE GPA CALCULATION ====================
        System.out.println("\n PHASE 8: DEMONSTRATING GPA CALCULATION");
        System.out.println("-----------------------------------------");

        //Update some GPAs for demonstration
        student1.setGpa(3.7);
        student2.setGpa(3.85);
        student3.setGpa(3.46);
        student4.setGpa(3.5);

        System.out.println("\nCalculating Gpas:");
        academicPortal.calculateStudentGPA("S001");
        academicPortal.calculateStudentGPA("S002");
        academicPortal.calculateStudentGPA("S003");
        academicPortal.calculateStudentGPA("S004");


        // ==================== FINAL SYSTEM SUMMARY ==================
        System.out.println("\n PHASE 9: FINAL SYSTEM SUMMARY");
        System.out.println("----------------------------------------");

        System.out.println("\n=== SYSTEM STATISTICS ===");
        System.out.println("Total Members: " + Portal.getTotalMembers());
        System.out.println("Total Courses: " + academicPortal.getAllCoursesCount());

        System.out.println("=============================================");
        System.out.println("\n=== ALL COURSES ===");
        academicPortal.displayAllCourses();

        System.out.println("===================================");
        System.out.println(" TEST COMPLETED SUCCESSFULLY!!!");
        System.out.println("=======================================\n");

        System.out.println(" OOP CONCEPTS DEMONSTRATION:");
        System.out.println(" Inheritance (Student/Faculty extends Person)");
        System.out.println(" Polymorphism (ArrayList<Person> holds differen types");
        System.out.println(" Static Members (allMembers shared across System)");
        System.out.println(" Encapsulation (private fields with getthers/setters)");
        System.out.println(" ArrayList Management (Dynami collections)");
        System.out.println("\n Project 8: Academic Portal - READY FOR SUBMISSION!");

    }
    // helper method to get course count(nedds to be added to Portal class)
    // If you want this to work, add this method to Portal.java:
    // public int getAllCoursesCount() {return allCourses.size();}
 }
