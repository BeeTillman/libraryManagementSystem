package Library;
import java.util.Scanner;
public class Books {

    public Book[] bookList = new Book[100];
    Scanner input = new Scanner(System.in);
    public int bookCount = 0;

    // Compare two books for equality
    public int compareBooks(Book b1, Book b2){
        if (b1.bookName.equalsIgnoreCase(b2.bookName)){
            System.out.println("A book with the same name already exists in the library.");
            return 1;
        }
        else if (b1.sNo.equalsIgnoreCase(b2.sNo)){
            System.out.println("A book with the same serial number already exists in the library.");
            return 1;
        }
        else{
            return 0;
        }
    }

    // Add a book to the library
    public void addBook(Book b){
        // Check if the book already exists in the library
        for (int i = 0; i < bookCount; i++){
            if (compareBooks(b, bookList[i]) == 1){
                return;
            }
        }
        // Make sure the library is not full, then add the book
        if (bookCount < 100){
            bookList[bookCount] = b;
            bookCount++;
        }
        else{
            System.out.println("The library is full. No more books can be added.");
        }
    }

    public void searchBySNo(){
        System.out.println("\t\t\t\tSEARCH BY SERIAL NUMBER\n");

        String sNo;
        System.out.println("Enter the Serial Number of the Book: ");
        sNo = input.nextLine();

        int flag = 0;
        System.out.println(
                "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
        for (int i = 0; i < bookCount; i++){
            if (bookList[i].sNo.equalsIgnoreCase(sNo)){
                System.out.println(
                        bookList[i].sNo + "\t\t"
                                + bookList[i].bookName + "\t\t"
                                + bookList[i].authorName + "\t\t"
                                + bookList[i].bookQtyCurrent + "\t\t"
                                + bookList[i].bookQtyTotal);
                flag++;
                return;
            }
            if (flag == 0){
                System.out.println("No book with Serial Number\n" + sNo + "\nfound in the library.\n");
            }
        }
    }

    public void searchByAuthor(){
        System.out.println("\t\t\t\tSEARCH BY AUTHOR\n");

        String authorName;
        System.out.println("Enter the Name of the Author: ");
        authorName = input.nextLine();

        int flag = 0;
        System.out.println(
                "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
        for (int i = 0; i < bookCount; i++){
            if (bookList[i].authorName.equalsIgnoreCase(authorName)){
                System.out.println(
                        bookList[i].sNo + "\t\t"
                                + bookList[i].bookName + "\t\t"
                                + bookList[i].authorName + "\t\t"
                                + bookList[i].bookQtyCurrent + "\t\t"
                                + bookList[i].bookQtyTotal);
                flag++;
            }
        }
        if (flag == 0){
            System.out.println("No book by the author\n" + authorName + "\nfound in the library.\n");
        }
    }

    public void displayAllBooks(){
        System.out.println("\t\t\t\tDISPLAY ALL BOOKS\n");
        System.out.println(
                "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
        for (int i = 0; i < bookCount; i++){
            System.out.println(
                    bookList[i].sNo + "\t\t"
                            + bookList[i].bookName + "\t\t"
                            + bookList[i].authorName + "\t\t"
                            + bookList[i].bookQtyCurrent + "\t\t"
                            + bookList[i].bookQtyTotal);
        }
    }

    public void updateBookQty(){
        System.out.println("\t\t\t\tUPDATE BOOK QUANTITY\n");

        String sNo;
        System.out.println("Enter the Serial Number of the Book: ");
        sNo = input.nextLine();

        int flag = 0;
        for (int i = 0; i < bookCount; i++){
            if (bookList[i].sNo.equalsIgnoreCase(sNo)){
                System.out.println("Enter the new Quantity of the Book: ");
                bookList[i].bookQtyCurrent = input.nextInt();
                flag++;
                return;
            }
        }
        if (flag == 0){
            System.out.println("No book with Serial Number\n" + sNo + "\nfound in the library.\n");
        }
    }

    public void dispMenu()
    {

        // Displaying menu
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        System.out.println("Press 1 to Add new Book.");
        System.out.println("Press 0 to Exit Application.");
        System.out.println(
                "Press 2 to Upgrade Quantity of a Book.");
        System.out.println("Press 3 to Search a Book.");
        System.out.println("Press 4 to Show All Books.");
        System.out.println("Press 5 to Register Student.");
        System.out.println(
                "Press 6 to Show All Registered Students.");
        System.out.println("Press 7 to Check Out Book. ");
        System.out.println("Press 8 to Check In Book");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------");
    }

    public int isAvailable(String sNo){
        for (int i = 0; i < bookCount; i++){
            if (bookList[i].sNo.equalsIgnoreCase(sNo)){
                if (bookList[i].bookQtyCurrent > 0){
                    System.out.println("The book is available for checkout.");
                    return 1;
                }
                else{
                    System.out.println("The book is not available for checkout.");
                    return 0;
                }
            }
        }
        System.out.println("No book with Serial Number\n" + sNo + "\nfound in the library.\n");
        return -1;
    }

    public Book checkOutBook(){
        System.out.println("\t\t\t\tCHECK OUT BOOK\n");

        String sNo;
        System.out.println("Enter the Serial Number of the Book: ");
        sNo = input.nextLine();

        if (isAvailable(sNo) == 1){
            for (int i = 0; i < bookCount; i++){
                if (bookList[i].sNo.equalsIgnoreCase(sNo)){
                    bookList[i].bookQtyCurrent--;
                    System.out.println("The book has been checked out.");
                    return bookList[i];
                }
            }
        }
        return null;
    }

    public void checkInBook(Book b){
        for(int i = 0; i < bookCount; i++){
            if (compareBooks(b, bookList[i]) == 1){
                bookList[i].bookQtyCurrent++;
                return;
            }
        }
    }
}
