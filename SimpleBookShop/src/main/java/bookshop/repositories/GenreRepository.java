package bookshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bookshop.enteties.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

	public Genre findByName(String name);

}
