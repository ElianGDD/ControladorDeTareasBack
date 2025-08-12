package com.digis.EDesalesTareaServidorAgosto11.DAO;

import com.digis.EDesalesTareaServidorAgosto11.JPA.Result;
import com.digis.EDesalesTareaServidorAgosto11.JPA.Tarea;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TareaDAOImplementation implements TareaDAO{
    @Autowired
    EntityManager  entityManager;

    @Override
    public Result DarListadoTarea() {
        Result result = new Result();
        result.objects = new ArrayList();
        try {
            TypedQuery<Tarea> tareaQuery = entityManager.createQuery("FROM Tarea ", Tarea.class);
            List<Tarea> tareaJPA = tareaQuery.getResultList();
            for(Tarea tarea: tareaJPA){
                Tarea tareas = new Tarea();
                tareas = tarea;
                result.objects.add(tareas);
            }
            
            result.correct = true;
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
        
    }

    @Transactional
    @Override
    public Result AgregarTarea(Tarea tarea) {
        Result result = new Result();
        try {
            entityManager.persist(tarea);
            result.correct = true;
        } catch (Exception ex) {
            result.errorMessage = ex.getLocalizedMessage();
            result.correct = false;
            result.ex = ex;
        }
        return result;
        
    }

    @Transactional
    @Override
    public Result EditarTarea(Tarea tarea) {
        Result result = new Result();
        try {
            entityManager.merge(tarea);
            result.correct = true;
            
        } catch (Exception ex) {
            result.errorMessage = ex.getLocalizedMessage();
            result.correct = false;
            result.ex = ex;
        }
        return result;
    }

    @Transactional
    @Override
    public Result EliminarTarea(Tarea tarea) {
        Result result = new Result();
        try {
            entityManager.remove(tarea);
            result.correct = true;
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
        }
        return result;
    }
    
    
}
