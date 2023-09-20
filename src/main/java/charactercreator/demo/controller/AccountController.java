package charactercreator.demo.controller;

import java.util.List;
import java.util.Optional;

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

import charactercreator.demo.entities.Account;
import charactercreator.demo.service.AccountService;

@RestController
@RequestMapping(value = "/account")
public class AccountController {


    @Autowired
    private AccountService accountService;
    
    @GetMapping(value="/all")
    public ResponseEntity<List<Account>> findAll(){
        List<Account> list = accountService.findAll();
        System.out.println(list);
        return new ResponseEntity<List<Account>>(list, HttpStatus.ACCEPTED);
    }
    
    @GetMapping(value="{id}")
    public ResponseEntity<Account> findID(@PathVariable Long id){
        Account result = accountService.findById(id);
        System.out.println(result);
        return new ResponseEntity<Account>(result, HttpStatus.ACCEPTED);
    }
    


    
    @PostMapping(value="{name}/{cpf}/{email}/{password}")
    public ResponseEntity<Account> createAccount(@PathVariable String name, @PathVariable String cpf, @PathVariable String email, @PathVariable String password ){

        Account account = new Account(name, cpf, email, password);
        accountService.createAccount(account);
        return new ResponseEntity<Account>(account, HttpStatus.CREATED);

    }

    @DeleteMapping(value="{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteById(@PathVariable Long id){

        try{

            accountService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch(EmptyResultDataAccessException e){
            throw new EmptyResultDataAccessException(e.getMessage(), 0);
        }

        
    }
 }
