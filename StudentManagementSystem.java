package Task3;
import java.util.*;




public class StudentManagementSystem 
{

    private List<Student> student;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void removeStudent(int rollNumber) {
        boolean removed = false;
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getRollNumber() == rollNumber) {
                students.remove(i);
                removed = true;
                System.out.println("Student removed successfully.");
                break;
            }
        }
        if (!removed) {
            System.out.println("Student not found with roll number: " + rollNumber);
        }
    }

    public void searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("Student found:");
                System.out.println("Name: " + student.getName());
                System.out.println("Roll Number: " + student.getRollNumber());
                System.out.println("Grade: " + student.getGrade());
                return;
            }
        }
        System.out.println("Student not found with roll number: " + rollNumber);
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("All Students:");
            for (Student student : students) {
                System.out.println("Student:");
                System.out.println("Name: " + student.getName());
                System.out.println("Roll Number: " + student.getRollNumber());
                System.out.println("Grade: " + student.getGrade());
                System.out.println();
            }
        }
    }

    public static void main(String[] args) 
    {
        StudentManagementSystem system = new StudentManagementSystem();
        try (Scanner sc = new Scanner(System.in)) {
            while (true) 
            {
                System.out.println("Student Management System");
                System.out.println("1. Add Student");
                System.out.println("2. Remove Student");
                System.out.println("3. Search Student");
                System.out.println("4. Display All Students");
                System.out.println("5. Exit");
                System.out.println("Enter your choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) 
                {
                    case 1:
                        System.out.println("Enter name: ");
                        String name = sc.nextLine();
                        System.out.println("Enter roll number: ");
                        int rollNumber = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter grade: ");
                        String grade = sc.nextLine();

                        Student student = new Student(name, rollNumber, grade);
                        system.addStudent(student);
                        break;

                    case 2:
                        System.out.println("Enter roll number of the student to remove: ");
                        int removeRollNumber = sc.nextInt();
                        sc.nextLine();

                        system.removeStudent(removeRollNumber);
                        break;

                    case 3:
                        System.out.println("Enter roll number of the student to search: ");
                        int searchRollNumber = sc.nextInt();
                        sc.nextLine();

                        system.searchStudent(searchRollNumber);
                        break;

                    case 4:
                        system.displayAllStudents();
                        break;

                    case 5:
                        System.out.println("Exiting the application. Goodbye!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        }
    }
}