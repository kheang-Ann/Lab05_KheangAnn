
import java.util.ArrayList;
import java.util.Scanner;

class Student_ implements Cloneable {
    String name;
    double ID;

    public Student_(String name, double  ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getID(){
        return ID;
    }

    public void setID(double ID){
        this.ID = ID;
    }

    @Override
    public Student_ clone(){
        try {
            return (Student_) super.clone();
        } catch (Exception e) {
            throw new RuntimeException("Cloning not supported");
        }
    }

    @Override
    public String toString(){
        return "\t " + ID + "\t\t " + name;
    }
}
class Work {
    private final ArrayList<Student_> student_s = new ArrayList<>();
    public void Add_Stu(Student_ stu) {
            student_s.add(stu);
            System.out.println("Student added succssfully");
    }
    public void update_stu(int index, String name, double ID){
        if (index >= 0 && index < student_s.size()){
            Student_ student = student_s.get(index);
            student.setName(name);
            student.setID(ID);
            System.out.println("Student updated successfully");
        } else {
            System.out.println("Invalid index");
        }
    }
    public void remove_stu(int index) {
        if (index >= 0 && index < student_s.size()){
            student_s.remove(index);
            System.out.println("Student removed successfully");
        } else {
            System.out.println("Invalid index");
        }
    }
    public void remove_all(){
        student_s.clear();
        System.out.println("Remove students successfully");
    }
    public void show_Stu(){
        if (student_s.isEmpty()){
            System.out.println("No students to display");
        } else {
            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println("|No  |     ID      |      Name        |");
            System.out.println("--------------------------------------");
            for (int i = 0; i < student_s.size(); i++){
                System.out.println("| "+(i + 1 ) +  ". |" +  student_s.get(i) );
            }
        }
    }
}
public class Student{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Work work = new Work();
        Student_ process = new Student_(null, 0);

        while (true) {
            System.out.println();
            System.out.println("---------------Menu--------------");
            System.out.println("1. List students");
            System.out.println("2. Add a new student (use prototype)");
            System.out.println("3. Create multiple students (use prototype)");
            System.out.println("4. Update a student by index");
            System.out.println("5. Remove a student by index");
            System.out.println("6. Remove all students");
            System.out.println("0. Exit");
            System.out.println("---------------------------------");
            System.out.print("> Choose an option: ");
            int choose = input.nextInt();
            input.nextLine();

            switch (choose) {
                case 1 -> work.show_Stu();

                case 2 -> {
                    Student_ newStu = process.clone();
                    System.out.print("Enter ID: ");
                    newStu.setID(input.nextDouble());
                    input.nextLine();
                    System.out.print("Enter Name: ");
                    newStu.setName(input.nextLine());

                    work.Add_Stu(newStu);
                }

                case 3 -> {
                    System.out.println("How many students to craete? ");
                    int count = input.nextInt();
                    input.nextLine();
                    for (int i = 0; i < count; i++){
                        Student_ newstu = process.clone();
                        System.out.print("Enter ID for student " + (i + 1 ) +": ");
                        newstu.setID(input.nextDouble());
                        input.nextLine();
                        System.out.print("Enter name of student " + (i + 1 ) + ": ");
                        newstu.setName(input.nextLine());

                        work.Add_Stu(newstu);
                    }
                }

                case 4 -> {
                    System.out.print("Enter the index to update (1-based): ");
                    int index = input.nextInt() - 1;
                    input.nextLine();
                    System.out.println("Enter new ID: ");
                    double id = input.nextDouble();
                    input.nextLine();
                    System.out.println("Enter new Name: ");
                    String name = input.nextLine();

                    work.update_stu(index, name, id);
                }

                case 5 -> {
                    System.out.println("Enter the index to remove (1-based): ");
                    int index = input.nextInt() - 1;
                    input.nextLine();
                    work.remove_stu(index);
                }

                case 6 -> work.remove_all();

                case 0 -> {
                    System.out.println("Exiting the program.....");
                    input.close();
                    return;
                }

                default -> System.out.println("Invalid choice. Please try again!");
            }
            
        }
    }
}
