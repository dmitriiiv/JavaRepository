package task44.dto;

public class Expense {
    private int id;
    private String payDate;
    private double amount;
    private int receiver;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", payDate='" + payDate + '\'' +
                ", amount=" + amount +
                ", receiver=" + receiver +
                '}';
    }
}
