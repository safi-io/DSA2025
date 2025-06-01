package Assignments.Theory_Four;

public class Transaction {
    private int transactionId;
    private String customerName;
    private float amount;

    public Transaction(int transactionId, String customerName, float amount) {
        this.transactionId = transactionId;
        this.customerName = customerName;
        this.amount = amount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public float getAmount() {
        return amount;
    }


    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "{ " + transactionId + ", " + customerName + ", " + amount + " }";
    }
}

