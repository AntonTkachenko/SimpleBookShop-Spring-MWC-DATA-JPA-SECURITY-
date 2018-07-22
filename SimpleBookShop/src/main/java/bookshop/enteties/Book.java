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
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2831849965480688315L;

	private Integer id;

	private String title;

	private String description;

	private Float price;

	private Order order;

	private Set<Author> authors = new HashSet<>();

	private Set<Genre> genres = new HashSet<>();

	public Book() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	public Integer getId() {
		return id;
	}

	@Column(name = "book_title", nullable = false)
	public String getTitle() {
		return title;
	}

	@Column(name = "book_description", nullable = false)
	public String getDescription() {
		return description;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Book_Author", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
			@JoinColumn(name = "author_id") })
	public Set<Author> getAuthors() {
		return authors;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Book_Genre", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
			@JoinColumn(name = "genre_id") })
	public Set<Genre> getGenres() {
		return genres;
	}

	@Column(name = "price", nullable = false)
	public Float getPrice() {
		return price;
	}

	@OneToOne(mappedBy = "book")
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (genres == null) {
			if (other.genres != null)
				return false;
		} else if (!genres.equals(other.genres))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builderAuthor = new StringBuilder();
		StringBuilder builderGenders = new StringBuilder();
		for (Author author : authors) {
			builderAuthor.append(author.getFirstName() + " " + author.getSecondName() + " ");
		}
		for (Genre genre : genres) {
			builderGenders.append(genre.getName() + " ");
		}
		return "Book [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", authors=" + builderAuthor + ", genres=" + builderGenders + "]";
	}

}
