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

   public void deleteById(Long id){
     customCharacterRepository.deleteById(id);
   }

   public Integer totalCustomCharacters(Long Fk_C_Id){

      List<CustomCharacter> list = customCharacterRepository.findByFKId(Fk_C_Id);
     return list.size();
   }

}
