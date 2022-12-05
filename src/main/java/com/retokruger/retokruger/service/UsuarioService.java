package com.retokruger.retokruger.service;

import com.retokruger.retokruger.model.Usuario;
import com.retokruger.retokruger.Dto.loginDto;
import com.retokruger.retokruger.repository.IUsuarioRepository;
import com.retokruger.retokruger.response.AccionResponse;
import com.retokruger.retokruger.response.ExisteResponse;
import com.retokruger.retokruger.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.retokruger.retokruger.Dto.UsuarioUpdateDto;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService{
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Object create(Usuario usuario) {
        Usuario usuarioExiste = usuarioRepository.findByCedula(usuario.getCedula());

        if(usuarioExiste != null){
            return ExisteResponse.generateResponse(HttpStatus.OK);
        }
        usuario.setContrasena(generarContrasena());
        usuario.setRol("2");
        usuarioRepository.save(usuario);
        return LoginResponse.generateResponse(usuario.getCedula(), HttpStatus.CREATED, usuario.getContrasena());

    }

    @Override
    public Usuario update(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario findById(Integer id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        return usuarioOptional.orElse(null);
    }

    @Override
    public List<Usuario> finAll(String vacunado, String vacuna, String fecha) {
        String query = "Select * from usuario where rol = '2'";
        if (vacunado != null && !vacunado.isEmpty()){
            query = query + " and vacunado = "+ "'"+vacunado+ "'";
        }
        if (vacuna != null && !vacuna.isEmpty()){
            query = query + " and vacuna = "+ "'"+vacuna+ "'";
        }
        if (fecha != null && !fecha.isEmpty()){
            String[] fechas = fecha.split("/");
            String fechaFrom = fechas[0];
            String fechaTo = fechas[1];

            query = query + " and fecha BETWEEN " +"'"+ fechas[0]+"'"+ " AND " + "'"+ fechas[1]+ "'" ;
        }
        System.out.println(query);
        return (List<Usuario>) entityManager.createNativeQuery(query, Usuario.class).getResultList();
    }

    @Override
    public Object delete(Integer id) {
        usuarioRepository.deleteById(id);
        return AccionResponse.generateResponse(HttpStatus.OK);
    }

    @Override
    public Usuario login(loginDto login) {
        String cedulaUser = login.getCedula();
        String contrasenaUser = login.getContrasena();
        return usuarioRepository.findByCedulaAndContrasena(cedulaUser,contrasenaUser);
    }

    public static String generarContrasena()
    {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }
}
