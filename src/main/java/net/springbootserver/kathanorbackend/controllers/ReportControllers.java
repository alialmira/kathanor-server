package net.springbootserver.kathanorbackend.controllers;
import java.util.List;
import net.springbootserver.kathanorbackend.models.Report;
import net.springbootserver.kathanorbackend.repositories.ReportRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/kathanor-api/report")
public class ReportControllers {
    
    @Autowired
    private ReportRepository reportRepository;

    public ReportControllers(ReportRepository reportRepo){
        this.reportRepository = reportRepo;
    }

    @ApiOperation(value = "Get all reports", nickname = "getReports")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Report> GetAll() {
        List<Report> ReportList = this.reportRepository.findAll();
        return ReportList;
    }
    
    @ApiOperation(value = "Insert some reports", nickname = "addReport")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Report Insert(@RequestBody Report model) {
        model.setId(ObjectId.get());
        this.reportRepository.insert(model);
        return model;
    }

}
