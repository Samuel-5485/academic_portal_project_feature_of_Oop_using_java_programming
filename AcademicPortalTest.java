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
        Faculty facult1 = new Faculty("F001", "Dr.Gemachis", "gemachis@ambou.edu.et", "Data Science", "Data Scientist");
        Faculty faculty2 = new Faculty("F002", "Prof.Ebisa", "ebisa@edu.et", "SoftWare Engineering", "Associate Professor");
        Faculty faculty3 = new Faculty("F003", "Mr.Debela", "debela1@edu.edu.et", "Electrical Engineering", "Lecturer");

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
            Portal.addPerson(facult1);
            Portal.addPerson(faculty2);
            Portal.addPerson(faculty3);

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
         Course statics = new Course("CST201", "Statics & Probability", 3);
         

         //Add Courses to Portal
         academicPortal.addCourse();
    }
}
