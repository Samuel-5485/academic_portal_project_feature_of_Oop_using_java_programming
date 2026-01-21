package AcademicPortal;
import java.util.Objects;

public abstract class Person {
    //Private fields for encapsulation
    private String id;
    private String name;
    private String email;
    
    //Constructor to initialize a Person object
    public Person(String id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }
    // ---Setters and Getters (Encapsulation)---
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    /*
      *Display information about the person
      *This method will be overridden by subclasses 
       to add more specific details
    */

    public void displayInfo(){
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
    /*Compare Persons based on their ID for equality */
    
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(id, person.id); //import Objects
    }

    public int hashCode(){
        return Objects.hash(id);
    }
    }

