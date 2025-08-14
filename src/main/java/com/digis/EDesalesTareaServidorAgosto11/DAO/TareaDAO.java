package com.digis.EDesalesTareaServidorAgosto11.DAO;

import com.digis.EDesalesTareaServidorAgosto11.JPA.Result;
import com.digis.EDesalesTareaServidorAgosto11.JPA.Tarea;

/**
 *
 * @author Alien 13
 */
public interface TareaDAO {
    Result DarListadoTarea();
    Result DarTareaXId(int idTarea);
    Result AgregarTarea(Tarea tarea);
    Result EditarTarea(Tarea tarea);
    Result EliminarTarea(Tarea tarea);
    
}
