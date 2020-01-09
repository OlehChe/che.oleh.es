package che.oleh.esaccount.repo;

import che.oleh.esaccount.entity.Account;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {

    @PersistenceContext
    private EntityManager em;

    public Account find(Long id) {
        return em.find(Account.class, id);
    }

    public Account create(Account account) {
        em.persist(account);
        return account;
    }

}
