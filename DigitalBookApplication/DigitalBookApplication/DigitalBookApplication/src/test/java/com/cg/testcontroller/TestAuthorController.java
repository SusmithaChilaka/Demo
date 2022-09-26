package com.cg.testcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import com.cg.DTO.PurchaseBookDTO;
import com.cg.controller.AuthorController;
import com.cg.model.Author;
import com.cg.model.Book;
import com.cg.service.impl.AuthorServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
@ExtendWith(MockitoExtension.class)
 class TestAuthorController {
	
	@Autowired
    private MockMvc mockMvc;
	@MockBean
	AuthorServiceImpl service;
	@InjectMocks
	AuthorController controller;
	
	Book getBook() {
		Book book = new Book();
		book.setId(1);
		book.setTitle("");
		book.setCategory(null);
		book.setPrice(0);
		book.setAuthor("");
		book.setPublisher("");
    	book.setDate(null );
		book.setContent("");
		return book;
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
		books.setDate("8/17/1998");
		books.setContent("Story");
        book.add(books);
        Mockito.when(service.getBooks()).thenReturn(book);
        mockMvc.perform(get("/books")).andExpect(status().isOk());
        Iterable<Book> getbooks = controller.getBooks();
        assertEquals(book, getbooks);
        
    }
    
    @Test
     void testGetBookById()  throws Exception{
    	
        Optional<Book> books = Optional.of(new Book());
        Mockito.when(service.findBookById(1)).thenReturn(books);
        mockMvc.perform(get("/books")).andExpect(status().isOk());
        Optional<Book> bookbyid = controller.getBookById(1);
        assertEquals(books,bookbyid);
    } 
    
    @Test
    void testGetBookByTitle()  throws Exception{
   	 
    	String title="Fun Slice";
       Optional<Iterable<Book>> books = Optional.empty();
       Mockito.when(service.getBookByTitle(title)).thenReturn(books);
       mockMvc.perform(get("/books")).andExpect(status().isOk());
       Optional<Iterable<Book>> bookbyid = controller.getBookByTitle(title);
       assertEquals(books,bookbyid);
   }
	 @Test
	void testGetBook1() {
		Optional<Book> book = Optional.of(getBook());
		Integer id=1;
		Mockito.when(service.findBookById(1)).thenReturn(book);
		Optional<Book> actual= controller.getBookById(id);
		assertEquals(book, actual);
	} 

	@Test
	void testSaveBook() {
		Book books = new Book();
		books.setId(1);
		books.setTitle("romeo and Juliet");
		books.setAuthor("shakesphere");
		books.setCategory("drama");
		books.setPrice(1000);
		books.setPublisher("SVNC");
		books.setDate("1990-02-26");
		books.setContent("Story");
		Mockito.when(service.save(books)).thenReturn(books);// mocking
		Integer savedbookId = controller.saveBook(books);
		assertEquals(1, savedbookId);
	}
	
	@Test
     void testGetAuthors() throws Exception {
        List<Author> author = new ArrayList<>();
        Author authors = new Author();
        authors.setId(1);
        authors.setName("Ramu");
        authors.setEmail("abc@gmail.com");
        authors.setAge(30);
        author.add(authors);
        
        Mockito.when(service.getAuthors()).thenReturn(author);
        mockMvc.perform(get("/books/authors")).andExpect(status().isOk());
        Iterable<Author> getauthors = controller.getAuthors();
        assertEquals(author, getauthors);
        
    }
	
	@Test
	void testSaveAuthor() {
		 Author authors = new Author();
	        authors.setId(1);
	        authors.setName("Ramu");
	        authors.setEmail("abc@gmail.com");
	        authors.setAge(30);
		Mockito.when(service.saveAuthor(authors)).thenReturn(authors);// mocking
		Integer savedauthorId = controller.saveAuthor(authors);
		assertEquals(1, savedauthorId);
	}
	
	
	@Test
     void deleteBook()  throws Exception{
    	
		int id = 1;
        service.deleteBook(id);
        ResultActions response = mockMvc.perform(delete("/books/{id}",id)).andExpect(status().isOk());
        response.andExpect(status().isOk())
                .andDo(print());
    }
	
	
   /*  @Test
    public void testUpdateBook() throws Exception{

        String URI = "/books/books/{Id}";
        Book books = new Book();
		//books.setId(187);
		books.setTitle("romeo");
		books.setAuthor("shakesphere");
		books.setCategory("drama");
		books.setPrice(1000);
		books.setPublisher("SVNC");
		books.setDate("1990-02-26");
		books.setContent("Story");
        String jsonInput = this.converttoJson(books);

        service.updateBook(books.getId(),books);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI, 187).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
    }  */
	
	  @Test
	void testUpdateBook() throws Exception {
		//int id =1;
		Book books = new Book();
		//books.setId(1);
		books.setTitle("romeot");
		books.setAuthor("shakesphere");
		books.setCategory("drama");
		books.setPrice(1000);
		books.setPublisher("SVNC");
		books.setDate("1990-02-26");
		books.setContent("Story");
		controller.updateBook(187, books);
		/* service.updateBook(187, books);
		ResultActions response = mockMvc.perform(put("/books/books/{id}",187)).andExpect(status().isOk());
        response.andExpect(status().isOk())
        .andDo(print()); */
	}   
	 
	
    @SuppressWarnings("unused")
	private String converttoJson(Object books) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(books);
    }
    
    
    @Test
    void purachaseBook() {
        PurchaseBookDTO purchaseBookDTO = new PurchaseBookDTO();
        purchaseBookDTO.setBookId(1);
        purchaseBookDTO.setUseremail("sai@gmail.com");
        purchaseBookDTO.setUsername("sai");
        String response = "success";
        Mockito.when(service.purachaseBook(purchaseBookDTO)).thenReturn(response);
        String savebookId = controller.purachaseBook(purchaseBookDTO);
        assertEquals(response, savebookId);
   }
}