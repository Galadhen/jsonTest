import Objects.Address;
import Objects.Order;
import Objects.Shipments;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class Methods {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    public static void main(String[] args) throws IOException, ParseException {
        deserializeJson();
        serializeJson();
        createOrder();
    }

    public static void createOrder() throws ParseException {
        List<Shipments> shipments = new ArrayList<>();
        shipments.add(new Shipments("H4231",2,3));
        shipments.add(new Shipments("H1234",1.5,2));
        Order orderConstructor = new Order("H4231", 2.0,3,
                sdf.parse("2022-04-11T18:55:25.902Z"),
                new Address(true,"г.Москва, ул.Ленина, д.10, кв.6"),
                shipments);
        System.out.println(orderConstructor.toString());
    }

    public static void serializeJson() throws IOException, ParseException {

        ObjectMapper objectMapper = new ObjectMapper();
        Order order = new Order();
        Shipments firstShipment = new Shipments();

        firstShipment.setNumber("H4231");
        firstShipment.setTotal(2);
        firstShipment.setItemCount(3);

        Shipments secondShipment = new Shipments();

        secondShipment.setNumber("H1234");
        secondShipment.setItemCount(2);
        secondShipment.setTotal(1.5);

        Address adress = new Address();
        adress.setFullAddress("г.Москва, ул.Ленина, д.10, кв.6");
        adress.setDeliveryToDoor(true);

        order.setNumber("R0123");
        order.setTotal(3);
        order.setItemCount(5);
        order.setDeliverAt(sdf.parse("2022-04-11T18:55:25.902Z"));

        order.setAddress(adress);
        order.setShipments(Arrays.asList(firstShipment, secondShipment));


        String json = objectMapper.writeValueAsString(order);
        System.out.println(json);
    }

    public static void deserializeJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{\n" +
                "  \"order\": {\n" +
                "    \"number\": \"R0123\",\n" +
                "    \"total\": 3.5,\n" +
                "    \"item_count\": 5,\n" +
                "    \"deliver_at\": \"2022-04-11T18:55:25.902Z\",\n" +
                "    \"address\": {\n" +
                "      \"full_address\": \"г.Москва, ул.Ленина, д.10, кв.6\",\n" +
                "      \"delivery_to_door\": true\n" +
                "    },\n" +
                "    \"shipments\": [\n" +
                "      {\n" +
                "        \"number\": \"H4321\",\n" +
                "        \"total\": 2,\n" +
                "        \"item_count\": 3\n" +
                "      },\n" +
                "      {\n" +
                "        \"number\": \"H1234\",\n" +
                "        \"total\": 1.5,\n" +
                "        \"item_count\": 2\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";
        Map<String, Order> orders = objectMapper.readValue(json,
                new TypeReference<Map<String, Order>>(){});
        Order order = orders.get("order");
        System.out.println(order.toString());
    }
}

