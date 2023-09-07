package com.dorukt.controller;

import com.dorukt.repository.entity.Works;
import com.dorukt.service.WorksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/works")
public class WorksController {

    private final WorksService worksService;

    @GetMapping
    public ResponseEntity<List<Works>> findAll() {
        return ResponseEntity.ok(worksService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Works> findById(@PathVariable Long id) {
        return ResponseEntity.ok(worksService.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<Works> save(@RequestBody Works works) {
        return ResponseEntity.ok(worksService.save(works));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        worksService.deleteById(id);
        return ResponseEntity.ok("Silme işlemi başarılı");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Works works) {
        worksService.update(works);
        return ResponseEntity.ok("Güncelleme işlemi başarılı");
    }

}
