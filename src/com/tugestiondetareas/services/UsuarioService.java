package com.tugestiondetareas.services;

import com.tugestiondetareas.model.Usuario;
import com.tugestiondetareas.model.Tarea;
import com.tugestiondetareas.exceptions.UsuarioNoEncontradoException;

import java.util.HashMap;
import java.util.Map;

public class UsuarioService {
    private Map<String, Usuario> usuarios;

    public UsuarioService() {
        usuarios = new HashMap<>();
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }

    public Usuario obtenerUsuario(String id) throws UsuarioNoEncontradoException {
        if (!usuarios.containsKey(id)) {
            throw new UsuarioNoEncontradoException("Usuario no encontrado");
        }
        return usuarios.get(id);
    }

    public void asignarTareaAUsuario(String idUsuario, Tarea tarea) throws UsuarioNoEncontradoException {
        Usuario usuario = obtenerUsuario(idUsuario);
        usuario.asignarTarea(tarea);
    }

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }
}
