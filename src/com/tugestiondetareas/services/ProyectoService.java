package com.tugestiondetareas.services;

import com.tugestiondetareas.model.Proyecto;
import com.tugestiondetareas.model.Tarea;
import com.tugestiondetareas.exceptions.ProyectoNoEncontradoException;

import java.util.HashMap;
import java.util.Map;

public class ProyectoService {
    private Map<String, Proyecto> proyectos;

    public ProyectoService() {
        proyectos = new HashMap<>();
    }

    public void registrarProyecto(Proyecto proyecto) {
        proyectos.put(proyecto.getNombre(), proyecto);
    }

    public Proyecto obtenerProyecto(String nombre) throws ProyectoNoEncontradoException {
        if (!proyectos.containsKey(nombre)) {
            throw new ProyectoNoEncontradoException("Proyecto no encontrado");
        }
        return proyectos.get(nombre);
    }

    public void asignarTareaAProyecto(String nombreProyecto, Tarea tarea) throws ProyectoNoEncontradoException {
        Proyecto proyecto = obtenerProyecto(nombreProyecto);
        proyecto.agregarTarea(tarea);
    }

    public Map<String, Proyecto> getProyectos() {
        return proyectos;
    }
}
