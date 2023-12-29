package com.carpentery.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carpentery.springboot.app.model.TipoModel;
import com.carpentery.springboot.app.repository.TipoRepository;

@Service
public class TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    public List<TipoModel> getAllTipos() {
        return tipoRepository.findAll();
    }

    public TipoModel getTipoById(Long id) {
        return tipoRepository.findById(id).orElse(null);
    }

    public TipoModel createTipo(TipoModel tipo) {
        return tipoRepository.save(tipo);
    }

    public TipoModel updateTipo(Long id, TipoModel tipo) {
        if (tipoRepository.existsById(id)) {
            tipo.setId(id);
            return tipoRepository.save(tipo);
        }
        return null; // Manejar el caso en el que el tipo no exista
    }

    public void deleteTipo(Long id) {
        tipoRepository.deleteById(id);
    }
}
