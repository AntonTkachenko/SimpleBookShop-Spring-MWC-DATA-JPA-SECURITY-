package bookshop.servises;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import bookshop.enteties.Author;
import bookshop.repositories.AuthorRepository;
import bookshop.servises.interfases.AuthorService;
import bookshop.util.request.ServiceRequest;

@Service
public class ServiceForAuthor implements AuthorService {

	private AuthorRepository authorRepository;

	@Autowired
	public ServiceForAuthor(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Override
	public List<Author> getAll() {
		return authorRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Author getById(Integer id) {
		return authorRepository.getOne(id);
	}

	@Override
	public ServiceRequest saveAuthor(Author autor) {
		if (authorRepository.save(autor) != null) {
			return new ServiceRequest(true, "Saved successfully!");
		}
		return new ServiceRequest(false, "Dont saved!");
	}

	@Override
	public Integer authorSize() {
		return (int) authorRepository.count();
	}

}
