package com.medicure.medicure.controller;

import com.medicure.medicure.entity.doctors;
import com.medicure.medicure.repository.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
public class DoctorsController {

    @Autowired
    private DoctorsRepository doctorsRepository;

    @PostMapping
    public ResponseEntity<doctors> saveDoctor(@RequestBody doctors doctor) {
        try {
            doctors savedDoctor = doctorsRepository.save(doctor);
            return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<doctors> getDoctorById(@PathVariable Long id) {
        Optional<doctors> doctor = doctorsRepository.findById(id);
        return doctor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<doctors>> getAllDoctors() {
        List<doctors> doctorsList = doctorsRepository.findAll();
        return new ResponseEntity<>(doctorsList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<doctors> updateDoctor(@PathVariable Long id, @RequestBody doctors updatedDoctor) {
        Optional<doctors> existingDoctor = doctorsRepository.findById(id);
        if (existingDoctor.isPresent()) {
            doctors doctorToUpdate = existingDoctor.get();
            doctorToUpdate.setName(updatedDoctor.getName());
            doctorToUpdate.setSpecialization(updatedDoctor.getSpecialization());
            // Update other fields as needed
            return new ResponseEntity<>(doctorsRepository.save(doctorToUpdate), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDoctor(@PathVariable Long id) {
        try {
            doctorsRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
