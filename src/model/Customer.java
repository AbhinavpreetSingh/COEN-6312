package model;

import java.util.Arrays;
import java.util.Objects;

public class Customer {
    private int id;
    private String name;
    private Item[] item;
    private Transaction[] transaction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item[] getItem() {
        return item;
    }

    public void setItem(Item[] item) {
        this.item = item;
    }

    public Transaction[] getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction[] transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", item=" + Arrays.toString(item) +
                ", transaction=" + Arrays.toString(transaction) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return getId() == customer.getId() && Objects.equals(getName(), customer.getName()) && Arrays.equals(getItem(), customer.getItem()) && Arrays.equals(getTransaction(), customer.getTransaction());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getName());
        result = 31 * result + Arrays.hashCode(getItem());
        result = 31 * result + Arrays.hashCode(getTransaction());
        return result;
    }
}
