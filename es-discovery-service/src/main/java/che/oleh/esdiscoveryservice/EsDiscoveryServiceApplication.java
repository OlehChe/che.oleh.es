package che.oleh.esdiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EsDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsDiscoveryServiceApplication.class, args);
	}

}
