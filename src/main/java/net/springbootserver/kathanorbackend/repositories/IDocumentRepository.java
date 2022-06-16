package net.springbootserver.kathanorbackend.repositories;

import net.springbootserver.kathanorbackend.models.Documents;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IDocumentRepository extends MongoRepository<Documents, String> {
  Documents findBy_id(String _id);
}
