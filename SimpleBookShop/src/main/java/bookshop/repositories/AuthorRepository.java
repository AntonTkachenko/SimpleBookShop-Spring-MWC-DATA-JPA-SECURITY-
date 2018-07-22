package bookshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bookshop.enteties.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
	

}
