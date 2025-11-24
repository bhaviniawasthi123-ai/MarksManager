import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int marks;

    Student(String n, int m) {
        this.name = n;
        this.marks = m;
    }
}

public class MarksOfStudent {

    static ArrayList<Student> stu = new ArrayList<>();

    public static void addStudent() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name of the student: ");
        String name = sc.nextLine();

        System.out.print("Enter his/her marks: ");
        int marks = sc.nextInt();
        sc.nextLine(); // flush

        stu.add(new Student(name, marks));
        System.out.println("Added!");
    }

    public static void viewStudents() {
        if (stu.isEmpty()) {
            System.out.println("Students not found");
            return;
        }

        System.out.println("\n=== STUDENT LIST ===");
        for (Student s : stu) {
            System.out.println("Name: " + s.name + " | Marks: " + s.marks);
        }
    }

    public static void saveToFile() {
        try {
            FileWriter fw = new FileWriter("students.txt");

            for (Student s : stu) {
                fw.write(s.name + "," + s.marks + "\n");
            }

            fw.close();
            System.out.println("Saved to students.txt");
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== STUDENT MARKS MANAGEMENT ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Save to File");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addStudent(); 
                       break;
                case 2: viewStudents();
                       break;
                case 3: saveToFile();
                       break;
                case 4: System.out.println("Exiting...");
                       return;
                default:
                	    System.out.println("Invalid choice!");
            }
        }
    }
}

