package ru.sonyabeldy.springcourse;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Consumer {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();


        Map<String, Object> jsonToSend = generatePost();

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(jsonToSend);

        String url = "http://localhost:8080/measurements/add";
        String response = restTemplate.postForObject(url, request, String.class);
        System.out.println(response);
    }

    public static Map<String, Object> generatePost() {

        Random random = new Random();
        double value = -100 + 200 * random.nextDouble();
        boolean isRaining = random.nextBoolean();

        Map<String, Object> jsonToSend = new HashMap<>();
        jsonToSend.put("value", value);
        jsonToSend.put("isRaining", isRaining);
        HashMap<String, Object> sensor = new HashMap<>();
        sensor.put("name", "Sensor name");
        jsonToSend.put("sensor", sensor);
        return jsonToSend;
    }
}
