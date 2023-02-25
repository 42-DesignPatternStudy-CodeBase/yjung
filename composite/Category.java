package composite;
import java.util.ArrayList;

class Category extends ProductCategory {
    ArrayList<ProductCategory> data = new ArrayList<ProductCategory>();
    int cnt;

    public Category(int id, String name, int price) {
        super(id, name, price);
        cnt = 0;
    }
    @Override
    public void addProduct(ProductCategory product) { data.add(product); }
    @Override
    public void removeProduct(ProductCategory product) {
        if (cnt == 0)
            return ;
        data.remove(product);
    }
    @Override
    public int getCount() {
        for (ProductCategory productCategory : data) {
            cnt += productCategory.getCount();
        }
        return cnt;
    }
    @Override
    public String getName() { return data.toString(); }
    @Override
    public int getPrice() {
        for (ProductCategory productCategory : data) {
            price += productCategory.getPrice();
        }
        return price;
    }
    @Override
    public int getId() { return id; }
}
