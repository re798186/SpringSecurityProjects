package in.reethu.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankController {
	
	@GetMapping("/") 
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/offers") 
	public String showOffers() {
		return "offers";
	}
	
	@GetMapping("/balance") 
	public String showBalance() {
		return "show_balance";
	}
	
	@GetMapping("/loanApprove") 
	public String showLoanApprove() {
		return "loan";
	}
	@GetMapping("/denied") 
	public String showAccessDenied() {
		return "access_denied";
	}

}
