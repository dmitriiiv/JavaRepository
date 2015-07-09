package task42.dto;

public class Expense {
    private String payDate;
    private double amount;
    private int receiver;

    public Expense() {
    }

    public Expense(String payDate, int receiver, double amount) {
        this.payDate = payDate;
        this.amount = amount;
        this.receiver = receiver;
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
        return payDate + " " +
                " " + receiver +
                " " + amount;
    }
}
