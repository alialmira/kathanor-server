package net.springbootserver.kathanorbackend.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.springbootserver.kathanorbackend.models.File201;

public interface File201Repository extends 
    MongoRepository<File201, String> { 
    List<File201> findByEmployeeId(String employeeId);
}
