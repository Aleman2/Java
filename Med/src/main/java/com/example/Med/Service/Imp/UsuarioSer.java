package com.example.Med.Service.Imp;

import com.example.Med.Service.IUsuarioSer;
import com.example.Med.entity.Usuario;
import com.example.Med.repository.UsuarioRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioSer implements IUsuarioSer {

    @Autowired
    private UsuarioRepos usuarioRepos;

    @Override
    @Transactional
    public void createUsuario(Usuario usuario) {
         usuarioRepos.save(usuario);
    }

    @Override
    @Transactional
    public void updateUsuario(Long Id, Usuario usuario) {
        if(usuarioRepos.findById(Id).isPresent()){
            Usuario u = usuarioRepos.findById(Id).get();
            u.setNombre(usuario.getNombre());
            u.setApellidos(usuario.getApellidos());
            u.setUser(usuario.getUser());
            u.setClave(usuario.getClave());
            usuarioRepos.save(u);
        }
    }


    @Override
    @Transactional
    public List<Usuario> getUsuarios() {
        return usuarioRepos.findAll();
    }

    @Override
    @Transactional
    public void deleteUsuario(Long id) {

            usuarioRepos.deleteById(id);

    }

    @Override
    @Transactional
    public Usuario getUsuario(Long id) {
        return usuarioRepos.findById(id).get();
    }
}
