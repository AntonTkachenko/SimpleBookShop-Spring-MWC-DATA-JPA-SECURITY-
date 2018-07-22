package bookshop.servises.interfases;

import java.util.List;

import bookshop.enteties.Author;
import bookshop.util.request.ServiceRequest;


/**
 * 
 * @author antonTkachenko
 *
 */

public interface AuthorService {

	public List<Author> getAll();

	public Author getById(Integer id);

	public ServiceRequest saveAuthor(Author autor);

	public Integer authorSize();
}
