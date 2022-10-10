package com.api.randomsmartphone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.randomsmartphone.model.Smartphone;

@Repository
public interface SmartphoneRepository extends JpaRepository<Smartphone, Long>{}
