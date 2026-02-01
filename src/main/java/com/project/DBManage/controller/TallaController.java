package com.project.DBManage.controller;

import java.util.ArrayList;
import java.util.Optional;

import com.project.DBManage.services.TallaService;
import com.project.DBManage.models.TallaModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tallas")
public class TallaController {

    @Autowired
    private TallaService tallaService;

    // GET: todas las tallas
    @GetMapping
    public ArrayList<TallaModel> getAllTallas() {
        return tallaService.getTallas();
    }

    // GET: talla por id
    @GetMapping("/{id}")
    public Optional<TallaModel> getTallaById(@PathVariable Long id) {
        return tallaService.getTallaById(id);
    }

    // POST: crear talla
    @PostMapping
    public TallaModel createTalla(@RequestBody TallaModel talla) {
        return tallaService.createTalla(talla);
    }

    // PUT: actualizar talla
    @PutMapping("/{id}")
    public TallaModel updateTalla(@RequestBody TallaModel request, @PathVariable Long id) {
        return tallaService.updateById(request, id);
    }

    // DELETE: eliminar talla
    @DeleteMapping("/{id}")
    public String deleteTalla(@PathVariable Long id) {
        return tallaService.deleteTalla(id);
    }
}
