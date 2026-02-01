package com.project.DBManage.controller;

import java.util.ArrayList;
import java.util.Optional;

import com.project.DBManage.services.PrendaVarianteService;
import com.project.DBManage.models.PrendaVarianteModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/variantes")
public class PrendaVarianteController {

    @Autowired
    private PrendaVarianteService prendaVarianteService;

    // GET: todas las variantes
    @GetMapping
    public ArrayList<PrendaVarianteModel> getAllVariantes() {
        return prendaVarianteService.getVariantes();
    }

    // GET: variante por id
    @GetMapping("/{id}")
    public Optional<PrendaVarianteModel> getVarianteById(@PathVariable Long id) {
        return prendaVarianteService.getVarianteById(id);
    }

    // POST: crear variante
    @PostMapping
    public PrendaVarianteModel createVariante(@RequestBody PrendaVarianteModel variante) {
        return prendaVarianteService.createVariante(variante);
    }

    // PUT: actualizar variante
    @PutMapping("/{id}")
    public PrendaVarianteModel updateVariante(@RequestBody PrendaVarianteModel request, @PathVariable Long id) {
        return prendaVarianteService.updateById(request, id);
    }

    // DELETE: eliminar variante
    @DeleteMapping("/{id}")
    public String deleteVariante(@PathVariable Long id) {
        return prendaVarianteService.deleteVariante(id);
    }
}
