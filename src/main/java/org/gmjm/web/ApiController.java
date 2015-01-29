package org.gmjm.web;

import org.gmjm.domain.Card;
import org.gmjm.repo.es.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/api")
public class ApiController {
	
	@Autowired
	private CardRepository cardRepository;
	
	@RequestMapping(value="search")
	public Page<Card> queryForCards(@RequestParam MultiValueMap<String, String> parameters) {
		PageRequest pageRequest = new PageRequest(0, 10);
		return cardRepository.findByName(parameters.get("name").get(0), pageRequest);
	}

}
