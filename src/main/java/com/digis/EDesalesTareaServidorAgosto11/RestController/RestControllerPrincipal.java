package com.digis.EDesalesTareaServidorAgosto11.RestController;

import com.digis.EDesalesTareaServidorAgosto11.DAO.EstadoTareaServiceDAO;
import com.digis.EDesalesTareaServidorAgosto11.DAO.TareaServiceDAO;
import com.digis.EDesalesTareaServidorAgosto11.JPA.Result;
import com.digis.EDesalesTareaServidorAgosto11.JPA.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarea")
public class RestControllerPrincipal {

    @Autowired
    TareaServiceDAO tareaServiceDAO;
    @Autowired
    EstadoTareaServiceDAO estadoTareaServiceDAO;

    @GetMapping
    public ResponseEntity darTareas() {
        Result result = new Result();
        try {
            result = tareaServiceDAO.DarListadoTareaService();
            if (result.objects.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(result);

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
    }
    @GetMapping("/DarTareaXId")
    public ResponseEntity tareaXId(@RequestParam int idTarea){
        Result result = new Result();
        try {
            result = tareaServiceDAO.DarTareaXId(idTarea);
            
            if (result.object == null) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            result.ex = ex;
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
    }
    @GetMapping("/DarEstadoTarea")
    public ResponseEntity listadoEstadoTarea(){
        Result result = new Result();
        try {
            result = estadoTareaServiceDAO.DarListadoEstadosTareas();
            if(result.objects.isEmpty()){
                return ResponseEntity.noContent().build();
            }
             return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
    }

    @PostMapping("/AgregarNuevaTarea")
    public ResponseEntity agregarTarea(@RequestBody Tarea tarea) {
        Result result = new Result();
        try {
            result = tareaServiceDAO.AgregarTarea(tarea);
            if (result.correct) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(result);
            }
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(result);
        }
    }
    @PutMapping("/ActualizarTarea")
    public ResponseEntity editarTarea(@RequestBody Tarea tarea){
        Result result = new Result();
        try {
            result = tareaServiceDAO.EditarTarea(tarea);
             if (result.correct) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(result);
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
        
    }
    
    @DeleteMapping("/BorrarTarea")
    public ResponseEntity eliminarTarea(@RequestParam int idTarea){
        Result result = new Result();
        try {
             result = tareaServiceDAO.EliminarTarea(idTarea);
             if(result.correct){
                 return ResponseEntity.ok(result);
             }else{
                 return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(result);
             }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

}
