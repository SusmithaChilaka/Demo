package com.cg.testservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.cg.AuthorListRepository;
import com.cg.AuthorRepository;
import com.cg.LoginRepository;
import com.cg.model.Author;
import com.cg.model.Book;
import com.cg.model.User;
import com.cg.service.AuthorService;

@ExtendWith(MockitoExtension.class)
class TestAuthorService {
	@InjectMocks
	AuthorService authorservice;
	
	@Mock
	AuthorRepository authorRepository;
	@Mock
	AuthorListRepository repository;
	@Mock
	LoginRepository loginrepository;
	
	@Test
	void testSave() {
		Book books = new Book();
		books.setId(1);
		books.setTitle("Romeo and juliet");
		books.setAuthor("shakesphere");
		books.setCategory("drama");
		books.setPrice(1000);
		books.setPublisher("SVNC");
		books.setDate("1990-02-26");
		books.setContent("Story");
		when(authorRepository.save(books)).thenReturn(books);//mock
		authorservice.save(books);
		assertEquals(1,	books.getId());
	}
	
    @Test
     void testGetBooks() throws Exception {
        List<Book> book = new ArrayList<>();
        Book books = new Book();
        books.setId(1);
        books.setTitle("Romeo");
        books.setAuthor("shakesphere");
		books.setCategory("drama");
		books.setPrice(1000);
		books.setPublisher("SVNC");
		books.setDate("1990-02-26");
        book.add(books);
        books.setContent("Story");
        when(authorRepository.findAll()).thenReturn(book);
        Iterable<Book> getbooks = authorservice.getBooks();
        assertEquals(book, getbooks);
    }
    
    @Test
     void testGetBookById()  throws Exception{
        Optional<Book> books = Optional.of(new Book());
        Mockito.when(authorRepository.findById(1)).thenReturn(books);
        Optional<Book> bookbyid = authorservice.findBookById(1);
        assertEquals(books,bookbyid);
    }
    
    @Test
     void testGetAuthors() throws Exception{
    	List<Author> author = new ArrayList<>();
    	Author authors = new Author();
    	authors.setId(1);
    	authors.setAge(30);
    	authors.setEmail("abc@gmail.com");
    	authors.setName("Ramu");
    	author.add(authors);
    	when(repository.findAll()).thenReturn(author);
        Iterable<Author> getauthors = authorservice.getAuthors();
        assertEquals(author, getauthors);
    }  
    
    
    @Test
	void testSaveAuthor() {
    	Author authors = new Author();
    	authors.setId(1);
    	authors.setAge(30);
    	authors.setEmail("abc@gmail.com");
    	authors.setName("Ramu");
		when(repository.save(authors)).thenReturn(authors);//mock
		authorservice.saveAuthor(authors);
		assertEquals(1,	authors.getId());
	}
    
    @Test
    void testRegister() {
    	User user = new User();
		user.setId(1);
		user.setMobilenumber(123456);
		user.setPassword("susi");
		user.setUsername("susi");
		user.setEmail("susi");
		when(loginrepository.save(user)).thenReturn(user);//mock
		authorservice.register(user);
		assertEquals(1,	user.getId());
    }
    
	/* @Test
     void deleteBook()  throws Exception{
    	
		Book books = new Book();
		books.setId(1);
		books.setTitle("Romeo and juliet");
		books.setAuthor("shakesphere");
		books.setCategory("drama");
		books.setPrice(1000);
		books.setPublisher("SVNC");
		books.setDate("1990-02-26");
		books.setContent("Story");
		authorservice.deleteBook(1);
    }  */
	
	/* @Test
	void testuserLogin() {
		User user = new User();
		user.setId(1);
		user.setMobilenumber(123456);
		user.setPassword("susi");
		user.setUsername("susi");
		user.setEmail("susi");
		when(loginrepository.findByUsername("admin")).thenReturn(user);

	}  */

}