package Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Shipments {
    private String number;
    private double total;
    @JsonProperty("item_count")
    private int itemCount;

    public Shipments(String number, double total, int itemCount) {
        this.number = number;
        this.total = total;
        this.itemCount = itemCount;
    }

    public Shipments() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }
    @Override
    public String toString() {
        return ("\nNumber: " + getNumber() + "\n" +
                "Total: " + getTotal() + "\n" +
                "Item Count: " + getItemCount());
    }
}
