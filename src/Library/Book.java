package Library;
import java.util.Scanner;
public class Book {
    public String sNo;
    public String bookName;
    public String authorName;
    public int bookQtyTotal;
    public int bookQtyCurrent;

    Scanner input = new Scanner(System.in);
    public Book(){
        System.out.println("Enter the Name of the Book: ");
        this.bookName = input.nextLine();

        System.out.println("Enter the Name of the Author: ");
        this.authorName = input.nextLine();

        System.out.println("Enter the Quantity of the Books: ");
        this.bookQtyCurrent = input.nextInt();
        bookQtyTotal = this.bookQtyCurrent;

        this.sNo = "s" + this.bookName.substring(0, 3) + this.authorName.substring(0, 3) + this.bookQtyCurrent;
        System.out.println("The Serial Number of the Book is: " + this.sNo);
    }
}
