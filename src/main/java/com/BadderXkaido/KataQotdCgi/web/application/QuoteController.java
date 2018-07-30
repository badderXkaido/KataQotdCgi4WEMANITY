package com.BadderXkaido.KataQotdCgi.web.application;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.BadderXkaido.KataQotdCgi.business.logic.QuoteService;
import com.BadderXkaido.KataQotdCgi.data.entity.Quote;

@Controller
@RequestMapping(value="/")
public class QuoteController {

	@Autowired
	private QuoteService quoteService;
	
	// Create a controller to get All Quotes 
	@RequestMapping(path="/quotes",method=RequestMethod.GET)
	public String getQuotes(Model model) 
		{	 
			List<Quote> listQuotes = quoteService.getAllQuotes();
			model.addAttribute("listQuotes", listQuotes);
			return "quotes";
		}
	
	// Create a controller to get One Quote
	@RequestMapping(path="/onequote" ,method=RequestMethod.GET)
	public String getOneQuote(Model model) 
		{
		Quote q = quoteService.getQuoteById(2L);
		model.addAttribute("onlyOneQuote", q);
		return "onequote";
		}
	
	// Create a controller for a Randomize Quote
	@RequestMapping(path="/randomquote",method=RequestMethod.GET)
	public String randomQuote(Model model) 
		{
		Quote q = quoteService.getRandomizedQuote();
		model.addAttribute("randomquote", q);
		return "randomquote";
		}
	
	// Create a controller for a contain string in a random quote
	@RequestMapping(path= {"parquote"}, method=RequestMethod.GET)
	public String getRandomQuoteByContainString(@RequestParam("q") String subString, Model model) 
		{
		//Get the quote that have the subString
		Quote QuoteSubString = quoteService.findcontainString(subString);
		if(QuoteSubString==null) 
			{
			try {
				throw (new Exception("Quote equal NULL"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "error";
			}
		model.addAttribute("subQuote", QuoteSubString);
		
		
		return "parquote";
		}
}
