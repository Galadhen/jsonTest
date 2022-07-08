package Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    @JsonProperty("delivery_to_door")
    private boolean deliveryToDoor;
    @JsonProperty("full_address")
    private String fullAddress;


    public Address(boolean deliveryToDoor, String fullAddress) {
        this.deliveryToDoor = deliveryToDoor;
        this.fullAddress = fullAddress;
    }

    public Address() {
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public boolean isDeliveryToDoor() {
        return deliveryToDoor;
    }

    public void setDeliveryToDoor(boolean deliveryToDoor) {
        this.deliveryToDoor = deliveryToDoor;
    }

    @Override
    public String toString() {
        return ("\nFull address: " + getFullAddress() + "\n" +
                "Delivered to Door: "+ isDeliveryToDoor());
    }
}
