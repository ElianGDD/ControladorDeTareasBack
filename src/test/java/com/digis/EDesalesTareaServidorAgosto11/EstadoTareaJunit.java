package com.digis.EDesalesTareaServidorAgosto11;

import com.digis.EDesalesTareaServidorAgosto11.DAO.EstadoTareaServiceDAO;
import com.digis.EDesalesTareaServidorAgosto11.JPA.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class EstadoTareaJunit {
    @Autowired
    EstadoTareaServiceDAO estadoTareaServiceDAO;
    
    @Test
    public void testDarListadoDeEstados(){
        Result result = new Result();
        result = estadoTareaServiceDAO.DarListadoEstadosTareas();
        Assertions.assertTrue(result.correct);
        Assertions.assertNotNull(result.objects);
    } 
    
}
