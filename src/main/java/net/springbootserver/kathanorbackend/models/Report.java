package net.springbootserver.kathanorbackend.models;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "report")
public class Report {
    
    @Id
    private ObjectId _id;

    private String fullname;
    private String birthDate;
    private String accountType;
    private String dateRecorded;
    private String day;
    private String month;
    private String year;

    public Report(String fullname, String birthDate, String accountType, String dateRecorded, 
    String day, String month, String year){
        this.fullname = fullname;
        this.birthDate = birthDate;
        this.accountType = accountType;
        this.dateRecorded = dateRecorded;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setId(ObjectId _Id) {
        this._id = _Id;
    }

    public String getId() {
        return _id.toHexString();
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    } 

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
     
    public String getBirthdate() {
        return birthDate;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
     
    public String getAccountType() {
        return accountType;
    }

    public void setDateRecorded(String dateRecorded) {
        this.dateRecorded = dateRecorded;
    }
     
    public String getDateRecorded() {
        return dateRecorded;
    }

    public void setDay(String day) {
        this.day = day;
    }
     
    public String getDay() {
        return day;
    }

    public void setMonth(String month) {
        this.month = month;
    }
     
    public String getMonth() {
        return month;
    }

    public void setYear(String year) {
        this.year = year;
    }
     
    public String getYear() {
        return year;
    }

}
