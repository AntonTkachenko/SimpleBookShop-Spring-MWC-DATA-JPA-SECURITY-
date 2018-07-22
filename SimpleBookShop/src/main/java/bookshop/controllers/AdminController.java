package bookshop.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bookshop.enteties.Author;
import bookshop.enteties.Book;
import bookshop.enteties.Genre;
import bookshop.repositories.OrderRepository;
import bookshop.servises.interfases.AuthorService;
import bookshop.servises.interfases.BookService;
import bookshop.servises.interfases.GenreService;
import bookshop.util.request.ServiceRequest;

@Controller
@Scope("request")
@RequestMapping("admin")
public class AdminController {

	private BookService bookService;
	private GenreService genreService;
	private AuthorService authorService;
	private OrderRepository orderRepository;

	@Autowired
	public AdminController(BookService bookService, GenreService genreService, AuthorService authorService,
			OrderRepository orderRepository) {
		this.bookService = bookService;
		this.genreService = genreService;
		this.authorService = authorService;
		this.orderRepository = orderRepository;
	}

	@RequestMapping(value = "/panel")
	public String adminPanel() {
		return "adminPanel";
	}

	@RequestMapping(value = "/allBooks")
	public String allBooks(Model model, @RequestParam(name = "request", required = false) ServiceRequest request) {
		if (request != null) {
			model.addAttribute("request", request);
		}
		model.addAttribute("books", bookService.getAll());
		return "allBooks";
	}

	@RequestMapping(value = "/newBook")
	public ModelAndView newBook(ModelMap model) {
		model.addAttribute("genres", genreService.getAll());
		model.addAttribute("authors", authorService.getAll());
		return new ModelAndView("newBook", model);
	}

	@RequestMapping(value = "/saveBook", method = RequestMethod.POST, params = { "bookTitle", "bookDescription",
			"authorsId", "genresId", "bookPrice" })
	public ModelAndView saveBook(ModelMap model, String bookTitle, String bookDescription, Integer[] authorsId,
			Integer[] genresId, Float bookPrice) {
		System.err.println(bookTitle + " " + bookDescription + " ");
		model.addAttribute("request", bookService.saveBook(bookTitle, bookDescription, Arrays.asList(authorsId),
				Arrays.asList(genresId), bookPrice));
		return new ModelAndView("redirect:/admin/allBooks", model);
	}

	@RequestMapping(value = "/editBook", method = RequestMethod.POST, params = "bookId")
	public ModelAndView editBook(Integer bookId, ModelMap model) {
		model.addAttribute("genres", genreService.getAll());
		model.addAttribute("authors", authorService.getAll());
		model.addAttribute("book", bookService.getById(bookId));
		return new ModelAndView("editBook", model);
	}

	@RequestMapping(value = "/editBook/saveChanges", method = RequestMethod.POST, params = { "bookTitle",
			"bookDescription", "authorsId", "genresId", "bookPrice", "bookId" })
	public ModelAndView saveChngesBook(Integer bookId, ModelMap model, String bookTitle, String bookDescription,
			Integer[] authorsId, Integer[] genresId, Float bookPrice) {
		Book book = bookService.getById(bookId);
		book.setTitle(bookTitle);
		book.setDescription(bookDescription);
		book.setPrice(bookPrice);
		model.addAttribute("request", bookService.updateBook(book, authorsId, genresId));
		return new ModelAndView("redirect:/admin/allBooks", model);
	}

	@RequestMapping(value = "/deleteBook", method = RequestMethod.POST, params = "bookId")
	public ModelAndView deleteBook(Integer bookId, ModelMap model) {
		model.addAttribute("request", bookService.deleteBookById(bookId));
		return new ModelAndView("redirect:/admin/allBooks", model);
	}

	@RequestMapping(value = "/orders")
	public ModelAndView seeOrders(ModelMap model) {
		model.addAttribute("orders", orderRepository.findAll());
		return new ModelAndView("orders", model);
	}

	//
	@RequestMapping(value = "/newGender")
	public ModelAndView newGender(ModelMap model,
			@RequestParam(name = "request", required = false) ServiceRequest request) {
		if (request != null) {
			model.addAttribute("request", request);
		}
		model.addAttribute("gender", new Genre());
		return new ModelAndView("newGender", model);
	}

	@RequestMapping(value = "/saveGender", method = RequestMethod.POST)
	public ModelAndView saveGender(Genre genre, ModelMap model) {
		model.addAttribute("request", genreService.save(genre));
		return new ModelAndView("redirect:/admin/newGender", model);
	}

	@RequestMapping(value = "/newAuthor")
	public ModelAndView newAuthor(ModelMap model,
			@RequestParam(name = "request", required = false) ServiceRequest request) {
		if (request != null) {
			model.addAttribute("request", request);
		}
		model.addAttribute("gender", new Author());
		return new ModelAndView("newAuthor", model);
	}

	@RequestMapping(value = "/saveAuthor", method = RequestMethod.POST)
	public ModelAndView saveAuthor(Author author, ModelMap model) {
		model.addAttribute("request", authorService.saveAuthor(author));
		return new ModelAndView("redirect:/admin/newAuthor", model);
	}
}
