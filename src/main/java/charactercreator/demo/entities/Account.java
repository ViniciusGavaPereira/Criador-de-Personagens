package charactercreator.demo.entities;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Account" )
public class Account {
    
   

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long a_id;
    private String name;
    @Column(unique=true)
    private String cpf;
    @Column(unique=true)
    private String email;
    private String password;
    @OneToMany(targetEntity = CustomCharacter.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "Fk_c_Id", referencedColumnName = "a_id" )
    private List<CustomCharacter> customCharacters;


   
    public Account() {
    }

    public Account( String name, String cpf, String email, String password) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        setPassword(password);
    }
    
    public Long getA_id() {
        return a_id;
    }
    public void setA_id(Long a_id) {
        this.a_id = a_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

 public void setPassword(String password) {

         try {
            // Crie uma instância do MessageDigest com o algoritmo SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            
            // Converta a senha em bytes
            byte[] senhaBytes = password.getBytes(StandardCharsets.UTF_8);
            
            // Calcule o hash da senha
            byte[] hashBytes = digest.digest(senhaBytes);
            
            // Converta o hash em uma representação hexadecimal
            StringBuilder hashHex = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = String.format("%02x", b);
                hashHex.append(hex);
            }
            

           this.password = hashHex.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }




    public String getPassword() {
        return password;
    }
    
    

    
}
