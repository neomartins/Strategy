package com.strategy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.strategy.model.Quadrado;
import com.strategy.service.QuantidadePessoaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Created by Gustavo Martins
 */
@RestController
@RequestMapping("pessoa")
public class QuantidadePessoaController {

	private final QuantidadePessoaService pessoaService;

	@Autowired
	public QuantidadePessoaController(final QuantidadePessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	/**
	 * 
	 * @return quantidade de pessoas que o salão suporta
	 */

	@ApiOperation(notes = "Quantidade de Pessoas", value = "Quantidade de Pessoas", nickname = "todasPessoas")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = List.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Double getPessoasSalao(@RequestParam("ladoSalao1") double lado1,
			@RequestParam("ladoSalao2") double lado2, @RequestParam("ladoMesa") double ladoMesa) {

		return pessoaService.quantidadePessoaEmMesa(lado1, lado2, new Quadrado(ladoMesa));
	}

}
