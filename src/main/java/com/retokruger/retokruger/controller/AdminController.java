package com.retokruger.retokruger.controller;

import com.retokruger.retokruger.Utils.JWTUtil;
import com.retokruger.retokruger.model.Rol;
import com.retokruger.retokruger.model.Usuario;
import com.retokruger.retokruger.service.RolService;
import com.retokruger.retokruger.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/administrador")
public class AdminController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private RolService rolService;
    @Autowired
    private JWTUtil jwtUtil;
    @GetMapping
    public List findAll(@RequestHeader(value="Authorization") String token, @RequestParam(required = false) String vacunado, String vacuna, String fecha){
        if (!validarToken(token)) {
            ArrayList<String> nombreArrayList = new ArrayList<String>();
            nombreArrayList.add("Autenticación Incorrecta");
            return nombreArrayList;
        }
        return usuarioService.finAll(vacunado, vacuna, fecha);
    }
    @PostMapping
    public Object create(@RequestHeader(value="Authorization") String token, @RequestBody @Valid Usuario usuario){
        if (!validarToken(token)) {
            ArrayList<String> nombreArrayList = new ArrayList<String>();
            nombreArrayList.add("Autenticación Incorrecta");
            return nombreArrayList;
        }
        return usuarioService.create(usuario);
    }

    @PutMapping
    public Object update(@RequestHeader(value="Authorization") String token, @RequestBody Usuario usuario){
        if (!validarToken(token)) {
            ArrayList<String> nombreArrayList = new ArrayList<String>();
            nombreArrayList.add("Autenticación Incorrecta");
            return nombreArrayList;
        }
        return usuarioService.update(usuario);
    }
    @GetMapping("/{id}")
    public Object findById(@RequestHeader(value="Authorization") String token, @PathVariable("id") Integer id){
        if (!validarToken(token)) {
            ArrayList<String> nombreArrayList = new ArrayList<String>();
            nombreArrayList.add("Autenticación Incorrecta");
            return nombreArrayList;
        }
        return usuarioService.findById(id);
    }
    @DeleteMapping("/{id}")
    public Object delete(@RequestHeader(value="Authorization") String token, @PathVariable("id") Integer id){
        if (!validarToken(token)) {
            ArrayList<String> nombreArrayList = new ArrayList<String>();
            nombreArrayList.add("Autenticación Incorrecta");
            return nombreArrayList;
        }
        return usuarioService.delete(id);
    }

    private boolean validarToken(String token) {
        String rolId = jwtUtil.getValue(token);
        System.out.println(rolId);

        Rol rol = rolService.findById(Integer.parseInt(rolId));
        if(rol.getNombre().equals("Administrador")){
            return true;
        }
        return false;
    }
}
