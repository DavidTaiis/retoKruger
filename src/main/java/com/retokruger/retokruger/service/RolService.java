package com.retokruger.retokruger.service;

import com.retokruger.retokruger.model.Rol;
import com.retokruger.retokruger.repository.IRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService implements IRolService{
    @Autowired
    private IRolRepository rolRepository;

    @Override
    public Rol create(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol update(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol findById(Integer id) {
        Optional<Rol> rolOptional = rolRepository.findById(id);
        return rolOptional.orElse(null);
    }

    @Override
    public List<Rol> finAll() {
        return rolRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        rolRepository.deleteById(id);
    }
}
