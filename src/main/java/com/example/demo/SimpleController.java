package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SimpleController {
    Logger logger = LoggerFactory.getLogger(SimpleController.class);

    @Value("#{${myMap}}")
    private Map<String,String> myMap;

    @GetMapping("/products")
    public ResponseEntity<List<Device>> hello() {

        // This API is not protected.
        Device device1 = new Device("Apple iPhone 13", 799, "The iPhone 13 features a 6.1-inch " +
                "Super Retina XDR display, A15 Bionic chip, 5G connectivity, and a dual-camera system with night mode.",
                "Apple");
        Device device2 = new Device("Samsung Galaxy S21 Ultra", 1199, "The Galaxy S21 Ultra " +
                "features a 6.8-inch Dynamic AMOLED 2X display, Snapdragon 888 processor, 5G connectivity, and a " +
                "quad-camera system with 100x Space Zoom.", "Samsung");
        return ResponseEntity.ok(Arrays.asList(device1, device2));
    }

    @PostMapping("/api")
    String getAPI() {

        // This API is protected
        logger.info("Hello New");
        return "Hello New";
    }
}
