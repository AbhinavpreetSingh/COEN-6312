package model;

import java.time.LocalDateTime;

public class Transaction {
    private int itemId;
    private int quantity;
    private LocalDateTime timestamp;

    public Transaction(int itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.timestamp = LocalDateTime.now();
    }

    // Getters (you can generate them using your IDE)

    public int getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Transaction [itemId=" + itemId + ", quantity=" + quantity + ", timestamp=" + timestamp + "]";
    }
}

