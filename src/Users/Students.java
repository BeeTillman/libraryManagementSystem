package Users;
import Library.Book;
import Library.Books;

import java.util.Scanner;
public class Students {
    public Student[] studentList = new Student[100];
    Scanner input = new Scanner(System.in);
    public int studentCount = 0;

    public int compareStudents(Student s1, Student s2){
        if (s1.studentID.equalsIgnoreCase(s2.studentID)){
            System.out.println("A student with the same ID already exists in the library.");
            return 0;
        }
        else{
            return 1;
        }
    }

    public void addStudent(Student s){
        for (int i = 0; i < studentCount; i++){
            if (compareStudents(s, studentList[i]) == 0){
                return;
            }
        }
        if (studentCount < 100){
            studentList[studentCount] = s;
            studentCount++;
        }
        else{
            System.out.println("The library is full. No more students can be added.");
        }
    }

    public void displayStudents(){
        System.out.println("\t\t\t\tSTUDENTS\n");
        System.out.println("Name\t\tID");
        for (int i = 0; i < studentCount; i++){
            System.out.println(studentList[i].studentName + "\t\t" + studentList[i].studentID);
        }
    }

    public int isStudent(){
        System.out.println("\t\t\t\tSTUDENT CHECK\n");
        String studentID;
        System.out.println("Enter the ID of the Student: ");
        studentID = input.nextLine();
        for (int i = 0; i < studentCount; i++){
            if (studentList[i].studentID.equalsIgnoreCase(studentID)){
                System.out.println("The student is a member of the library.");
                return i;
            }
        }
        System.out.println("The student is not a member of the library.");
        return -1;
    }

    public void checkOutBook(Books book)
    {
        int studentIndex = this.isStudent();

        if (studentIndex != -1) {
            System.out.println("checking out");

            book.displayAllBooks();
            Book b = book.checkOutBook();

            System.out.println("checking out");
            if (b != null) {

                if (studentList[studentIndex].studentBookCount
                        <= 5) {

                    System.out.println("adding book");
                    studentList[studentIndex].studentBooks
                            [studentList[studentIndex]
                            .studentBookCount]
                            = b;
                    studentList[studentIndex].studentBookCount++;

                    return;
                }
                else {

                    System.out.println(
                            "Student Can not Borrow more than 5 Books.");
                    return;
                }
            }
            System.out.println("Book is not Available.");
        }
    }

    public void checkInBook(Books book)
    {
        int studentIndex = this.isStudent();

        if (studentIndex != -1) {
            System.out.println(
                    "S.No\t\t\tBook Name\t\t\tAuthor Name");
            Student s = studentList[studentIndex];

            for (int i = 0; i < s.studentBookCount; i++) {

                System.out.println(
                        s.studentBooks[i].sNo + "\t\t\t"
                                + s.studentBooks[i].bookName + "\t\t\t"
                                + s.studentBooks[i].authorName);
            }
            System.out.println(
                    "Enter Serial Number of Book to be Checked In:");
            String sNo = input.nextLine();
            for (int i = 0; i < s.studentBookCount; i++) {
                if (sNo == s.studentBooks[i].sNo) {
                    book.checkInBook(s.studentBooks[i]);
                    s.studentBooks[i] = null;

                    return;
                }
            }

            System.out.println("Book of Serial Number\n" + sNo
                    + "\nnot Found\n");
        }
    }
}
