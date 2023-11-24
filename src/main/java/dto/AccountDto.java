package dto;

import java.util.List;
import java.util.stream.Collectors;

import charactercreator.demo.entities.Account;

public class AccountDto {
    private String name;
    private String cpf;
    private String email;

    public AccountDto() {
    }
    

    public AccountDto(Account account) {
        name = account.getName();
        cpf = account.getCpf();
        email = account.getEmail();
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

    

    public static List<AccountDto> accountConverter(List<Account> accounts){
        return accounts.stream().map(AccountDto :: new ).collect(Collectors.toList());
    }



}
