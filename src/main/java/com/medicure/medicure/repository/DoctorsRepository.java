package com.medicure.medicure.repository;

import com.medicure.medicure.entity.doctors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorsRepository extends JpaRepository<doctors, Long> {
}
