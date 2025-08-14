package com.digis.EDesalesTareaServidorAgosto11.DAO;

import com.digis.EDesalesTareaServidorAgosto11.JPA.Result;
import com.digis.EDesalesTareaServidorAgosto11.JPA.Tarea;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service    
public class TareaServiceDAO {
    @Autowired
    EntityManager entityManager;
    @Autowired
    TareaDAOImplementation tareaDAOImplementation;
    
    public Result DarListadoTareaService(){
        return tareaDAOImplementation.DarListadoTarea();
    }
    public Result DarTareaXId(int idTarea){
        return tareaDAOImplementation.DarTareaXId(idTarea);
    }
    public Result AgregarTarea(Tarea tarea){
        return tareaDAOImplementation.AgregarTarea(tarea);
    }
    public Result EditarTarea(Tarea tarea){
        return tareaDAOImplementation.EditarTarea(tarea);
    }
    public Result EliminarTarea(int idTarea){
        Tarea tarea = new Tarea();
        tarea = entityManager.find(Tarea.class, idTarea);
        return tareaDAOImplementation.EliminarTarea(tarea);
    }
}
