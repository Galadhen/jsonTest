package Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class Order {
    private String number;
    private double total;
    @JsonProperty("item_count")
    private int itemCount;
    @JsonProperty("deliver_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date deliverAt;
    private Address address;

    private List<Shipments> shipments;

    public Order(String number, double total, int itemCount, Date deliverAt, Address address, List<Shipments> shipments) {
        this.number = number;
        this.total = total;
        this.itemCount = itemCount;
        this.deliverAt = deliverAt;
        this.address = address;
        this.shipments = shipments;
    }

    public Order() {
    }

    public Date getDeliverAt() {
        return deliverAt;
    }

    public void setDeliverAt(Date deliverAt) {
        this.deliverAt = deliverAt;

    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Shipments> getShipments() {
        return shipments;
    }

    public void setShipments(List<Shipments> shipments) {
        this.shipments = shipments;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return ("Order number: "+ getNumber() + "\n" +
                "Item Count: " + getItemCount() + "\n" +
                "Item total: " +getTotal() + "\n" +
                "Delivered at: "+ getDeliverAt() + "\n" +
                "Address: " + getAddress().toString() + "\n" +
                "shipments: " + getShipments().toString() + "\n"
        );
    }
}
