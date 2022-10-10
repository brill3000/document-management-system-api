package com.example.graphql;

import com.example.graphql.model.Author;
import com.example.graphql.model.Books;
import com.example.graphql.repository.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootApplication
public class GraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(AuthorRepository authorRepository){
		return args -> {
			Books harry_potter = new Books("Harry Potter");
			Books lord_of_the_rings = new Books("Lord of the rings");
			String firstname = "Brilliant";
			Author author = new Author("Brilliant", "Kaboi", List.of(harry_potter, lord_of_the_rings) );
//			useManualQuery(authorRepository, mongoTemplate, firstname, author);
			System.out.println(authorRepository.findAll());


//			authorRepository.findAuthorByFirstname(firstname)
//					.ifPresentOrElse(a -> {
//						System.out.println(a.getFirstname() + " already exists");
//					}, () -> {
//						System.out.println(author.getFirstname() + " has been added");
//						authorRepository.insert(author);
//					});
		};
	}

	private static void useManualQuery(AuthorRepository authorRepository, MongoTemplate mongoTemplate, String firstname, Author author) throws IllegalAccessException {
		Query query = new Query();
		query.addCriteria(Criteria.where("firstname").is(firstname));
		List<Author> authors = mongoTemplate.find(query, Author.class);

		if(authors.size() > 1){
			throw new IllegalAccessException("Found many authors with Brilliant as a username");
		}
		if (authors.isEmpty()){
			System.out.println(author.getFirstname() + " has been added");
			authorRepository.insert(author);
		}
		else {
			System.out.println(author.getFirstname() + " already exists");
		}
	}
}
