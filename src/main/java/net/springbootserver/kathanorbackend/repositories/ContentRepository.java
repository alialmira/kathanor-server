package net.springbootserver.kathanorbackend.repositories;

import net.springbootserver.kathanorbackend.models.Content;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContentRepository extends MongoRepository<Content, String> {
  Content findBy_id(ObjectId _id);
}