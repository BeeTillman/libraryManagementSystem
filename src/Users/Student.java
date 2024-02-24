package Users;
import Library.Book;

import java.util.Scanner;
public class Student {
    public String studentName;
    public String studentID;
    int studentBookCount = 0;
    Book[] studentBooks = new Book[5];
    Scanner input = new Scanner(System.in);

    public Student(){
        System.out.println("Enter the Name of the Student: ");
        this.studentName = input.nextLine();

        System.out.println("Enter the ID of the Student: ");
        this.studentID = input.nextLine();
    }
}
