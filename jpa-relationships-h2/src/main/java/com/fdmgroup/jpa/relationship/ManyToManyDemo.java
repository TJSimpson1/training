package com.fdmgroup.jpa.relationship;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManyToManyDemo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jparelationship");
		EntityManager em = emf.createEntityManager();
		
		Book book1 = new Book("Dune");
		Book book2 = new Book("100 Years of Solitude");
		Book book3 = new Book("Design Patterns: Elements of Reusable Object Oriented Software");
				
		Author author1 = new Author("Frank", "Herbert");
		Author author2 = new Author("Gabriel", "Garcia Marquez");
		Author author3 = new Author("Erich", "Gamma");
		Author author4 = new Author("Richard", "Helm");
		Author author5 = new Author("Ralph", "Johnson");
		Author author6 = new Author("John", "Vlissides");
				
//		author1.getBooks().add(book1);
//		author2.getBooks().add(book2);
//		author3.getBooks().add(book3);
//		author4.getBooks().add(book3);
//		author5.getBooks().add(book3);
//		author6.getBooks().add(book3);
		
		author1.addBook(book1);
		author2.addBook(book2);
		author3.addBook(book3);
		author4.addBook(book3);
		author5.addBook(book3);
		author6.addBook(book3);
		
		em.getTransaction().begin();
		em.persist(author1);
		em.persist(author2);
		em.persist(author3);
		em.persist(author4);
		em.persist(author5);
		em.persist(author6);
		em.getTransaction().commit();
		
		List<Book> booksFromAuthorsLastName = em.createNamedQuery("Author.findByLastName", Author.class)
				.setParameter("givenLastName", "Herbert")
				.getResultList()
				.get(0)
				.getBooks();
		
		System.out.println("Looking for books based on author's last names: ");
		booksFromAuthorsLastName.forEach(book -> System.out.println(book));
		
		
		
		List<Author> authorsFromBookTitle = em.createNamedQuery("Book.findByTitle", Book.class)
				.setParameter("givenTitle", "Design Patterns: Elements of Reusable Object Oriented Software")
				.getResultList()
				.get(0)
				.getAuthors();
		
		System.out.println("Looking for authors based on book title");
		authorsFromBookTitle.forEach(author -> System.out.println(author));
		
		em.close();
		emf.close();

	}

}
