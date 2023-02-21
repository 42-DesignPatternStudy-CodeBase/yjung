package iterator;
import java.util.*;

public class IteratorTest {
    public static void main(String[] args) {
        Iterator it;
        ArrayList<Integer> list;
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Around the World in 80 Days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));

        it = bookShelf.createIterator();
        while (it.isDone()) {
            Book book = (Book) it.next();
            System.out.println("" + book.getName());
        }

        System.out.println("================");

        it = bookShelf.createReverseIterator();
        while (it.isDone()) {
            Book book = (Book) it.next();
            System.out.println("" + book.getName());
        }

    }
}
