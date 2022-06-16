package net.springbootserver.kathanorbackend.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "document")
public class Documents {

  @Id
  private ObjectId _id;

  private String firstName;
  private String middleName;
  private String lastName;
  private String bod;
  private String pod;
  private String address;
  private String agency;
  private String position;
  private String file;
  private String docType;
  private String date;
  private String fileName;
  private Boolean fileStatus;

  public Documents(String firstName, String middleName, String lastName, String bod,
    String pod, String address, String agency, String position, String date, 
    String file, String docType, String fileName, Boolean fileStatus) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.bod = bod;
    this.pod = pod;
    this.address = address;
    this.agency = agency;
    this.position = position;
    this.file = file;
    this.date = date;
    this.docType = docType;
    this.fileName = fileName;
    this.fileStatus = fileStatus;
  }

  public String get_id() {
    return _id.toHexString();
  }

  public void set_id(ObjectId _Id) {
    this._id = _Id;
  }

  public String getfile() {
    return file;
  }

  public void setfile(String file) {
    this.file = file;
  }

  public void setLastName(String lastName) {
      this.lastName = lastName;
  }
  
  public String getFirstName() {
      return firstName;
  }

  public void setMiddleName(String middleName){
      this.middleName = middleName;
  }

  public String getMIddleName() {
      return middleName;
  }

  public String getLastName() {
      return lastName;
  } 

  public void setFirstName(String firstName) {
      this.firstName = firstName;
  }

  public void setBirthDate(String bod) {
      this.bod = bod;
  }

  public String getBirthDate() {
      return bod;
  }

  public void setBirthPlace(String pod) {
      this.pod = pod;
  }

  public String getBirthPlace() {
      return pod;
  }

  public void setAddress(String address) {
      this.address = address;
  }

  public String getAddress() {
      return address;
  }

  public void setAgency(String agency){
      this.agency = agency;
  }

  public String getAgency(){
      return agency;
  }

  public void setPosition(String position) {
      this.position = position;
  }

  public String getPosition() {
      return position;
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
