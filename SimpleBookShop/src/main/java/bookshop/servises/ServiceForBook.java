package bookshop.servises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import bookshop.enteties.Author;
import bookshop.enteties.Book;
import bookshop.enteties.Genre;
import bookshop.repositories.AuthorRepository;
import bookshop.repositories.BookRepository;
import bookshop.repositories.GenreRepository;
import bookshop.servises.interfases.BookService;
import bookshop.util.request.ServiceRequest;

@Service
public class ServiceForBook implements BookService {

	private BookRepository bookRepository;
	private AuthorRepository authorRepository;
	private GenreRepository genreRepository;

	@Autowired
	public ServiceForBook(BookRepository bookRepository, AuthorRepository authorRepository,
			GenreRepository genreRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
		this.genreRepository = genreRepository;
	}

	@Override
	public Book getById(Integer id) {
		return bookRepository.getOne(id);
	}

	@Override
	public List<Book> getByTitle(String... titles) {
		List<Book> books = new ArrayList();
		for (String title : titles) {
			books.addAll(bookRepository.findByTitle(title));
		}
		return books;
	}

	@Override
	public List<Book> getAll() {
		return bookRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public ServiceRequest saveBook(String bookTitle, String bookDescription, List<Integer> authorsId,
			List<Integer> gendersId, Float bookPrice) {
		Book book = new Book();
		book.setTitle(bookTitle);
		book.setDescription(bookDescription);
		book.setPrice(bookPrice);
		book.setAuthors(new HashSet<>(authorRepository.findAllById(authorsId)));
		book.setGenres(new HashSet<>(genreRepository.findAllById(gendersId)));
		book = bookRepository.save(book);
		if (book != null) {
			return new ServiceRequest(true, "Saved successfully!");
		}
		return new ServiceRequest(false, "Dont saved!");
	}

	@Override
	public ServiceRequest deleteBookById(Integer id) {
		Optional<Book> optional = bookRepository.findById(id);
		if (optional.isPresent()) {
			bookRepository.deleteById(id);
			return new ServiceRequest(true, "Deleted successfully!");
		}
		return new ServiceRequest(false, "Dont deleted.Book don`t exists!");
	}

	@Override
	public ServiceRequest saveBook(Book book) {
		if (bookRepository.save(book) != null) {
			return new ServiceRequest(true, "Saved successfully!");
		}
		return new ServiceRequest(false, "Dont saved!");
	}

	@Override
	public ServiceRequest updateBook(Book book, Integer[] authorsId, Integer[] gendersId) {
		book.setAuthors(new HashSet<>(authorRepository.findAllById(Arrays.asList(authorsId))));
		book.setGenres(new HashSet<>(genreRepository.findAllById(Arrays.asList(gendersId))));
		if (bookRepository.save(book) != null) {
			return new ServiceRequest(true, "Updated successfully!");
		}
		return new ServiceRequest(false, "Dont updated!");
	}

	@Override
	public List<Book> getByGenresAndAuthor(Integer[] authorsId, Integer... genresId) {
		List<Author> authors = null;
		List<Genre> genres = null;
		if (authorsId != null & genresId != null) {
			authors = authorRepository.findAllById(Arrays.asList(authorsId));
			genres = genreRepository.findAllById(Arrays.asList(genresId));
			return bookRepository.findByAuthorsAndGenres(authors, genres);
		} else if (authorsId == null & genresId != null) {
			genres = genreRepository.findAllById(Arrays.asList(genresId));
			return bookRepository.findByGenres(genres);
		} else if (authorsId != null & genresId == null) {
			authors = authorRepository.findAllById(Arrays.asList(authorsId));
			return bookRepository.findByAuthors(authors);
		} else {
			return bookRepository.findAll();
		}
	}

}