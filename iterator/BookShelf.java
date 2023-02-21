package iterator;

public class BookShelf implements Aggregate {
    private Book[] books; // 책의 집합
    private int count; // 마지막 책이 꽂힌 위치

    public BookShelf(int maxsize) {
        books = new Book[maxsize];
        this.count = 0;
    }

    protected Book getBook(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        if (count < books.length) {
            this.books[count] = book;
            count++;
        } else {
            System.out.println("책꽂이가 꽉 찼습니다!");
        }
    }

    @Override
    public BookShelfIterator createIterator() {
        return (BookShelfIterator) new IteratorFactory().create(this, 0);
    }

    @Override
    public BookShelfReverseIterator createReverseIterator() {
        return (BookShelfReverseIterator) new IteratorFactory().create(this, 1);
    }

    @Override
    public int getLength() {
        return count;
    }
}
