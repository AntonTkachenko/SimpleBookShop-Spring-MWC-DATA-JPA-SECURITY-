package bookshop.main_test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import bookshop.configuration.DatabaseConfig;
import bookshop.configuration.WebConfig;
import bookshop.enteties.Author;
import bookshop.enteties.Book;
import bookshop.enteties.Genre;
import bookshop.repositories.AuthorRepository;
import bookshop.servises.interfases.AuthorService;
import bookshop.servises.interfases.BookService;
import bookshop.servises.interfases.GenreService;
import bookshop.util.factory.AuthorGenerator;
import bookshop.util.factory.Generator;
import bookshop.util.request.ServiceRequest;

/**
 * 
 * @author antonTkachenko
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { DatabaseConfig.class,
		WebConfig.class }, loader = AnnotationConfigWebContextLoader.class)
public class TaskProventusApplicationTests {

	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;
	@Autowired
	private GenreService genreService;

	@Autowired
	private AuthorRepository authorRepository;

	private final String DESCRIPTION = "It's a good book, and you should buy it!";
	private final String[] GENRES = { "Autobiographical novel", "Dystopia", "Business Books", "Biography",
			"The militants", "Western", "Heroic fantasy", "Urban fantasy", "Graphic book", "Detectives",
			"Children's literature", "Documental literature", "Home", "Family", "Drama", "Foreign literature", "Art",
			"Historical drama", "The historical detective", "Historical novel", "Classics", "A motivational book",
			"Books in foreign languages", "Psychology books", "Computer Literature", "Beauty and health ",
			"Legends and myths", "The literature of postmodernism", "Romance novels", "Magical realism", "Memoirs",
			"Mystic / Horror", "Science fiction", "Popular science literature", "Novella", "Non-fiction",
			"Action-packed novel", "Periodicals", "The story", "Poetry, Drama", "The poem", "Adventure novel",
			"The parable", "Prose", "Psychological detective", "Publicism", "The play", "The story", "Religion",
			"The novel", "Fairy tale", "Reference books", "Steampunk (steampunk)", "Technical literature", "Thriller",
			"Utopia", "Educational literature", "Fantastic", "Fantastic thriller", "Philosophical literature",
			"Fantasy", "Esoterics", "Essays", "Humor" };
	private final String[] BOOK_TITLES = { "Game of the throns", "Absalom", "A che punto è la notte",
			"After Many a Summer Dies the Swan", "Ah, Wilderness", "Alone on a Wide", "An Acceptable", "Antic Hay",
			"An Evil Cradling", "Arms and the Man", "As I Lay Dying", "A Time to Kill", "Behold the Man",
			"Beneath the Bleeding", "Книга джунглей" };
	private Random random = new Random();
	Generator<Author> authorGenerator = new AuthorGenerator();

	@Before
	public void init() {
		for (int i = 0; i < GENRES.length; i++) {
			ServiceRequest request = genreService.save(new Genre(GENRES[i]));
			if (!request.getResult()) {
				break;
			}
		}
	}

	@Test
	public void testGenderService() {
		Genre genre = genreService.getByName(this.GENRES[random.nextInt(this.GENRES.length - 1)]);
		assertNotNull(genre);
	}

	@Test
	public void testBookServiceAddDelete() {
		Book book = new Book();
		for (int i = 0; i < 3; i++) {
			book.getAuthors().add(authorRepository.save(authorGenerator.generate()));
			Genre genre = genreService.getByName(this.GENRES[random.nextInt(this.GENRES.length - 1)]);
			book.getGenres().add(genre);
		}
		book.setPrice(10F);
		book.setDescription("Best book in the world!");
		book.setTitle("Simple book");
		ServiceRequest request = bookService.saveBook(book);
		assertTrue(request.getResult());
		assertTrue(request.getMessage().equals("Saved successfully!"));
		for (Book bookq : bookService.getByTitle("Simple book")) {
			bookService.deleteBookById(bookq.getId());
		}
		assertTrue(bookService.getByTitle("Simple book").size() == 0);
		/*for (int i = 0; i < BOOK_TITLES.length; i++) {
			book = new Book();
			book.setDescription(DESCRIPTION);
			book.setTitle(BOOK_TITLES[i]);
			book.setPrice((float) random.nextInt(100));
			for (int j = 0; j < 3; j++) {
				book.getAuthors().add(authorRepository.save(authorGenerator.generate()));
				Genre gender = genreService.getByName(this.GENRES[random.nextInt(this.GENRES.length - 1)]);
				book.getGenres().add(gender);
			}
			bookService.saveBook(book);
		}*/
	}

}
