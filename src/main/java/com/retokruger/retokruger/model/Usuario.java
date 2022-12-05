package com.retokruger.retokruger.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "No puede ser vacio o nulo")
    @Size(min = 10, max = 10, message = "Ingresa una cédula válida de 10 dígitos")
    @Pattern(regexp = "^[0-9,$]*$", message = "Solo números admitidos")
    @Column(name = "cedula", nullable = false, length = 10)
    private String cedula;

    @NotBlank(message = "No puede ser vacio o nulo")
    @Pattern(regexp = "^[a-zA-Z\\s]+{2,254}", message = "El nombre no puede contener números o caracteres especiales")
    @Column(name = "nombres", nullable = false, length = 70)
    private String nombres;
    @Pattern(regexp = "^[a-zA-Z\\s]+{2,254}", message = "El nombre no puede contener números o caracteres especiales")
    @NotBlank(message = "No puede ser vacio o nulo")
    @Column(name = "apellidos", nullable = false, length = 70)
    private  String apellidos;
    @NotBlank(message = "No puede ser vacio o nulo")
    @Email(message = "Debe ser un correo válido")
    @Column(name = "correo", nullable = false, length = 70)
    private  String correo;
    @Column(name = "contrasena", length = 70)
    private String contrasena;

    @Column(name = "celular", nullable = true, length = 10)
    private String celular;

    @Column(name="fechaNacimiento", nullable = true, length = 20)
    private Date fechaNacimiento;

    @Column(name = "direccion", nullable = true, length = 100)
    private String direccion;

    @Column(name = "vacunado", nullable = true, length = 2)
    private String vacunado;
    @Column(name = "vacuna", nullable = true, length = 30)
    private String vacuna;

    @Column(name = "dosis", nullable = true, length = 1)
    private Integer dosis;

    @Column(name = "fecha", nullable = true, length = 20)
    private Date fecha;
    @Column(name = "rol", nullable = true, length = 20)
    private String rol;

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getVacunado() {
        return vacunado;
    }

    public void setVacunado(String vacunado) {
        this.vacunado = vacunado;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }

    public Integer getDosis() {
        return dosis;
    }

    public void setDosis(Integer dosis) {
        this.dosis = dosis;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
