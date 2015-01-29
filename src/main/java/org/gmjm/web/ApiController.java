package org.gmjm.web;

import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilders;
import org.gmjm.domain.Card;
import org.gmjm.repo.es.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.FacetedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
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
	public @ResponseBody Page<Card> queryForCards(@RequestParam(required=true) String name, @RequestParam(required=false, defaultValue="0") Integer page) {
		PageRequest pageRequest = new PageRequest(page, 10);
		
		Page<Card> cards = cardRepository.findByName(name, pageRequest);
		return cards;
	}
	
	@RequestMapping(value="search/id/{id}", produces="application/json")
	public @ResponseBody Card queryForCards(@PathVariable String id) {
		return cardRepository.findOne(id);
	}
	
	/**
	 * params:
	 * 	field (0) = fieldName
	 *  range (0) = min
	 *  range (1) = max
	 *  page  (0) = page
	 * 
	 * @param field
	 * @param parameters
	 * @return
	 */
	@RequestMapping(value="search/range", produces="application/json")
	public @ResponseBody FacetedPage<Card> queryForFieldRange(@RequestParam MultiValueMap<String, String> parameters) {
		
		String fieldName = parameters.get("field").get(0);
		String[] rangeVal = parameters.get("range").get(0).split(",");
		Integer page = parameters.get("page") == null ? 0 :  Integer.valueOf(parameters.get("page").get(0));
		
		Integer min = Integer.valueOf(rangeVal[0]);
		Integer max = Integer.valueOf(rangeVal[1]);
		
		SearchQuery query = new NativeSearchQueryBuilder()
		.withQuery(QueryBuilders.matchAllQuery())
		.withFilter(
			FilterBuilders
				.boolFilter()
				.should(
					FilterBuilders
						.rangeFilter(fieldName)
							.from(min)
							.to(max)
			))
		.withPageable(new PageRequest(page, 10)).build();	
		
		FacetedPage<Card> facetedPage = cardRepository.search(query);
		
		return facetedPage;
	}

}
