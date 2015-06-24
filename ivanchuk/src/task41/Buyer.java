package task41;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private String name;
    private List<String> products = new ArrayList<>();

    public Buyer(int productsQuantity, String name) {
        Product[] products = Product.values();
        this.name = name;
        for (int i = 0; i < productsQuantity; i++) {
            int productNumber = (int) (Math.random() * Product.values().length);
            this.products.add(products[productNumber].toString());
        }
    }

    @Override
    public String toString() {
        return name + ": " + products;
    }
}
