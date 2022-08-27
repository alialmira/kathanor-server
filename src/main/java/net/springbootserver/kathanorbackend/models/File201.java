package net.springbootserver.kathanorbackend.models;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "File201")
public class File201 {

  @Id
  private String id;

  private String uploadedBy;
  private String employeeId;
  private String dateUploaded;
  private String filename;
  private String docType; 
  private String mimeType;
  private Binary content;
  
  public File201() { }

  public String getId() {
      return id;
  }
  public void setId(String id) {
      this.id = id;
  }
  public String getFilename() {
      return filename;
  }
  public void setFilename(String filename) {
      this.filename = filename;
  }
  public String getDateUploaded() {
    return dateUploaded;
  }
  public void setDateUploaded(String dateUploaded){
    this.dateUploaded = dateUploaded;
  }
  public String getDocType() {
      return docType;
  }
  public void setDocType(String docType) {
      this.docType = docType;
  }
  public void setMimeType(String mimeType) {
      this.mimeType = mimeType;
  }
  public String getMimeType() {
      return mimeType;
  }
  public void setContent(Binary content) {
      this.content = content;
  }
  public Binary getContent() {
      return content;
  }
  public String getEmployeeId() {
      return employeeId;
  }
  public void setEmployeeId(String employeeId) {
      this.employeeId = employeeId;
  }
  public String getUploadedBy() {
      return uploadedBy;
  }
  public void setUploadedBy(String uploadedBy) {
      this.uploadedBy = uploadedBy;
  }
}
