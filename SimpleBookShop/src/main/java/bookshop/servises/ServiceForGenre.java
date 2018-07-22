package bookshop.servises;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import bookshop.enteties.Genre;
import bookshop.repositories.GenreRepository;
import bookshop.servises.interfases.GenreService;
import bookshop.util.request.ServiceRequest;

@Service
public class ServiceForGenre implements GenreService {

	private GenreRepository genreRepository;

	@Autowired
	public ServiceForGenre(GenreRepository genreRepository) {
		this.genreRepository = genreRepository;
	}

	@Override
	public List<Genre> getAll() {
		return genreRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Genre getById(Integer id) {
		return genreRepository.getOne(id);
	}

	@Override
	public Genre getByName(String name) {
		return genreRepository.findByName(name);
	}

	@Override
	public ServiceRequest save(Genre genre) {
		if (genreRepository.findByName(genre.getName()) != null) {
			return new ServiceRequest(false, "Gender with this name already exists!");
		}
		if (genreRepository.save(genre) != null) {
			return new ServiceRequest(true, "Saved successfully!");
		}
		return new ServiceRequest(false, "Dont saved!");
	}

}
