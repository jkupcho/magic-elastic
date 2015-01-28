package org.gmjm;

import org.gmjm.config.ElasticSearchConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ElasticSearchConfiguration.class)
public class MagicElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(MagicElasticApplication.class, args);
    }
}
