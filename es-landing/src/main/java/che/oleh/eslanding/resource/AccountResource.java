package che.oleh.eslanding.resource;

import che.oleh.eslanding.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class AccountResource {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/account")
    public String greeting(@RequestParam(name="id") Long id, Model model) {
        model.addAttribute("account",
                           restTemplate.getForObject("http://account-service/account/" + id, Account.class)
        );
        return "greeting";
    }

    @PostMapping("/signup")
    public String addAccount(@RequestBody Account account, Model model) {
        Account account2 = restTemplate.postForObject("http://localhost:8082/account/", account, Account.class);
        return "index";
    }

}