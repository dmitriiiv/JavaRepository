package task41;

import java.util.LinkedList;
import java.util.Queue;

public class Shop {
    private Queue<Buyer> buyers = new LinkedList<>();

    public Shop(int buyersQuantity) {
        for (int i = 1; i < buyersQuantity + 1; i++) {
            int productsQuantity = (int) (Math.random() * 4 + 1);
            buyers.add(new Buyer(productsQuantity, "Покупатель" + i));
        }
    }

    public Buyer findBuyer() {
        synchronized (buyers) {
            return buyers.poll();
        }
    }
}
