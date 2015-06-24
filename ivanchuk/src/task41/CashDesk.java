package task41;

public class CashDesk extends Thread {
    private Shop shop;
    private String name;
    private int serviceTime;

    public CashDesk(String name, int serviceTime, Shop shop) {
        this.name = name;
        this.serviceTime = serviceTime;
        this.shop = shop;
    }

    @Override
    public void run() {
        Buyer buyer;
        while ((buyer = shop.findBuyer()) != null) {
            try {
                Thread.sleep(serviceTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + ": " + buyer.toString());
        }
    }
}
