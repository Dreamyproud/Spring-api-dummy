/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angela.apidummy.repository;

import com.angela.apidummy.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author TATIANA
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer>{
    
}
