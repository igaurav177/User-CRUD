package com.example;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")//for all external networks we can use hitting this requests 
public class UserController {
	
	@Autowired
	UserRepo repo;
	
	Logger log = Logger.getAnonymousLogger();
	//insert
	@PostMapping("/register")
	public String register(@RequestBody User user) {
		repo.save(user);
		return "Hi "+user.getName()+" is registered successfully...!";
		
	}
	
	
	//list of users 
	@GetMapping("/getAllusers")
	public List<User> findAllusers(){
		return repo.findAll();
	}
	
	
	//delete by id
	
	@DeleteMapping("/cancel/{id}")
	public List<User> cancelregistration(@PathVariable int id){
		repo.deleteById(id);
		return repo.findAll();
	}
	
	
	//search via email 
	@GetMapping("/findbyemail/{email}")
	public List<User> findUser(@PathVariable String email){
		return repo.findByemail(email);
	}


//update
	@PutMapping("/update")
    public String updateUser(@RequestBody User user) {
        User existingUser = repo.findById(user.id).orElse(null);
        log.info("request hit"+user.id);

        if (existingUser != null) {
        	 existingUser.setName(user.getName());
             existingUser.setEmail(user.getEmail());
             existingUser.setExperience(user.getExperience());
             existingUser.setDomain(user.getDomain());
            repo.save(existingUser);
            return "User with id " + user.id + " updated successfully!";
        } else {
            return "User with id " + user.id + " not found!";
        }
	}
}
	