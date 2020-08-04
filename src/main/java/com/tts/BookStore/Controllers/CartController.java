package com.tts.BookStore.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tts.BookStore.Models.Book;
import com.tts.BookStore.Models.User;
import com.tts.BookStore.Services.BookService;
import com.tts.BookStore.Services.UserService;


@Controller
@ControllerAdvice
public class CartController {
  @Autowired
  BookService bookService;

  @Autowired
  UserService userService;

  @ModelAttribute("loggedInUser")
  public User loggedInUser() {
      return userService.getLoggedInUser();
  }

  @ModelAttribute("cart")
  public Map<Book, Integer> cart() {
      User user = loggedInUser();
      if(user == null) return null;
      System.out.println("Getting cart");
      return user.getCart();
  }

  /**
   * Puts an empty list in the model that thymeleaf can use to sum up the cart total.
   */
  @ModelAttribute("list")
  public List<Double> list() {
      return new ArrayList<>();
  }

  @GetMapping("/cart")
  public String showCart() {
      return "cart";
  }

  @PostMapping("/cart")
  public String addToCart(@RequestParam long id) {
      Book b = bookService.findById(id);
      setQuantity(b, cart().getOrDefault(b, 0) + 1);
      return "cart";
  }

  @PatchMapping("/cart")
  public String updateQuantities(@RequestParam long[] id, @RequestParam int[] quantity) {
      for(int i = 0; i < id.length; i++) {
          Book b = bookService.findById(id[i]);
          setQuantity(b, quantity[i]);
      }
      return "cart";
  }

  @DeleteMapping("/cart")
  public String removeFromCart(@RequestParam long id) {
      Book b = bookService.findById(id);
      setQuantity(b, 0);
      return "cart";
  }

  private void setQuantity(Book b, int quantity) {
      if(quantity > 0)
          cart().put(b, quantity);
      else
          cart().remove(b);

      userService.updateCart(cart());
  }
}
