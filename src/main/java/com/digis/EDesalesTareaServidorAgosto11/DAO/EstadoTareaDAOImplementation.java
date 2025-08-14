/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis.EDesalesTareaServidorAgosto11.DAO;

import com.digis.EDesalesTareaServidorAgosto11.JPA.EstadoTarea;
import com.digis.EDesalesTareaServidorAgosto11.JPA.Result;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alien 13
 */
@Repository
public class EstadoTareaDAOImplementation implements EstadoTareaDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public Result DarListadoEstadoTarea() {
        Result result = new Result();
        result.objects = new ArrayList();
        try {
            TypedQuery<EstadoTarea> responseQuery = entityManager.createQuery("FROM EstadoTarea", EstadoTarea.class);
            List<EstadoTarea> estadoTareaJPA = responseQuery.getResultList();
            for (EstadoTarea estadoTarea : estadoTareaJPA) {
                EstadoTarea estadoTareas = new EstadoTarea();
                estadoTareas = estadoTarea;
                result.objects.add(estadoTareas);
            }

            result.correct = true;
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex =ex;
        }
        return result;
    }

}
