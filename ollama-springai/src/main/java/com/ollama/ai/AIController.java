package com.ollama.ai;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/ai")
public class AIController {

	
	
	private OllamaChatModel client;
	//private static final String PROMPT="WHAT IS java";
	public AIController(OllamaChatModel client) {
		this.client=client;
	}
	@GetMapping("/prompt")
//	public Flux<String> promptResponse(
//			@RequestParam("prompt") String prompt) {
//	//String response=client.call(PROMPT);
//		System.err.println("ccccccccccc");
//		Flux<String> response=client.stream(prompt);
//		return response;
//	}
	public ResponseEntity<String> promptResponse(
			@RequestParam("prompt") String prompt) {
//	//String response=client.call(PROMPT);
		System.err.println("ccccccccccc");
		String response=client.call(prompt);
		return ResponseEntity.ok(response);	
	}
}


