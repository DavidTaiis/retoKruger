package com.retokruger.retokruger.service;

import com.retokruger.retokruger.model.Usuario;
import com.retokruger.retokruger.Dto.loginDto;
import com.retokruger.retokruger.Dto.UsuarioUpdateDto;


import java.util.List;

public interface IUsuarioService {
    Object create(Usuario usuario);

    Usuario update(Usuario usuario);

    Usuario findById(Integer id);

    List<Usuario> finAll(String vacunado, String vacuna, String fecha);

    Object delete(Integer id);

    Usuario login(loginDto login);

}
