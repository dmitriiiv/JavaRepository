package task41;

//Напишите программу, моделирующую кассы в магазине.
//Существует несколько касс, работающих одновременно.
//Общее количество покупателей может быть больше чем количество касс,
//но одновременно не может обрабатываться больше покупателей, чем имеется рабочих касс.
//У каждого покупателя есть набор товаров, которые  должны быть выведены  в процессе обслуживания.

public class TaskTest {

    public static void main(String[] args) {
        Shop shop = new Shop(7);
        CashDesk cashDesk1 = new CashDesk("Касса 1", 500, shop);
        CashDesk cashDesk2 = new CashDesk("Касса 2", 700, shop);
        cashDesk1.start();
        cashDesk2.start();
        try {
            cashDesk1.join();
            cashDesk2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
