package composite;

class Product extends ProductCategory {
    public Product(int id, String name, int price) {
        super(id, name, price);
    }

    @Override
    public void addProduct(ProductCategory product) { return; }
    @Override
    public void removeProduct(ProductCategory product) { return; }
    @Override
    public int getCount() { return 1; }
    @Override
    public String getName() { return name; }
    @Override
    public int getPrice() { return price; }
    @Override
    public int getId() { return id; }
}
