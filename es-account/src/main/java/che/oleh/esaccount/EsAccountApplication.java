package che.oleh.esaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class EsAccountApplication {

//    @Bean
//    public RabbitTemplate getRabbitTemplate() {
//        return new RabbitTemplate();
//    }

    public static void main(String[] args) {
        SpringApplication.run(EsAccountApplication.class, args);
    }

}
