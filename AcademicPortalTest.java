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
    }
}
