package charactercreator.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import charactercreator.demo.entities.Account;
import charactercreator.demo.entities.CustomCharacter;
import charactercreator.demo.service.AccountService;
import charactercreator.demo.service.CustomCharacterService;
import util.staticMetods;

@RestController
@RequestMapping(value="/character")
public class CustomCharacterController {
    

    @Autowired
    private AccountService accountService;
    

	@Autowired
    private CustomCharacterService customCharacterService;

    @GetMapping(value="/all")
	public ResponseEntity<List<CustomCharacter>> findAll() {
        List<CustomCharacter> result = customCharacterService.findAll();
		return new ResponseEntity<List<CustomCharacter>>(result,HttpStatus.ACCEPTED);
	}

    
    @GetMapping(value="{id}")
	public CustomCharacter findById(@PathVariable Long id) {
		return customCharacterService.findById(id);
	}

    @PostMapping(value="/createCharacter/{name}/{sex}/{fk_c_id}")
    public ResponseEntity<CustomCharacter> findCharacter(@PathVariable String name, @PathVariable String sex, @PathVariable Long fk_c_id){


        

        try{
            CustomCharacter result = staticMetods.characterGenerator(name, sex, accountService.findById(fk_c_id));  

            customCharacterService.save(result);

            return new ResponseEntity<>(result,HttpStatus.CREATED); 
        }catch(EmptyResultDataAccessException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
        
    };



}
