package charactercreator.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import charactercreator.demo.entities.CustomCharacter;


@Repository
public interface CustomCharacterRepository extends JpaRepository<CustomCharacter,Long>{
    

}
