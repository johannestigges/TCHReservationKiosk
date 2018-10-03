package de.tigges.TCHReservationKiosk;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TCHReservationKioskController {

	@GetMapping("/add")
	public String index(Model model) {
		return "overview";
	}
}
