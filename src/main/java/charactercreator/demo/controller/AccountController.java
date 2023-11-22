package charactercreator.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import org.springframework.web.bind.annotation.RequestBody;


import charactercreator.demo.entities.Account;
import charactercreator.demo.service.AccountService;
import dto.AccountDto;

@RestController
@RequestMapping(value = "/account")
public class AccountController {


    @Autowired
    private AccountService accountService;
    
    @GetMapping(value="/all")
    public ResponseEntity<List<AccountDto>> findAll(){
        List<Account> list = accountService.findAll();

   
        return new ResponseEntity<List<AccountDto>>(AccountDto.accountConverter(list), HttpStatus.ACCEPTED);
    }
    
    @GetMapping(value="{id}")
    public ResponseEntity<AccountDto> findID(@PathVariable Long id){
        Account result = accountService.findById(id);

        AccountDto accountDto = new AccountDto(result);
        return new ResponseEntity<AccountDto>(accountDto, HttpStatus.ACCEPTED);
    }
    


    
    @PostMapping()
    public ResponseEntity<?> createAccount(@RequestBody Account accountInput){
        
        try{
            Account account = new Account(accountInput.getName(), accountInput.getCpf(), accountInput.getEmail(), accountInput.getPassword());
            accountService.createAccount(account);

            AccountDto accountDto = new AccountDto(account);

            return new ResponseEntity<AccountDto>(accountDto, HttpStatus.CREATED);


        }catch(DataIntegrityViolationException  e ){
            return ResponseEntity.badRequest().body("CPF ou E-MAIL oferecido já existe no banco de dados e não pode ser duplicado");
        }catch(Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());

        }


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
