package bookshop.enteties;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

	private static final long serialVersionUID = -6890690001711705077L;

	private Integer id;

	private String firstName;

	private String secondName;

	private String address;

	private Integer bookCount;

	private LocalDateTime dateTime;

	private Book book;

	public Order() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	public Integer getId() {
		return id;
	}

	@Column(name = "user_firstName")
	public String getFirstName() {
		return firstName;
	}

	@Column(name = "user_secondName")
	public String getSecondName() {
		return secondName;
	}

	@Column(name = "user_address")
	public String getAddress() {
		return address;
	}

	@Column(name = "book_count")
	public Integer getBookCount() {
		return bookCount;
	}

	@OneToOne
	@JoinColumn(name = "book_id")
	public Book getBook() {
		return book;
	}

	@Column(name = "order_date_time")
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public void setBook(Book book) {
		this.book = book;
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

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBookCount(Integer bookCount) {
		this.bookCount = bookCount;
	}

}
