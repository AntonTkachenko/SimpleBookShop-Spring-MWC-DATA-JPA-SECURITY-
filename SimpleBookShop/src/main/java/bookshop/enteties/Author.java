package bookshop.enteties;

import java.io.Serializable;
import java.util.Collections;
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
@Table(name = "authors")
public class Author implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5933632087164129911L;

	private Integer id;

	private String firstName;

	private String secondName;

	private Set<Book> books = new HashSet<>(10);

	public Author() {
	}

	public Author(String firstName, String secondName) {
		this.firstName = firstName;
		this.secondName = secondName;
	}

	public Author(Integer id, String firstName, String secondName) {
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "autor_id")
	public Integer getId() {
		return id;
	}

	@Column(name = "author_first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}

	@Column(name = "author_second_name", nullable = false)
	public String getSecondName() {
		return secondName;
	}

	@ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
	public Set<Book> getBooks() {
		return books;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((secondName == null) ? 0 : secondName.hashCode());
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
		Author other = (Author) obj;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (books.size() != other.books.size())
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (secondName == null) {
			if (other.secondName != null)
				return false;
		} else if (!secondName.equals(other.secondName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Book book : books) {
			builder.append(book.getTitle() + " ");
		}
		return "Author [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", books=" + builder
				+ "]";
	}

}
