package com.app.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.dao.EmployeeRepository;
import com.app.model.Employee;

import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/employee")
public class EmployeeResource {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/save")
	public Employee saveEmployee(Employee emp) {	
		
		return empRepo.save(emp);	
	}
	
	@GET
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/getListofEmployees")
	public List<Employee> getList(){
		
		return empRepo.findAll();
	}
	
	@GET
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/getEmployeeByName/{name}")
	public Employee employeeByName(@PathParam("name") String name) {
		System.out.println(" Name of the Employee :  " + name );
		//This method is not working as expected - Connect to db and check from there
		return empRepo.findByName(name);
	}

}
