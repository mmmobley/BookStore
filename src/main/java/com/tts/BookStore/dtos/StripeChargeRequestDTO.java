package com.tts.BookStore.dtos;

import lombok.Data;

@Data
public class StripeChargeRequestDTO {
    public enum Currency {
         USD;
    }
    private String description;
    private int amount;
    private Currency currency;
    private String stripeEmail;
    private String stripeToken;
	
    public Object getAmount() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getCurrency() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getStripeToken() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDescription(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setCurrency(Currency usd) {
		// TODO Auto-generated method stub
		
	}

	public String getStripeEmail() {
		return stripeEmail;
	}

	public void setStripeEmail(String stripeEmail) {
		this.stripeEmail = stripeEmail;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setStripeToken(String stripeToken) {
		this.stripeToken = stripeToken;
	}

	public StripeChargeRequestDTO(String description, int amount, Currency currency, String stripeEmail,
			String stripeToken) {
		super();
		this.description = description;
		this.amount = amount;
		this.currency = currency;
		this.stripeEmail = stripeEmail;
		this.stripeToken = stripeToken;
	}
	
	public StripeChargeRequestDTO() {}
}
