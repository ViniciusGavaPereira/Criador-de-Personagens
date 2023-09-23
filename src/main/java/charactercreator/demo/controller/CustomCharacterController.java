package charactercreator.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import charactercreator.demo.entities.CustomCharacter;
import charactercreator.demo.service.AccountService;
import charactercreator.demo.service.CustomCharacterService;
import dto.CustomCharacterDto;
import util.staticMetods;

@RestController
@RequestMapping(value="/character")
public class CustomCharacterController {
    

    @Autowired
    private AccountService accountService;
    

	@Autowired
    private CustomCharacterService customCharacterService;

    @GetMapping(value="/all")
	public ResponseEntity<List<CustomCharacterDto>> findAll() {
        List<CustomCharacter> result = customCharacterService.findAll();
		return new ResponseEntity<List<CustomCharacterDto>>(CustomCharacterDto.customCharacterConverter(result) ,HttpStatus.ACCEPTED);
	}

    
    @GetMapping(value="{id}")
	public CustomCharacterDto findById(@PathVariable Long id) {
        CustomCharacter customCharacter = customCharacterService.findById(id);
		return new CustomCharacterDto(customCharacter);
	}

    @PostMapping(value="/createCharacter/{name}/{sex}/{fk_c_id}")
    public ResponseEntity<CustomCharacterDto> findCharacter(@PathVariable String name, @PathVariable String sex, @PathVariable Long fk_c_id){

        try{

            Integer numberOfCustomCharacters = customCharacterService.totalCustomCharacters(fk_c_id);
            System.out.println("ATENÇÃO::::      " + numberOfCustomCharacters);

            if(numberOfCustomCharacters < 3){
                CustomCharacter result = staticMetods.characterGenerator(name, sex, accountService.findById(fk_c_id));  

                customCharacterService.save(result);

                CustomCharacterDto customCharacterDto = new CustomCharacterDto(result);
                
                return new ResponseEntity<>(customCharacterDto,HttpStatus.CREATED); 

            }else{
                return new ResponseEntity<>(HttpStatus.FORBIDDEN); 

            }

            

        }catch(EmptyResultDataAccessException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
        
    };

    @DeleteMapping(value="{id}")
    @ResponseBody
    public  ResponseEntity<Void> deleteById(@PathVariable Long id ){


        try{

            customCharacterService.deleteById(id);
        
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch(EmptyResultDataAccessException e){

            throw new EmptyResultDataAccessException(e.getMessage(), 0);
        }
      
    }



}
