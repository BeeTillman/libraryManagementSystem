package Library;
import java.util.Scanner;

import Users.Student;
import Users.Students;
public class Library {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println(
                "********************Welcome to the BPT Library!********************");
        System.out.println(
                "                  Select From The Following Options:               ");
        System.out.println(
                "**********************************************************************");

        Books objBooks = new Books();
        Students objStudents = new Students();

        int choice;
        int searchChoice;

        do {

            objBooks.dispMenu();
            choice = input.nextInt();

            // Switch case
            switch (choice) {

                // Case
                case 1:
                    Book b = new Book();
                    objBooks.addBook(b);
                    break;

                // Case
                case 2:
                    objBooks.updateBookQty();
                    break;

                // Case
                case 3:

                    System.out.println(
                            " press 1 to Search with Book Serial No.");
                    System.out.println(
                            " Press 2 to Search with Book's Author Name.");
                    searchChoice = input.nextInt();

                    // Nested switch
                    switch (searchChoice) {

                        // Case
                        case 1:
                            objBooks.searchBySNo();
                            break;

                        // Case
                        case 2:
                            objBooks.searchByAuthor();
                    }
                    break;

                // Case
                case 4:
                    objBooks.displayAllBooks();
                    break;

                // Case
                case 5:
                    Student s = new Student();
                    objStudents.addStudent(s);
                    break;

                // Case
                case 6:
                    objStudents.displayStudents();
                    break;

                // Case
                case 7:
                    objStudents.checkOutBook(objBooks);
                    break;

                // Case
                case 8:
                    objStudents.checkInBook(objBooks);
                    break;

                // Default case that will execute for sure
                // if above cases does not match
                default:

                    // Print statement
                    System.out.println("ENTER BETWEEN 0 TO 8.");
            }

        }

        // Checking condition at last where we are
        // checking case entered value is not zero
        while (choice != 0);
    }
}
