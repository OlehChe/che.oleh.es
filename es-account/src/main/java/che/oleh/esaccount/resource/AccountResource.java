package che.oleh.esaccount.resource;

import che.oleh.esaccount.entity.Account;
import che.oleh.esaccount.repo.AccountRepository;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountResource {

    static final String topicExchangeName = "spring-boot-exchange";
    @Autowired
    private AccountRepository accountRepo;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/{id}")
    public Account getAccount(
        @PathVariable(name = "id")
            Long id) {
        return accountRepo.find(id);
    }

    @PostMapping()
    public Account addAccount(@RequestBody Account account) {
        rabbitTemplate.convertAndSend(topicExchangeName, "foo.bar.baz",
                                      String.format("Hello, %s, %s!", account.getFirstName(), account.getLastName()));
        return accountRepo.create(account);
    }
}
