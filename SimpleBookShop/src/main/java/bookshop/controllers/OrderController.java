package bookshop.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bookshop.enteties.Order;
import bookshop.repositories.OrderRepository;
import bookshop.servises.interfases.BookService;

@Controller
@Scope("request")
@RequestMapping("order")
public class OrderController {

	private OrderRepository orderRepository;
	private BookService bookService;

	@Autowired
	public OrderController(OrderRepository orderRepository, BookService bookService) {
		this.orderRepository = orderRepository;
		this.bookService = bookService;
	}

	@RequestMapping(value = "/{bookId}/new")
	public ModelAndView createOrder(ModelMap model, @PathVariable(name = "bookId") Integer bookId) {
		model.addAttribute("book", bookService.getById(bookId));
		return new ModelAndView("order");
	}

	@RequestMapping(value = "/saveOrder", method = RequestMethod.POST, params = { "bookId", "firstName", "secondName",
			"address", "countBooks" })
	public ModelAndView saveOrder(ModelMap model, Integer bookId, String firstName, String secondName, String address,
			Integer countBooks) {
		Order order = new Order();
		order.setFirstName(firstName);
		order.setSecondName(secondName);
		order.setAddress(address);
		order.setBookCount(countBooks);
		order.setBook(bookService.getById(bookId));
		order.setDateTime(LocalDateTime.now());
		orderRepository.save(order);
		return new ModelAndView("redirect:/");
	}

}
