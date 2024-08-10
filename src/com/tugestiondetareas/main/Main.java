package com.tugestiondetareas.main;

import com.tugestiondetareas.model.*;
import com.tugestiondetareas.services.*;
import com.tugestiondetareas.exceptions.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws ProyectoNoEncontradoException, UsuarioNoEncontradoException {
        ProyectoService proyectoService = new ProyectoService();
        UsuarioService usuarioService = new UsuarioService();

        // Crear y registrar usuarios
        Usuario usuario1 = new Usuario("Juan Pérez", "U001");
        usuarioService.registrarUsuario(usuario1);

        // Crear y registrar proyectos
        Proyecto proyecto1 = new Proyecto("Sistema de Gestión", "Desarrollo de un sistema de gestión de tareas", new Date(), new Date());
        proyectoService.registrarProyecto(proyecto1);

        // Crear tareas y asignarlas
        Tarea tarea1 = new Tarea("Diseñar UI", "Diseñar la interfaz de usuario", new Date(), "Alta", "Pendiente");
        proyectoService.asignarTareaAProyecto("Sistema de Gestión", tarea1);
        usuarioService.asignarTareaAUsuario("U001", tarea1);

        // Consultar proyectos y tareas
        try {
            Proyecto proyecto = proyectoService.obtenerProyecto("Sistema de Gestión");
            System.out.println("Tareas en el proyecto: " + proyecto.getTareas().size());

            Usuario usuario = usuarioService.obtenerUsuario("U001");
            System.out.println("Tareas asignadas a Juan Pérez: " + usuario.getTareasAsignadas().size());
        } catch (ProyectoNoEncontradoException | UsuarioNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }
}
