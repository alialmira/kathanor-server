package net.springbootserver.kathanorbackend.repositories;

import net.springbootserver.kathanorbackend.models.Report;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<Report, String> {
Report findBy_id(ObjectId _id);
}