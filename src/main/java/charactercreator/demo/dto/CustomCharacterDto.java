package charactercreator.demo.dto;

import java.util.List;
import java.util.stream.Collectors;

import charactercreator.demo.entities.CustomCharacterGPT;

public class CustomCharacterDto {
    
    private String name; 
    private String sex; 
    private String race; 
    private String characterClass; 
    private Integer level; 
    private String alignments;
    private String backstory;

    
    public CustomCharacterDto() {
    }

    
    public CustomCharacterDto(CustomCharacterGPT customCharacter) {
        name = customCharacter.getName();
        sex = customCharacter.getSex();
        race = customCharacter.getRace();
        characterClass = customCharacter.getCharacterClass();
        level = customCharacter.getLevel();
        alignments = customCharacter.getAlignments();
        backstory = customCharacter.getBackstory();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getRace() {
        return race;
    }
    public void setRace(String race) {
        this.race = race;
    }
    public String getCharacterClass() {
        return characterClass;
    }
    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }
    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
    public String getAlignments() {
        return alignments;
    }
    public void setAlignments(String alignments) {
        this.alignments = alignments;
    } 

        public String getBackstory() {
        return backstory;
    }

    public void setBackstory(String backstory) {
        this.backstory = backstory;
    }


    public static List<CustomCharacterDto> customCharacterConverter(List<CustomCharacterGPT> list){
        return list.stream().map(CustomCharacterDto::new).collect(Collectors.toList());
    }
    


}
