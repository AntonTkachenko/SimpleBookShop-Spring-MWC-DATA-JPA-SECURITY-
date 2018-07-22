package bookshop.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import bookshop.enteties.Author;
import bookshop.enteties.Book;
import bookshop.enteties.Genre;

/**
 * 
 * @author antonTkachenko
 *
 */
public interface BookRepository extends JpaRepository<Book, Integer> {

	public List<Book> findByTitle(String title);

	public List<Book> findByAuthors(List<Author> authors);

	public List<Book> findByGenres(List<Genre> genre);

	public List<Book> findByAuthorsAndGenres(List<Author> authors, List<Genre> genres);

}
