package com.project.DBManage.controller;

import java.util.ArrayList;
import java.util.Optional;

import com.project.DBManage.services.PrendaService;
import com.project.DBManage.models.PrendaModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prendas")
public class PrendaController {

    @Autowired
    private PrendaService prendaService;

    // GET: todas las prendas
    @GetMapping
    public ArrayList<PrendaModel> getAllPrendas() {
        return prendaService.getPrendas();
    }

    // GET: prenda por id
    @GetMapping("/{id}")
    public Optional<PrendaModel> getPrendaById(@PathVariable Long id) {
        return prendaService.getPrendaById(id);
    }

    // POST: crear prenda
    @PostMapping
    public PrendaModel createPrenda(@RequestBody PrendaModel prenda) {
        return prendaService.createPrenda(prenda);
    }

    // PUT: actualizar prenda
    @PutMapping("/{id}")
    public PrendaModel updatePrenda(@RequestBody PrendaModel request, @PathVariable Long id) {
        return prendaService.updateById(request, id);
    }

    // DELETE: eliminar prenda
    @DeleteMapping("/{id}")
    public String deletePrenda(@PathVariable Long id) {
        return prendaService.deletePrenda(id);
    }
}
