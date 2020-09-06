/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angela.apidummy.rest;

import com.angela.apidummy.dto.PersonaDto;
import com.angela.apidummy.service.PersonaService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author TATIANA
 */
@RestController
@RequestMapping("/personas")
public class PersonaController {
    
    @Autowired
    PersonaService personaService;
    
    @GetMapping("/listAll")
    public JSONArray listAll() {
        return personaService.listAll();
    }
    
    @PostMapping("/create")
    public JSONObject create(@RequestBody PersonaDto personaDto){
        JSONObject response = new JSONObject();
        
        try {
            personaService.create(personaDto);
            response.put("code", "OK");
            response.put("message", "Se guardó correctamente el registro");
        } catch (Exception e) {
            response.put("code", "FAIL");
            response.put("message", e);
        }
        return response;
    }
    
}
