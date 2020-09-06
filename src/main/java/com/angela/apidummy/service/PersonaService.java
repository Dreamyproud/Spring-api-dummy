/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angela.apidummy.service;

import com.angela.apidummy.dto.PersonaDto;
import com.angela.apidummy.model.Persona;
import com.angela.apidummy.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TATIANA
 */
@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    public JSONArray listAll() {
        JSONArray jsonArray = new JSONArray();
        List<Persona> personas = personaRepository.findAll();

        if (!personas.isEmpty()) {
            for (Persona persona : personas) {
                JSONObject object = new JSONObject();
                object.put("id", persona.getId());
                object.put("fullname", persona.getFullname());
                object.put("email", persona.getEmail());

                jsonArray.add(object);
            }
        }

        return jsonArray;
    }

    public void create(PersonaDto personaDto) throws Exception {

        if (personaDto == null) {
            throw new Exception("La entidad persona está vacía.");
        }

        if (personaDto.getFullname().isEmpty()) {
            throw new Exception("El nombre está vacio");
        }

        Persona persona = new Persona();
        persona.setFullname(personaDto.getFullname());
        persona.setEmail(personaDto.getEmail());

        try {
            personaRepository.save(persona);
        } catch (Exception e) {
            throw new Exception("Hubo un error registrando la persona. Error: " + e.getMessage());
        }

    }

    public void update(PersonaDto personaDtoU, Integer id) throws Exception {
        if (id == null) {
            throw new Exception("El usuario no existe");
        }

        if (personaDtoU == null) {
            throw new Exception("No has ingresado datos");
        }

        Persona personaBD = findById(id);

        if (personaBD == null) {
            throw new Exception("El usuario no existe");
        }

        Persona person = new Persona();
        person.setId(id);
        person.setFullname(personaDtoU.getFullname() == null ? personaBD.getFullname() : personaDtoU.getFullname());
        person.setEmail(personaDtoU.getEmail() == null ? personaBD.getEmail() : personaDtoU.getEmail());

        try {
            personaRepository.save(person);
        } catch (Exception e) {
            throw new Exception("Hubo un error actualizando. Error: " + e.getMessage());
        }
    }

    public void delete(Integer id) throws Exception {
        Persona IdDelete = findById(id);
        
        System.out.println("delete: "+IdDelete);

        if (IdDelete == null) {
            throw new Exception("El usuario no existe");
        }

        try {
            personaRepository.delete(IdDelete);
        } catch (Exception e) {
            throw new Exception("No se ha podido eliminar. Error " + e.getMessage());
        }
    }

    public Persona findById(Integer id) {
        return personaRepository.getOne(id);
    }

}
