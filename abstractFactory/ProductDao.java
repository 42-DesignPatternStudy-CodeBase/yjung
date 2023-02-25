package abstractFactory;

public abstract class ProductDao {
    abstract public void insertProduct(Product product);
    abstract public void updateProduct(Product product);
    abstract public void deleteProduct(Product product);
}
