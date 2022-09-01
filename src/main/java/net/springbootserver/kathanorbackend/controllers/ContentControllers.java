package net.springbootserver.kathanorbackend.controllers;
import java.util.List;
import net.springbootserver.kathanorbackend.models.Content;
import net.springbootserver.kathanorbackend.repositories.ContentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/kathanor-api/content")
public class ContentControllers {
    
    @Autowired
    private ContentRepository contentRepository;

    public ContentControllers(ContentRepository contentRepo){
        this.contentRepository = contentRepo;
    }

    @ApiOperation(value = "Get all dashboard content", nickname = "getContent")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Content> GetAll() {
        List<Content> ContentList = this.contentRepository.findAll();
        return ContentList;
    }

    @ApiOperation(value = "Get content by id", nickname = "getContentById")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Content GetById(@PathVariable("id") ObjectId id) {
        return this.contentRepository.findBy_id(id);
    }
    
    @ApiOperation(value = "Insert dashboard content", nickname = "addContent")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Content Insert(@RequestBody Content model) {
        model.setId(ObjectId.get());
        this.contentRepository.insert(model);
        return model;
    }
    
    @ApiOperation(value = "Update dashboard content", nickname = "updateContent")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Content Update(@PathVariable("id") ObjectId id, @Validated @RequestBody Content model) {
        model.setId(id);
        this.contentRepository.save(model);
        return model;
    }

}
