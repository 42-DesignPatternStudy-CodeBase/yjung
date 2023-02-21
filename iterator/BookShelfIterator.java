package iterator;

public class BookShelfIterator implements Iterator {
    private BookShelf bookShelf;
    private int index = 0;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    @Override
    public Object first() {
        Book book = bookShelf.getBook(0);
        return book;
    };

    @Override
    public Object next() {
        Book book;
        if (!this.isDone()) {
            System.out.println("책꽂이가 꽉 찼습니다!");
            book = bookShelf.getBook(bookShelf.getLength());
            return book;
        }
        book = bookShelf.getBook(index);
        index++;
        return book;
    }

    @Override
    public boolean isDone() {
        return index < bookShelf.getLength();
    }

    @Override
    public Object currentItem() {
        return bookShelf.getBook(index);
    };
}
