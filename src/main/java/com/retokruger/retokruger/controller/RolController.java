package com.retokruger.retokruger.controller;


import com.retokruger.retokruger.model.Rol;
import com.retokruger.retokruger.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private RolService rolService;
    @GetMapping
    public List<Rol> findAll(){
        return rolService.finAll();
    }
    @PostMapping
    public Rol create(@RequestBody Rol rol){
        return rolService.create(rol);
    }
    @PutMapping
    public Rol update(@RequestBody Rol rol){
        return rolService.update(rol);
    }
    @GetMapping("/{id}")
    public Rol findById(@PathVariable("id") Integer id){
        return rolService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        rolService.delete(id);
    }
}
