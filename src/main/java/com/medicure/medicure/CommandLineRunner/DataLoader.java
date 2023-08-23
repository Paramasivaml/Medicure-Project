package com.medicure.medicure.CommandLineRunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.medicure.medicure.entity.doctors;
import com.medicure.medicure.repository.DoctorsRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private DoctorsRepository doctorsRepository;

    @Override
    public void run(String... args) throws Exception {
        // Preload some data into the database
        doctors doctor1 = new doctors();
        doctor1.setName("John Doe");
        doctor1.setSpecialization("Pathology");

        doctors doctor2 = new doctors();
        doctor2.setName("Jane Smith");
        doctor2.setSpecialization("Cardiology");

        doctors doctor3 = new doctors();
        doctor3.setName("Sara jaimes");
        doctor3.setSpecialization("Pathology");

        doctors doctor4 = new doctors();
        doctor4.setName("Susan John");
        doctor4.setSpecialization("Oncology");

        doctorsRepository.save(doctor1);
        doctorsRepository.save(doctor2);
        doctorsRepository.save(doctor3);
        doctorsRepository.save(doctor4);
    }
}
