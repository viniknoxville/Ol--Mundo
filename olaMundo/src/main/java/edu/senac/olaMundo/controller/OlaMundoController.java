package edu.senac.olaMundo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.senac.olaMundo.dto.OlaMundoRequest;
import edu.senac.olaMundo.dto.OlaMundoResponse;

@RestController
@RequestMapping(value = "/v1")


public class OlaMundoController {
	private static final String MENSAGEM = "Olá mundo, %s";

	@GetMapping(value = "/basico/get/olaMundo", produces = { "application/json" })
	public ResponseEntity<OlaMundoResponse> olaMundo(@RequestParam(value = "nome", required = false) String nome) {
		System.out.println("/basico/get/olaMundo");

		OlaMundoResponse olaMundoResponse = new OlaMundoResponse();
		olaMundoResponse.setMensagem(String.format(MENSAGEM, nome));

		return ResponseEntity.ok(olaMundoResponse);
	}

	@GetMapping(value = "/basico/get/olaMundo/{nome}", produces = { "application/json" })
	public ResponseEntity<OlaMundoResponse> olaMundoPath(@PathVariable("nome") String nome) {
		System.out.println("/basico/get/olaMundo/{nome}");

		OlaMundoResponse olaMundoResponse = new OlaMundoResponse();
		olaMundoResponse.setMensagem(String.format(MENSAGEM, nome));

		return ResponseEntity.ok(olaMundoResponse);
	}

	@PostMapping(value = "/basico/post/olaMundo", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<OlaMundoResponse> olaMundoPost(@RequestBody OlaMundoRequest body) {
		System.out.println("/basico/post/olaMundo");

		OlaMundoResponse olaMundoResponse = new OlaMundoResponse();
		olaMundoResponse.setMensagem(String.format(MENSAGEM, body.getNome()));

		return ResponseEntity.ok(olaMundoResponse);
	}

	@PutMapping(value = "/basico/put/olaMundo", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<OlaMundoResponse> olaMundoPut(@RequestBody OlaMundoRequest body) {
		System.out.println("/basico/put/olaMundo");

		OlaMundoResponse olaMundoResponse = new OlaMundoResponse();
		olaMundoResponse.setMensagem(String.format(MENSAGEM, body.getNome()));

		return ResponseEntity.ok(olaMundoResponse);
	}

	@DeleteMapping(value = "/basico/delete/olaMundo", produces = { "application/json" }, consumes = {"application/json" })
	public ResponseEntity<OlaMundoResponse> olaMundoDelete(@RequestBody OlaMundoRequest body) {
		System.out.println("/basico/delete/olaMundo");

		OlaMundoResponse olaMundoResponse = new OlaMundoResponse();
		olaMundoResponse.setMensagem(String.format(MENSAGEM, body.getNome()));

		return ResponseEntity.ok(olaMundoResponse);
	}
}
