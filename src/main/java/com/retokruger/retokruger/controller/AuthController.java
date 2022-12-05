package com.retokruger.retokruger.controller;

import com.retokruger.retokruger.Utils.JWTUtil;
import com.retokruger.retokruger.model.Usuario;
import com.retokruger.retokruger.Dto.loginDto;
import com.retokruger.retokruger.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private UsuarioService usuarioService;
    private Usuario usuario;

    public AuthController(JWTUtil jwtUtil) {

        this.jwtUtil = jwtUtil;
    }
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody @Valid loginDto login) {
        Usuario usuarioLogueado = usuarioService.login(login);
        if(usuarioLogueado != null){
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), String.valueOf(usuarioLogueado.getRol()));
            return tokenJwt;
        }else{
            return "Error de autenticación";
        }
    }
}
