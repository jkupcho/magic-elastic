package org.gmjm.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages="org.gmjm.repo.es")
@ComponentScan(basePackages="org.gmjm.web")
public class ElasticSearchConfiguration {
	
	@Bean
	public ElasticsearchOperations elasticsearchTemplate() {
		TransportClient client = new TransportClient();
		client.addTransportAddress(new InetSocketTransportAddress("54.172.26.55", 9300));
		return new ElasticsearchTemplate(client);
	}

}
