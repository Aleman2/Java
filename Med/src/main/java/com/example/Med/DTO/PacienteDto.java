package com.example.Med.DTO;



import java.util.List;

public class PacienteDto extends UsuarioDto {
    private String Nss;
    private String NumTarjeta;
    private String Telefono;
    private String Direccion;



    public String getNss() {
        return Nss;
    }

    public void setNss(String nss) {
        Nss = nss;
    }

    public String getNumTarjeta() {
        return NumTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        NumTarjeta = numTarjeta;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
}
