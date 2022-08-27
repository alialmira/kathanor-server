package net.springbootserver.kathanorbackend.models;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
public class Employee {
    
    @Id
    private ObjectId _id;

    private String lastName;
    private String firstName;
    private String middleName;
    private String extName;
    private String birthDate;
    private String birthPlace;
    private String homeAddress;
    private String currentAddress;
    private String contNumber;
    private String emailAdd;
    private String agency;
    private String position;
    private String accountType;
    private String username;
    private String password;
    private Boolean session;

    public Employee(String lastName, String firstName, String middleName, String extName, String birthDate, String birthPlace, 
    String homeAddress, String currentAddress, String contNumber, String emailAdd, String agency,
    String position, String accountType, String username, String password, Boolean session){
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.extName = extName;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.homeAddress = homeAddress;
        this.currentAddress = currentAddress;
        this.contNumber = contNumber;
        this.emailAdd = emailAdd;
        this.agency = agency;
        this.position = position;
        this.accountType = accountType;
        this.username = username;
        this.password = password;
        this.session = session;
    }

    public void setId(ObjectId _Id) {
        this._id = _Id;
    }

    public String getId() {
        return _id.toHexString();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    } 

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public void setExtensionName(String extName){
        this.extName = extName;
    }

    public String getExtensionName() {
        return extName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }
    
    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setContactNumber(String contNumber) {
        this.contNumber = contNumber;
    }

    public String getContactNumber() {
        return contNumber;
    }

    public void setEmailAddress(String emailAdd) {
        this.emailAdd = emailAdd;
    }

    public String getEmailAddress() {
        return emailAdd;
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

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setSession(Boolean session) {
        this.session = session;
    }

    public Boolean getSession() {
        return session;
    }
}
