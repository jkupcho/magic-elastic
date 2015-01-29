package org.gmjm.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableAutoConfiguration(exclude={ ElasticsearchAutoConfiguration.class })
@EnableElasticsearchRepositories(basePackages="org.gmjm.repo.es")
public class ElasticSearchConfiguration {
	
	@Bean
	public ElasticsearchOperations elasticsearchTemplate() {
		ElasticsearchTemplate elasticsearchTemplate = new ElasticsearchTemplate(client());
		return elasticsearchTemplate;
	}
	
	@Bean
	public Client client() {
		TransportClient client = new TransportClient();
		client.addTransportAddress(new InetSocketTransportAddress("54.172.26.55", 9300));
		return client;
	}

}
