package com.timeaway.controllers;

import com.timeaway.repositories.PaidTimeOff;
import com.timeaway.service.PaidTimeOffService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paid-time-off")
public class PaidTimeOffController {
    private final PaidTimeOffService paidTimeOffService;

    public PaidTimeOffController(PaidTimeOffService paidTimeOffService) {
        this.paidTimeOffService = paidTimeOffService;
    }

    @GetMapping("/all")
    public List<PaidTimeOff> getAllPto() {
        return paidTimeOffService.getAllPto();
    }

    @GetMapping("/{id}")
    public PaidTimeOff findPtoById(@PathVariable Long id) {
        return paidTimeOffService.findPtoById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> savePto(@RequestBody PaidTimeOff paidTimeOff) {
        paidTimeOffService.savePto(paidTimeOff);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }
}
