package org.gmjm.web;

import org.gmjm.domain.Card;
import org.gmjm.repo.es.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/api")
public class ApiController {
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	@RequestMapping(value="search", produces="application/json")
	public @ResponseBody Page<Card> queryForCards(@RequestParam MultiValueMap<String, String> parameters) {
		String name = parameters.get("name").get(0).trim().toLowerCase();
		PageRequest pageRequest = new PageRequest(0, 10);
		
		Page<Card> cards = cardRepository.findByName(name, pageRequest);
		return cards;
	}

}
