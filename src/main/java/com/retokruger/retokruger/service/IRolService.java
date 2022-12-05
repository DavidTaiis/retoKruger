package com.retokruger.retokruger.service;

import com.retokruger.retokruger.model.Rol;

import java.util.List;

public interface IRolService {
    Rol create(Rol rol);

    Rol update(Rol rol);

    Rol findById(Integer id);

    List<Rol> finAll();

    void delete(Integer id);
}
