package com.angelsystems.api_demo.service;

import com.angelsystems.api_demo.entity.Persona;
import com.angelsystems.api_demo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> listarTodas() {
        return personaRepository.findAll();
    }

    public Optional<Persona> buscarPorId(Long id) {
        return personaRepository.findById(id);
    }

    public Persona guardar(Persona persona) {
        return personaRepository.save(persona);
    }

    public Optional<Persona> actualizar(Long id, Persona nuevosDatos) {
        return personaRepository.findById(id).map(persona -> {
            persona.setNombre(nuevosDatos.getNombre());
            persona.setApellidoPaterno(nuevosDatos.getApellidoPaterno());
            persona.setApellidoMaterno(nuevosDatos.getApellidoMaterno());
            persona.setDireccion(nuevosDatos.getDireccion());
            persona.setTelefono(nuevosDatos.getTelefono());
            persona.setEmail(nuevosDatos.getEmail());
            return personaRepository.save(persona);
        });
    }

    public boolean eliminar(Long id) {
        if (personaRepository.existsById(id)) {
            personaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
