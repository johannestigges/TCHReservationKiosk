package de.tigges.TCHReservationKiosk;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class TCHReservationKioskController {
//	private static final String URL = "https://tchserver.spdns.de:8443/reservation/getOccupations/1/0";
	private static final String URL = "http://localhost:8080/reservation/getOccupations/1/0";
	
	@GetMapping("/add")
	public String index(Model model) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Occupation>> entity = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Occupation>>() {});
		List<Occupation> occupations = entity.getBody();
		occupations.forEach(o -> System.out.println(o));
		return "addReservation";
	}
}
