package com.tugestiondetareas.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Proyecto {
    private String nombre;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private List<Tarea> tareas;

    public Proyecto(String nombre, String descripcion, Date fechaInicio, Date fechaFin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tareas = new ArrayList<>();
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public boolean todasTareasCompletadas() {
        for (Tarea tarea : tareas) {
            if (!tarea.getEstado().equals("completada")) {
                return false;
            }
        }
        return true;
    }

    public String getNombre() {
        return nombre;

    }
}
