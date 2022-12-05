package com.retokruger.retokruger.repository;

import com.retokruger.retokruger.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByCedulaAndContrasena(String cedula, String contrasena);

    Usuario findByCedula(String cedula);
}
