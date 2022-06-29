package net.springbootserver.kathanorbackend.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "document")
public class Documents {

  @Id
  private ObjectId _id;

  private String employeeId;
  private String file;
  private String docType;
  private String date;
  private String fileName;
  private Boolean fileStatus;

  public Documents(String employeeId, String date, 
    String file, String docType, String fileName, Boolean fileStatus) {
    this.employeeId = employeeId;
    this.file = file;
    this.date = date;
    this.docType = docType;
    this.fileName = fileName;
    this.fileStatus = fileStatus;
  }

  public String getId() {
    return _id.toHexString();
  }

  public void setId(ObjectId _Id) {
    this._id = _Id;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  public String getfile() {
    return file;
  }

  public void setfile(String file) {
    this.file = file;
  }

  public String getdocType() {
    return docType;
  }

  public void setdocType(String docType) {
    this.docType = docType;
  }

  public String getfileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getdate() {
    return date;
  }

  public void setdate(String date) {
    this.date = date;
  }

  public void setFileStatus(Boolean fileStatus) {
    this.fileStatus = fileStatus;
  }

  public Boolean getFileStatus() {
    return fileStatus;
  }

}
