package bookshop.servises.interfases;

/**
 * 
 * @author antonTkachenko
 *
 */

import java.util.List;

import bookshop.enteties.Genre;
import bookshop.util.request.ServiceRequest;

public interface GenreService {

	public List<Genre> getAll();

	public Genre getById(Integer id);

	public Genre getByName(String name);

	public ServiceRequest save(Genre genre);
}
