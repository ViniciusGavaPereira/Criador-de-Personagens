package charactercreator.demo.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("customCharacterGPT")
public class CustomCharacterGPT extends CustomCharacter{


    @Column(columnDefinition = "TEXT")
    private String backstory;

    public CustomCharacterGPT() {
    }

    
    public CustomCharacterGPT(CustomCharacter customCharacter, Account account, String backstory) {
        super(customCharacter.getName(), customCharacter.getSex(), customCharacter.getRace(), customCharacter.getCharacterClass(), customCharacter.getLevel(), customCharacter.getAlignments(), account);
        this.backstory = backstory;
    }



    public String getBackstory() {
        return backstory;
    }

    public void setBackstory(String backstory) {
        this.backstory = backstory;
    }


    @Override
    public String toString() {
        return "CustomCharacterGPT [backstory=" + backstory + "]";
    }

    
}
