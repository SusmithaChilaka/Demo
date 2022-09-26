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
import com.cg.repository.AuthorListRepository;
import com.cg.repository.AuthorRepository;
import com.cg.repository.LoginRepository;
import com.cg.repository.PurchaseBookRepository;
import com.cg.service.impl.AuthorServiceImpl;
import com.cg.services.AuthorService;
import com.cg.DTO.PurchaseBookDTO;
import com.cg.model.Author;
import com.cg.model.Book;
import com.cg.model.User;

@ExtendWith(MockitoExtension.class)
class TestAuthorService {
	@InjectMocks
	AuthorServiceImpl authorserviceimpl;
	
	@Mock
	AuthorRepository authorRepository;
	@Mock
	AuthorListRepository repository;
	@Mock
	LoginRepository loginrepository;
	@Mock
	PurchaseBookRepository purchasebookrepository;
	@Mock
	AuthorService authorservice;
	
	
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
		authorserviceimpl.save(books);
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
        Iterable<Book> getbooks = authorserviceimpl.getBooks();
        assertEquals(book, getbooks);
    }
    
    @Test
     void testGetBookById()  throws Exception{
        Optional<Book> books = Optional.of(new Book());
        Mockito.when(authorRepository.findById(1)).thenReturn(books);
        Optional<Book> bookbyid = authorserviceimpl.findBookById(1);
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
        Iterable<Author> getauthors = authorserviceimpl.getAuthors();
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
		authorserviceimpl.saveAuthor(authors);
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
		authorserviceimpl.register(user);
		assertEquals(1,	user.getId());
    } 
    
	@Test
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
		authorserviceimpl.deleteBook(1);
    } 
	
	@Test
	void testGetUserByUsername() throws Exception{
		Optional<User> users = Optional.of(new User());
	        Mockito.when(loginrepository.findByUsername("admin")).thenReturn(users.get());
	        Optional<User> username = authorserviceimpl.getUserByUsername("admin");
	        assertEquals(users,username);
	}
	
	/* @Test
	void testuserLogin() {
		User user = new User();
		//user.setId(1);
		//user.setMobilenumber(123456);
		user.setPassword("admin");
		user.setUsername("admin");
		//user.setEmail("susi");
		authorserviceimpl.userlogin(user);
		
		User info = new User();
		user.setId(1);
		user.setMobilenumber(123456);
		info.setUsername("admin");
		info.setPassword("admin");
		info.setEmail("admin");  
	
		//Mockito.when(loginrepository.findById(id).thenReturn(user);
		//Mockito.when(loginrepository.matches(user.getPassword(),info.getPassword())).thenReturn(user);
		//implementation.verifyPassword(user, info);
		//Users users = implementation.login(info);
		//assertEquals(user, info);

	} */

	
	 /*  @Test
    public void testUpdateBook() throws Exception{

        Book books = new Book();
        books.setId(31);
		books.setTitle("One Indian Women");
		books.setAuthor("Chetan bhagat");
		books.setCategory("Fantasy");
		books.setPrice(860);
		books.setPublisher("CBP");
		books.setDate("2007-02-26 00:00:00.000000");
		books.setContent("Story of a women who wished to have a fantasy life");
		authorserviceimpl.updateBook(31, books);

		Mockito.when(authorRepository.findById(31).get()).thenReturn(books);
        books.setTitle("Romeo");
        Mockito.when(authorRepository.save(books)).thenReturn(books);
        System.out.println(books.getTitle());
        assertThat(authorserviceimpl.updateBook(31, books)).isEqualTo(books); 
    }  */
	  
	  @Test
	     void testGetUsers() throws Exception {
		  List<User> user = new ArrayList<>();
	        User users = new User();
			users.setId(1);
			users.setMobilenumber(123456);
			users.setPassword("susi");
			users.setUsername("susi");
			users.setEmail("susi");
	        user.add(users);
	        when(loginrepository.findAll()).thenReturn(user);
	        Iterable<User> getusers = authorserviceimpl.getUsers();
	        assertEquals(user, getusers);
	    }
	  
	  @Test
	    void purachaseBook() {
	        PurchaseBookDTO purchaseBook = new PurchaseBookDTO();
	        purchaseBook.setBookId(1);
	        purchaseBook.setUseremail("sai@gmail.com");
	        purchaseBook.setUsername("sai");        
	        Book bookEntity = new Book();
	        
	        String response="success";
	        Optional<Book> option=Optional.of(bookEntity);
	        Mockito.when(authorRepository.findById(purchaseBook.getBookId())).thenReturn(option);
	        String savebookId = authorserviceimpl.purachaseBook(purchaseBook);
	        assertEquals(response, savebookId);
	    }
	  
	  
	  @Test
	     void testdeleteUser()  throws Exception{
	        User users = new User();
			users.setId(1);
			users.setMobilenumber(123456);
			users.setPassword("susi");
			users.setUsername("susi");
			users.setEmail("susi");
			authorserviceimpl.deleteUser(1);
	    } 
	  
		 @SuppressWarnings("unused")
		@Test
		void testGetBookkByTitle() throws Exception{
			    Book books =  new Book();
		       // Mockito.when(authorRepository.findByTitle("Fun slice")).thenReturn(books);
		        Optional<Iterable<Book>> title = authorserviceimpl.getBookByTitle("Fun slice");
		       // assertEquals(books,title);
		} 
}