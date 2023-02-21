package iterator;

public abstract class Factory {
    public final Iterator create(Aggregate list, int type) {
        Iterator p = createProduct(list, type);
        return p;
    }

    protected abstract Iterator createProduct(Aggregate list, int type);
}

class IteratorFactory extends Factory {
    @Override
    protected Iterator createProduct(Aggregate list, int type) {
        if (type == 0) // 정방향
            return new BookShelfIterator((BookShelf) list);
        else if (type == 1) // 역방향
            return new BookShelfReverseIterator((BookShelf) list);
        return null;
    }
}
