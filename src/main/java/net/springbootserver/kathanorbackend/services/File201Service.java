package net.springbootserver.kathanorbackend.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import net.springbootserver.kathanorbackend.models.File201;
import net.springbootserver.kathanorbackend.repositories.File201Repository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class File201Service {
  @Autowired
  private File201Repository file201Repo;

  public String addFile(String uploadedBy, String dateUploaded, String employeeId, String docType, MultipartFile file)
    throws IOException {
    File201 file201 = new File201();
    file201.setEmployeeId(employeeId);
    file201.setDocType(docType);
    file201.setUploadedBy(uploadedBy);
    file201.setDateUploaded(dateUploaded);
    file201.setMimeType(file.getContentType());
    file201.setFilename(file.getOriginalFilename());

    file201.setContent(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
    file201 = file201Repo.insert(file201);
    return file201.getId();
  }

  public File201 getFile(String id) {
    return file201Repo.findById(id).get();
  }

  public List<File201> getAllFiles() {
    return file201Repo.findAll();
  }

  public List<File201> findAllFiles(String empId) {
    File201 file = new File201();
    file.setEmployeeId(empId);

    ExampleMatcher matcher = ExampleMatcher
      .matching()
      .withTransformer(
        "content",
        new ExampleMatcher.PropertyValueTransformer() {
          @Override
          public Optional<Object> apply(Optional<Object> o) {
            return null;
          }
        }
      );

    Example<File201> example = Example.of(file, matcher);
        
    return file201Repo.findAll(example);
  }
}
