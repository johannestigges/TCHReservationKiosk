package de.tigges.TCHReservationKiosk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class TCHReservationKioskController {
	private static final String BASE_URL = "https://tchserver.spdns.de:8443";
//	private static final String BASE_URL = "http://localhost:8080";

	private static final String GET_OCCUPATION_URL = BASE_URL + "/reservation/getOccupations/1/0";
	private static final String POST_LOGIN_URL = BASE_URL + "/login";
	private static final String GET_USER_URL = BASE_URL + "/user/me";

	@GetMapping("/add")
	public String index(Model model) {
		System.out.println("start add Reservation!!!");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Occupation>> entity = restTemplate.exchange(GET_OCCUPATION_URL, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Occupation>>() {
				});
		printResponse(entity);
		HttpHeaders headers = entity.getHeaders();
		List<Occupation> occupations = entity.getBody();
		occupations.forEach(o -> System.out.println(o));

		Map<String, String> body = new HashMap<>();
//		body.put("username", "kiosk");
//		body.put("password", "abbm763z");
		body.put("username", "user");
		body.put("password", "mypass0");
		body.put("submit", "Login");
		HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);
		ResponseEntity<String> result = restTemplate.postForEntity(POST_LOGIN_URL, request, String.class);
		printResponse(result);

		ResponseEntity<String> user = restTemplate.getForEntity(GET_USER_URL, String.class);
		printResponse(user);
		return "addReservation";
	}

	private void printResponse(ResponseEntity<?> response) {
		System.out.println("Response status " + response.getStatusCodeValue());
		response.getHeaders().forEach(
				(k, v) -> System.out.println("Header " + k + " = " + v.stream().collect(Collectors.joining())));
		if (response.getBody() != null) {
			System.out.println("Body: " + response.getBody().toString());
		}
	}
}
