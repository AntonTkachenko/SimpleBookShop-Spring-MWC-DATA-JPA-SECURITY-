package bookshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bookshop.servises.interfases.AuthorService;
import bookshop.servises.interfases.BookService;
import bookshop.servises.interfases.GenreService;

@Controller
@Scope("request")
public class HomeController {

	private BookService bookService;
	private GenreService genreService;
	private AuthorService authorService;

	@Autowired
	public HomeController(BookService bookService, GenreService genreService, AuthorService authorService) {
		this.bookService = bookService;
		this.genreService = genreService;
		this.authorService = authorService;
	}

	@RequestMapping(value = "/")
	public ModelAndView home(ModelMap model) {
		model.addAttribute("books", bookService.getAll());
		model.addAttribute("authors", authorService.getAll());
		model.addAttribute("genres", genreService.getAll());
		return new ModelAndView("home", model);
	}

	@RequestMapping(value = "/filter", method = RequestMethod.POST)
	public ModelAndView filter(ModelMap model, @RequestParam(name = "authorsId", required = false) Integer[] authorsId,
			@RequestParam(name = "genresId", required = false) Integer[] genresId) {
		model.addAttribute("books", bookService.getByGenresAndAuthor(authorsId, genresId));
		model.addAttribute("authors", authorService.getAll());
		model.addAttribute("genres", genreService.getAll());
		return new ModelAndView("home", model);
	}

}
