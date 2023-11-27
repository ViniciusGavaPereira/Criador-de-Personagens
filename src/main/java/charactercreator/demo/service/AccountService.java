package charactercreator.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import charactercreator.demo.dto.AccountDto;
import charactercreator.demo.entities.Account;
import charactercreator.demo.exception.CustomApplicationException;
import charactercreator.demo.repositories.AccountRepository;
import charactercreator.demo.util.cpfMethods;


@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;


    public List<Account> findAll(){
    
        return accountRepository.findAll();
    }
    
    public Account findById(Long id){
        return accountRepository.findById(id).get();
    }


    public void createAccount(Account account) throws Exception{
        

        if(cpfMethods.isCPF(account.getCpf()) == true){
            accountRepository.save(account);
        }else{
            throw new Exception("Invalid cpf");
        }

       
    } 

    public void deleteById(Long id){
        accountRepository.deleteById(id);
    }


    public AccountDto update(Long id, Account accountInput){
        
        Account account = accountRepository.findById(id)
            .orElseThrow(() -> new CustomApplicationException("Account not found", HttpStatus.NOT_FOUND));
   

        account.setName(accountInput.getName());
        account.setCpf(accountInput.getCpf());
        account.setEmail(accountInput.getEmail());
        account.setPassword(accountInput.getPassword());

        accountRepository.save(account);

        return new AccountDto(account);

    
    }


}

