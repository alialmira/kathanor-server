package net.springbootserver.kathanorbackend.controllers;

import java.util.List;

import net.springbootserver.kathanorbackend.models.Employee;
import net.springbootserver.kathanorbackend.repositories.IEmployeeRepository;

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
@RequestMapping("/kathanor-api/employee")
public class EmployeeControllers {
    
    @Autowired
    private IEmployeeRepository employeeRepository;

    public EmployeeControllers(IEmployeeRepository employeeRepo){
        this.employeeRepository = employeeRepo;
    }

    @ApiOperation(value = "Get employee account by id", nickname = "getEmployeeById")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee GetById(@PathVariable("id") ObjectId id) {
        return this.employeeRepository.findBy_id(id);
    }

    @ApiOperation(value = "Get all employee account", nickname = "getEmployee")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Employee> GetAll() {
        List<Employee> EmployeesList = this.employeeRepository.findAll();
        return EmployeesList;
    }
    
    @ApiOperation(value = "Insert some employee account", nickname = "addEmployee")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Employee Insert(@RequestBody Employee model) {
        model.setId(ObjectId.get());
        this.employeeRepository.insert(model);
        return model;
    }
    
    @ApiOperation(value = "Update this employee account", nickname = "updateEmployee")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Employee Update(@PathVariable("id") ObjectId id, @Validated @RequestBody Employee model) {
        model.setId(id);
        this.employeeRepository.save(model);
        return model;
    }
    
    @ApiOperation(value = "Delete this employee account", nickname = "deleteEmployee")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void Delete(@PathVariable("id") ObjectId id) {
        this.employeeRepository.delete(this.employeeRepository.findBy_id(id));
    }

}
