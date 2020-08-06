package com.tts.BookStore.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.tts.BookStore.Services.StripeService;
import com.tts.BookStore.dtos.StripeChargeRequestDTO;


@Controller
public class StripeChargeController {

    @Autowired
    private StripeService paymentsService;

    @PostMapping("/result")
    public String charge(StripeChargeRequestDTO chargeRequest, Model model) throws StripeException {
        chargeRequest.setDescription("Example charge");
        chargeRequest.setCurrency(StripeChargeRequestDTO.Currency.USD);

        Charge charge = paymentsService.charge(chargeRequest);
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        return "result";
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "result";
    }
    
//    @GetMapping("/charge")
//    public String showResult() {
//    	return "result";
//    }

}
