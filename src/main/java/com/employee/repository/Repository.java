package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.model.HiringForm;

public interface Repository extends JpaRepository<HiringForm, Integer> {

}
