package bookshop.enteties;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
@SuppressWarnings("unchecked")
public class Genre implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5076809746473316696L;

	private Integer id;

	private String name;

	private Set<Book> books = new HashSet<>();

	public Genre() {
	}

	public Genre(String name) {
		this.name = name;
	}

	public Genre(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "genre_id")
	public Integer getId() {
		return id;
	}

	@Column(name = "genre_name", nullable = false, unique = true, length = 55)
	public String getName() {
		return name;
	}

	@ManyToMany(mappedBy = "genres", fetch = FetchType.EAGER)
	public Set<Book> getBooks() {
		return books;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genre other = (Genre) obj;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (books.size() != other.books.size())
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Book book : books) {
			builder.append(book.getTitle() + " ");
		}
		return "Genre [id=" + id + ", name=" + name + ", books=" + builder + "]";
	}

}
