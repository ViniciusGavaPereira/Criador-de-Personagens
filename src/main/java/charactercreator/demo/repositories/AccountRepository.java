package charactercreator.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import charactercreator.demo.entities.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {
    
}
