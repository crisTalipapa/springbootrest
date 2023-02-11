package com.gatesolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://192.168.1.11:3000/")
@RestController
@RequestMapping("railway")
public class BrotherController {
	
	@Autowired
	private BrotherRepo repo;

	@GetMapping("brothers")
	public List<Brothers> getBros(){
		
	List<Brothers> brothers= (List<Brothers>) repo.findAll();
	
	
	
	return brothers;
		
	}
	//create brothers rest api send to sql
	@PostMapping("/brother")
	public Brothers createBrother(@RequestBody Brothers brod) {
		return repo.save(brod);
	}
	//get brother rest api using Id from sql
	@GetMapping("/brother/{Id}")
	public ResponseEntity<Brothers> getBrotherbyId(@PathVariable int Id){
		Brothers brother =repo.findById(Id)
				.orElseThrow(() -> new ResourceNotFound("Mamber not Exist with id: " +Id));
		return ResponseEntity.ok(brother);
	}
 	
	@PutMapping("/brother/{Id}")
	public ResponseEntity <Brothers> updateBrother(@PathVariable int Id,@RequestBody Brothers memberDetails){
		Brothers brother =repo.findById(Id)
				.orElseThrow(() -> new ResourceNotFound("Mamber not Exist with id: " +Id));
		
		brother.setName(memberDetails.getName());
		brother.setEmail(memberDetails.getEmail());
		brother.setPassword(memberDetails.getPassword());
		brother.setOnline(memberDetails.getOnline());
		brother.setPosition(memberDetails.getPosition());
		brother.setLocation(memberDetails.getLocation());
		brother.setImg(memberDetails.getImg());
		brother.setLikes(memberDetails.getLikes());
		brother.setDislikes(memberDetails.getDislikes());
		brother.setComments(memberDetails.getComments());
		
		Brothers updatedMember=repo.save(brother);
		return ResponseEntity.ok(updatedMember);
		
	}
	@DeleteMapping("/bro/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteMember(@PathVariable int id){
		Brothers brother =repo.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Mamber not Exist with id: " +id));
		repo.delete(brother);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
