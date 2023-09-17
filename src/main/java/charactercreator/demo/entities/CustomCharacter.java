package charactercreator.demo.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CustomCharacter")
public class CustomCharacter {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long c_id;
    private String name; //Dado pelo usuário ou aleatório +++----
    private String sex; //Dado pelo usuário ou aleatório ++++----
    private String race; //API  ++
    private String characterClass; //API +++
    private Integer level; // Nível aleatório +++----
    private String alignments; //AI

    @ManyToOne // Indica que esta é uma relação muitos-para-um
    @JoinColumn(name = "Fk_c_Id") // Especifica o nome da coluna da chave estrangeira
    private Account account;
    
    public CustomCharacter() {
    }


    public CustomCharacter( String name, String sex, String race, String characterClass, Integer level,String alignments , Account account) {

        this.name = name;
        this.sex = sex;
        this.race = race;
        this.characterClass = characterClass;
        this.level = level;
        this.alignments = alignments;
        this.account = account;
    }


    public Long getC_id() {
        return c_id;
    }
    public void setC_id(Long c_id) {
        this.c_id = c_id;
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
    

    
    

    
}
