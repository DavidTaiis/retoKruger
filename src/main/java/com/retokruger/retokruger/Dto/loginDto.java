package com.retokruger.retokruger.Dto;
import javax.validation.constraints.NotBlank;

public class loginDto {
    @NotBlank(message = "Cédula no debe esta vacio")
    private String cedula;
    @NotBlank(message = "Contraseña no debe estar vacio")
    private  String contrasena;
    public loginDto() {

    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
