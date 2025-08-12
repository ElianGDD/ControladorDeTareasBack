package com.digis.EDesalesTareaServidorAgosto11;

import com.digis.EDesalesTareaServidorAgosto11.DAO.TareaDAOImplementation;
import com.digis.EDesalesTareaServidorAgosto11.DAO.TareaServiceDAO;
import com.digis.EDesalesTareaServidorAgosto11.JPA.Result;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TareaJunit {

    @Autowired
    TareaServiceDAO tareaServiceDAO;
    @Autowired
    EntityManager entityManager;

    @Test
    public void testDarListadoTarea() {
        Result result = new Result();
        result = tareaServiceDAO.DarListadoTareaService();
        Assertions.assertTrue(result.correct, "Se esperaba que sea true");
        Assertions.assertNotNull(result.objects);
    }

}
