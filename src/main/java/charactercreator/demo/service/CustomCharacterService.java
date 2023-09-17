package charactercreator.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import charactercreator.demo.entities.CustomCharacter;
import charactercreator.demo.repositories.CustomCharacterRepository;

@Service
public class CustomCharacterService {
    
   @Autowired
   private CustomCharacterRepository customCharacterRepository;


   public List<CustomCharacter> findAll(){
        return customCharacterRepository.findAll();
   }

   public CustomCharacter findById(Long id){
        return customCharacterRepository.findById(id).get();
   }

   public void save(CustomCharacter customCharacter){
     customCharacterRepository.save(customCharacter);
   }

}
