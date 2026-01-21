package AcademicPortal;

import java.util.Scanner;

public class AcademicPortalMenu {
    /**
     * The Portal object is static so that all menu operations use a single,
     *  shared system instance instead of creating multiple empty portals.
     */
     private static Portal portal = new Portal(); //shared portal instances
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Welcome to Academic Portal");
       // System.out.println(" ======ACADEMIC PORTAL GROUP 8 PROJECT======");
        //System.out.println("===========================================");

        while (true){
            System.out.println("\n======MAIN MENU======:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Faculty");
            System.out.println("3. Add Course");
            System.out.println("4. Enroll Student");
            System.out.println("5. Assign Faculty");
            System.out.println("6. Show All Data");
            System.out.println("7. Exit");
            System.out.println("Enter choice: ");

    
            int choice = scanner.nextInt();
            scanner.nextLine(); //clear buffer

            switch (choice){
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    addFaculty(scanner);
                    break;
                case 3:
                    addCourse(scanner);
                    break;
                case 4:
                    enrollStudent(scanner);
                    break;
                case 5:
                    assignFacultyToCourse(scanner);
                    break;
                case 6:
                    displayAllData();
                    break;
                case 7:
                    System.out.println(" Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println(" Invalid choice!");
            }
        }
    }
    private static void addStudent(Scanner scanner){ 
        System.out.println("\n👨‍🎓 === ADD STUDENT ===");
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Major: ");
        String major = scanner.nextLine();
    
                    Student student = new Student(id, name, email, major);
                    Portal.addPerson(student); //static member
                    System.out.println("✅ Student added!");
    }
    private static void addFaculty(Scanner scanner){
                        System.out.println("\n👨‍🏫 === ADD FACULTY ===");
                        System.out.println("Faculty ID: ");
                        String id = scanner.nextLine();
                        System.out.println("Name: ");
                        String name = scanner.nextLine();
                        System.out.println("Email: ");
                        String email = scanner.nextLine();//check this part
                        System.out.println("Departement: ");
                        String dept = scanner.nextLine();
                        System.out.println("Title: ");
                        String title = scanner.nextLine();

                        Faculty faculty = new Faculty(id, name, email, dept, title);
                        Portal.addPerson(faculty);//static member
                        System.out.println("✅ Faculty added!");
    }
    private static void addCourse(Scanner scanner){     
                            System.out.println("\n📚 === ADD COURSE ===");             
                            System.out.println("Course ID: ");
                            String id = scanner.nextLine();
                            System.out.println("Course Name: ");
                            String name = scanner.nextLine();
                            System.out.println("Credit Hours: ");
                            int credits = scanner.nextInt();
                            scanner.nextLine();//clear buffer

                            Course course = new Course(id, name, credits);
                            Portal portal = new Portal();
                            portal.addCourse(course); //use shared portal instance
                            System.out.println("✅ Course added!");
    }
    private static void enrollStudent(Scanner scanner){
                                System.out.println("\n🎓 === ENROLL STUDENT ==="); 
                                System.out.println("Student ID: ");
                                String enrollSid = scanner.nextLine();
                                System.out.println("Course ID: ");
                                String enrollCid = scanner.nextLine();
                                
                               // Portal portal = new Portal();
                                portal.enrollStudentInCourse(enrollSid, enrollCid); //shared portal instance
    }
    private static void assignFacultyToCourse(Scanner scanner){ 
        System.out.println("\n👨‍🏫 === ASSIGN FACULTY ===");
        System.out.print("Faculty ID: ");
        String facultyId = scanner.nextLine();
        System.out.print("Course ID: ");
        String courseId = scanner.nextLine();

       // Portal portal = new Portal();
        portal.assignFacultyToCourse(facultyId, courseId); //shared portal instance
    }
    private static void displayAllData(){
                                    System.out.println("\n📄 === ALL DATA ===");
                                    Portal.displayAllMembers(); //static members
                                    portal.displayAllCourses(); //instance courses
                                    System.out.println("✅ All data displayed!");
                                   
            }

        }
    
