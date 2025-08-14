/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis.EDesalesTareaServidorAgosto11.DAO;

import com.digis.EDesalesTareaServidorAgosto11.JPA.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alien 13
 */
@Service
public class EstadoTareaServiceDAO {
    @Autowired
    EstadoTareaDAOImplementation estadoTareaDAOImplementation;
    
    public Result DarListadoEstadosTareas(){
        return estadoTareaDAOImplementation.DarListadoEstadoTarea();
    }
    
}
