package com.retokruger.retokruger.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class LoginResponse {
    public static ResponseEntity<Object> generateResponse(String cedula, HttpStatus status, String contrasena) {
        Map<String, Object> map = new HashMap<>();
        map.put("cedula", cedula);
        map.put("contrasena", contrasena);

        return new ResponseEntity<Object>(map,status);
    }
}
