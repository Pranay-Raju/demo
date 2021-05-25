package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.model.PersonRepo;

@RestController 	
public class SampleController {
	
	@GetMapping("/hi")
	public String hello() {
		List<Person> list = new ArrayList<Person>();
		for(int i=10;i<20;i++) {
			list.add(new Person(0, "mvn" + i, 2*i, 2000*i));
		}
		personRepo.saveAll(list);
		return "Hello";
	}
	
	@Autowired
	private PersonRepo personRepo;
	
	@PostMapping("/save")
	public Person save(@RequestBody Person person) {

		System.out.println(person);
		
		Person person2 = personRepo.save(person);
		
		System.out.println(person2);
		
		return person2;
	}
	
	@GetMapping("/all")
	public List<Person> getAll(){
		return personRepo.findAll();
	}
	
	@GetMapping("/all/page/{pageNo}")
	public Page<Person> getAll(@PathVariable int pageNo){
		return personRepo.findAll(PageRequest.of(pageNo, 4));
	}
	
	@GetMapping("/byId/{id}")
	public Optional<Person> getById(@PathVariable int id) {
		return personRepo.findById(id);
		
	}
	

}
