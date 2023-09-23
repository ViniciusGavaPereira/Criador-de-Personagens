package charactercreator.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import charactercreator.demo.entities.CustomCharacter;


@Repository
public interface CustomCharacterRepository extends JpaRepository<CustomCharacter,Long>{
        
    @Query(value = "SELECT * FROM Custom_Character WHERE FK_C_ID = :fkCId", nativeQuery=true)
    List<CustomCharacter> findByFKId(@Param("fkCId") Long fkCId);
}
