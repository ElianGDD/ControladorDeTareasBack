package com.digis.EDesalesTareaServidorAgosto11.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "ESTADOTAREA")
public class EstadoTarea {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "IDESTADOTAREA")
    private int idEstadoTarea;
    @Column(name = "TIPOESTADO")
    String tipoEstado;

    public int getIdEstadoTarea() {
        return idEstadoTarea;
    }

    public void setIdEstadoTarea(int idEstadoTarea) {
        this.idEstadoTarea = idEstadoTarea;
    }

    public String getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(String tipoEstado) {
        this.tipoEstado = tipoEstado;
    }
    
    
    
}
