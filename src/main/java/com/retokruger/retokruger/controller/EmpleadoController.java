package com.retokruger.retokruger.controller;

import com.retokruger.retokruger.Utils.JWTUtil;
import com.retokruger.retokruger.model.Rol;
import com.retokruger.retokruger.Dto.UsuarioUpdateDto;
import com.retokruger.retokruger.model.Usuario;
import com.retokruger.retokruger.service.RolService;
import com.retokruger.retokruger.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private RolService rolService;
    @Autowired
    private JWTUtil jwtUtil;


    @PutMapping
    public Object update(@RequestHeader(value="Authorization") String token, @RequestBody @Valid UsuarioUpdateDto usuario){
        if (!validarToken(token)) {
            ArrayList<String> nombreArrayList = new ArrayList<String>();
            nombreArrayList.add("Autenticación Incorrecta");
            return nombreArrayList;
        }
        Integer usuarioId = Integer.parseInt(jwtUtil.getKey(token));
        Usuario user = usuarioService.findById(usuarioId);
        user.setCelular(usuario.getCelular());
        user.setDireccion(usuario.getDireccion());
        user.setDosis(usuario.getDosis());
        user.setFecha(usuario.getFecha());
        user.setFechaNacimiento(usuario.getFechaNacimiento());
        user.setVacuna(usuario.getVacuna());
        user.setVacunado(usuario.getVacunado());
        return usuarioService.update(user);
    }
    @GetMapping()
    public Object findById(@RequestHeader(value="Authorization") String token){
        if (!validarToken(token)) {

            ArrayList<String> nombreArrayList = new ArrayList<String>();
            nombreArrayList.add("Autenticación Incorrecta");
            return nombreArrayList;
        }
        Integer usuarioId = Integer.parseInt(jwtUtil.getKey(token));
        return usuarioService.findById(usuarioId);
    }

    private boolean validarToken(String token) {
        String rolId = jwtUtil.getValue(token);
        System.out.println(rolId);

        Rol rol = rolService.findById(Integer.parseInt(rolId));
        if(rol.getNombre().equals("Empleado")){
            return true;
        }
        return false;
    }
}
