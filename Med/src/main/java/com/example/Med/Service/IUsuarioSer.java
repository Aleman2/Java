package com.example.Med.Service;

import com.example.Med.entity.Cita;
import com.example.Med.entity.Usuario;

import java.util.Date;
import java.util.List;

public interface IUsuarioSer {
    public List<Usuario> getUsuarios();
    public void createUsuario(Usuario usuario);
    public Usuario getUsuario(Long id);
    public void updateUsuario(Long id, Usuario usuario);
    public void deleteUsuario(Long id);
}
