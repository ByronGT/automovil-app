package com.company.intecap.automovilapp.controller;

import com.company.intecap.automovilapp.model.Auto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class AutoController {

    @GetMapping("/index")

    public String getIndex(){
        return "Bienvenidos a mi API REST  Spring Boot";
    }

    @GetMapping("/autos")
    public ResponseEntity<List<Auto>> getAutos(){

        Auto a1 = new Auto(1,"Mazda","2021","Gris","079JFR",1250000);
        Auto a2 = new Auto(2,"Toyota","2020","Azul","658BYO",1000000);
        Auto a3 = new Auto(3,"Volks Wagen","2021","Negro","823JPL",2000000);
        Auto a4 = new Auto(4,"Mercedes Benz","2023","Blanco","344FYU",2500000);
        Auto a5 = new Auto(5,"Ford","2022","Rojo","375HPA",150000);

        List<Auto> autos = List.of(a1, a2, a3, a4, a5);

        return new ResponseEntity<>(autos, HttpStatus.OK);
    }

    @GetMapping("/succes")
    public ResponseEntity<String> getSuccess(){
        return new ResponseEntity<>("Operacion Exitosa", HttpStatus.OK); // codigo 200
    }

    @GetMapping("/not-found")
    public ResponseEntity<String> getNotFound(){
        return new ResponseEntity<>("No se encontro el recurso", HttpStatus.NOT_FOUND); // codigo 404
    }

    @GetMapping("/error")
    public ResponseEntity<String> getError(){
        return new ResponseEntity<>("Error en el servidor", HttpStatus.INTERNAL_SERVER_ERROR); // codigo 500
    }
}