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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    @PutMapping("/updateById/{id}")
    public JSONObject updateById(@PathVariable("id")Integer id, @RequestBody PersonaDto personaDtoU){
        JSONObject response = new JSONObject();
        try{
           personaService.update(personaDtoU, id);
           response.put("code", "Ok");
           response.put("message", "Se actualizó correctamente");
        }catch(Exception e){
            response.put("code", "FAIL");
            response.put("message", e);
        }
        return response;
    }
    
    @DeleteMapping("/deleteById/{id}")
    public JSONObject deleteById(@PathVariable("id")Integer id){
        JSONObject response = new JSONObject();
        try{
           personaService.delete(id);
           response.put("code", "Ok");
           response.put("message", "Se ha eliminado correctamente");
        }catch(Exception e){
            response.put("code", "FAIL");
            response.put("message", e);
        }
        return response;
    }
    
}
