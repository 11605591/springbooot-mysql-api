package com.learning.mysqlproj.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.mysqlproj.repository.RepositoryInter;
import com.learning.mysqlproj.tablecre.EmployeeDetails;

@RestController
public class ControllerClass {
	@Autowired
	private RepositoryInter repo;

	@GetMapping("/check")
	public String working() {
		return "yaa its working";
	}

	@GetMapping("/findallemployees")
	public List<EmployeeDetails> findAllEmployees() {
		return repo.findAll();

	}

	@RequestMapping("/findbyid/{id}")
	public Optional<EmployeeDetails> findById(@PathVariable String id) {
		int byid = Integer.parseInt(id);
		return repo.findById(byid);
	}

	@PostMapping("/adddetails")
	public List<EmployeeDetails> addingEmployee(@RequestBody EmployeeDetails emp) {
		repo.save(emp);
		return repo.findAll();
	}

	@DeleteMapping("/delete/{id}")
	public String deleteTheEmployee(@PathVariable String id) {
		int sid = Integer.parseInt(id);
		EmployeeDetails emp = repo.getById(sid);
		repo.delete(emp);
		return "deleted";
	}

	@PutMapping("/change/{id}")
	public String updateOrChange(@RequestBody EmployeeDetails emp) {
		repo.save(emp);
		return "done";
	}
}
