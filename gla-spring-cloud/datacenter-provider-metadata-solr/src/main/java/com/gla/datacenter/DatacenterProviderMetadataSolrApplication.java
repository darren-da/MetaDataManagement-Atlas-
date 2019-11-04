package com.gla.datacenter;

import org.apache.solr.client.solrj.SolrClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.solr.core.SolrTemplate;

@SpringBootApplication
public class DatacenterProviderMetadataSolrApplication {
	@Bean
	public SolrTemplate  solrTemplate(SolrClient  solrClient){
		return new SolrTemplate(solrClient);
	}
	public static void main(String[] args) {
		SpringApplication.run(DatacenterProviderMetadataSolrApplication.class, args);
	}

}
