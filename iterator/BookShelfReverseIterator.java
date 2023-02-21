package iterator;

public class BookShelfReverseIterator implements Iterator {
    private BookShelf bookShelf;
    private int index;

    public BookShelfReverseIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        index = bookShelf.getLength() - 1;
    }

    @Override
    public Object first() {
        Book book = bookShelf.getBook(index);
        return book;
    };

    @Override
    public Object next() {
        Book book;
        if (!this.isDone()) {
            System.out.println("마지막 책꽂이입니다!");
            book = bookShelf.getBook(0);
            return book;
        }
        book = bookShelf.getBook(index);
        index--;
        return book;
    }

    @Override
    public boolean isDone() {
        return index >= 0;
    }

    @Override
    public Object currentItem() {
        return bookShelf.getBook(index);
    };
}