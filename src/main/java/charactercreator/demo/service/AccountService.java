package charactercreator.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import charactercreator.demo.entities.Account;
import charactercreator.demo.repositories.AccountRepository;

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


    public void createAccount(Account account){
        accountRepository.save(account);
    } 

    public void deleteById(Long id){
        accountRepository.deleteById(id);
    }

    


}

