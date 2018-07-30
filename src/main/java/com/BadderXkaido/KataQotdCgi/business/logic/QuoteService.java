package com.BadderXkaido.KataQotdCgi.business.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BadderXkaido.KataQotdCgi.data.entity.Quote;
import com.BadderXkaido.KataQotdCgi.data.repository.QuoteRepository;

@Service
public class QuoteService {

	private QuoteRepository quoteRepository;
	
	//Contractor
	
	@Autowired
	public QuoteService(QuoteRepository quoteRepository) 
		{
		this.quoteRepository = quoteRepository ;
		}
	
	// Now we will create a service that getAll the Quotes from our DataBase
	
	public List<Quote> getAllQuotes()
		{
		return this.quoteRepository.findAll();	
		}
	
	
	// Get a Quote by Id
	
	public Quote getQuoteById(Long l) 
		{
		return this.quoteRepository.getOne(l);
		} 
	
	// Get a Randomize Quote
	
	public Quote getRandomizedQuote() 
		{
		Random r = new Random();
		List<Quote> listeQuotes = this.quoteRepository.findAll();
		
		Quote res = listeQuotes.get(r.nextInt(listeQuotes.size()));
		return res;
		}
	
	// Find a contain String in 
	public Quote findcontainString(String string) 
		{
		List<Quote> allQuotes = this.quoteRepository.findAll();
		// this is a List to stock all the Quotes that contain the string 
		List<Quote> matchQuotes = new ArrayList<>();
		
		// Searching inside each Quote to find a subString (In Both Quotes And In Authors Name)
			for (Quote quote : allQuotes) {
				// If we find a match or 
				if(quote.getQuoteString().contains(string) || quote.getAuthor().contains(string) ) 
					
					matchQuotes.add(quote);
				
				}
			
		// Get a random quote from the sub List
				if(matchQuotes!=null) 
					{
					Random r = new Random();
					Quote res = matchQuotes.get(r.nextInt(matchQuotes.size()));
					return res;
					}
					
			return null;	
		}
	
}
