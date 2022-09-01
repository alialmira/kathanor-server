package net.springbootserver.kathanorbackend.models;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "contents")
public class Content {
    
    @Id
    private ObjectId _id;

    private String contentType;
    private String content;

    public Content(String contentType, String content){
        this.contentType = contentType;
        this.content = content;
    }

    public void setId(ObjectId _Id) {
        this._id = _Id;
    }

    public String getId() {
        return _id.toHexString();
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    } 

    public void setContent(String content) {
        this.content = content;
    }
     
    public String getContent() {
        return content;
    }

}
