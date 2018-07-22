package bookshop.servises.interfases;

import java.util.List;

import bookshop.enteties.Author;
import bookshop.enteties.Book;
import bookshop.enteties.Genre;
import bookshop.util.request.ServiceRequest;

/**
 * 
 * @author antonTkachenko
 *
 */
public interface BookService {

	public Book getById(Integer id);

	public List<Book> getAll();

	public List<Book> getByTitle(String... titles);

	public List<Book> getByGenresAndAuthor(Integer[] authors, Integer... genres);

	public ServiceRequest saveBook(String bookTitle, String bookDescription, List<Integer> authorsId,
			List<Integer> genresId, Float bookPrice);

	public ServiceRequest deleteBookById(Integer id);

	public ServiceRequest saveBook(Book book);

	public ServiceRequest updateBook(Book book, Integer[] authorsId, Integer[] genresId);
}
