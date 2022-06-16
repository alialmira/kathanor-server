package net.springbootserver.kathanorbackend.repositories;

import net.springbootserver.kathanorbackend.models.Employee;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IEmployeeRepository extends MongoRepository<Employee, String> {
  Employee findBy_id(ObjectId _id);
}