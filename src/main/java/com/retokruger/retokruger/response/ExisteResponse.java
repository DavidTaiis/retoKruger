package com.retokruger.retokruger.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ExisteResponse {
    public static ResponseEntity<Object> generateResponse( HttpStatus status) {
        Map<String, Object> map = new HashMap<>();
        map.put("mensaje", "El usuario ya existe");

        return new ResponseEntity<Object>(map,status);
    }
}
