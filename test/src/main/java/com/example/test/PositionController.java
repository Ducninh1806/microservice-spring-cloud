package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/position")
public class PositionController {
    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<List<Position>> findAll(){
        return new ResponseEntity<>(positionRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Object>> getCategory(){
        String url = "http://localhost:8080/demo/api/category";

        Object[] objects = restTemplate.getForObject(url, Object[].class);
        return new ResponseEntity<>(Arrays.asList(objects), HttpStatus.OK  );
    }
}
