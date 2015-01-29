package org.gmjm.repo.es;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.gmjm.config.ElasticSearchConfiguration;
import org.gmjm.domain.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ElasticSearchConfiguration.class)
public class CardRepositoryIntegrationTest {
	
	@Autowired
	private CardRepository cardRepository;
	
	@Test
	public void testInject() {
		assertNotNull(cardRepository);
	}
	
	@Test
	public void testFindAll() {
		List<Card> card = cardRepository.findAll();
		assertTrue(card.size() > 0);
	}
	
	@Test
	public void testFindByColors() {
		
		PageRequest pr = new PageRequest(0, 10);
		
		Page<Card> cards = cardRepository.findByColorsIn(Arrays.asList("White", "Red"),pr);
		assertNotNull(cards);
		assertEquals(10,cards.getSize());
		
		for(Card c : cards.getContent())
		{
			System.out.println(c);
		}
	}
	
}
