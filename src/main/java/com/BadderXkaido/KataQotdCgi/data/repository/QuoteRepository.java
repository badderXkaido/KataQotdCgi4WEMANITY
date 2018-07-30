package com.BadderXkaido.KataQotdCgi.data.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import com.BadderXkaido.KataQotdCgi.data.entity.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long>{
	
	public Quote findById(long idQuote);
	public Quote findByAuthor(String authorName);
	//List<Quote> findAll();

}
