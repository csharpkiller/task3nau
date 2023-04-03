import Task2.ProductSet;
import Task2.TicketBase;
import Task4ver2.Book;
import Task4ver2.Library;
import Task4ver2.RequestCriterion;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        TicketBase ticketBase = new TicketBase();
//        ticketBase.addTicketInArchive("1337", ProductSet.EAT_AND_DRINKS);
//        ticketBase.addTicketInArchive("1337", ProductSet.DRINKS);
//        System.out.println(ticketBase.getFoodInfo("1337"));

        Library library = new Library();
        Book book1 = new Book("name", "test", "1500");
        Book book2 = new Book("Hey", "test", "1500");
        Book book3 = new Book("name", "test", "1501");
        Book book4 = new Book("name", "Lev", "1501");
        Book book5 = new Book("name2", "Lev", "1502");
        Book book6 = new Book("name3", "Lev2", "1503");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.deleteBook(book5);
        List<Book> res = library.getBooks(RequestCriterion.YEAR_DIAPASON, "1500-1502");
        for (Book e: res
             ) {
            System.out.println(e.getName() + " " + e.getAuthor() + " " + e.getYear());
        }
    }
}