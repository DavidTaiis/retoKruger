package com.retokruger.retokruger.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class AccionResponse {
    public static ResponseEntity<Object> generateResponse(HttpStatus status) {
        Map<String, Object> map = new HashMap<>();
        map.put("respuesta", "Acción realizada con éxito");

        return new ResponseEntity<Object>(map,status);
    }
}
