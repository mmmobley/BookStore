package com.tts.BookStore.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tts.BookStore.dtos.StripeChargeRequestDTO;


@Controller
public class StripeCheckoutController {
	
    private static final String STRIPE_PUBLISHABLE_KEY = "";

    @RequestMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("amount", 16 * 100); // amount in cents
        model.addAttribute("stripePublicKey", STRIPE_PUBLISHABLE_KEY);
        model.addAttribute("currency", StripeChargeRequestDTO.Currency.USD);
        return "checkout";
    }

}
