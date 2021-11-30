package com.higor.funcionario.controller;

import com.higor.funcionario.model.dto.FuncionarioDto;
import com.higor.funcionario.model.dto.RespostaDto;
import com.higor.funcionario.model.entity.Funcionario;
import com.higor.funcionario.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = FuncionarioController.PATH)
public class FuncionarioController {

    public final static String PATH = "${api.prefix}/funcionario";

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping(value = "/criar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public FuncionarioDto criarFuncionario(@RequestBody FuncionarioDto funcionarioDto) {

        final Funcionario funcionario = funcionarioService.criarFuncionario(funcionarioDto);
        funcionarioDto.setId(funcionario.getId());

        return funcionarioDto;
    }

    @PatchMapping(value = "/atualizar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Funcionario atualizarFuncionario(@PathVariable("id") Integer idFuncionario, @RequestBody FuncionarioDto funcionarioDto) {

        funcionarioService.atualizarFuncionario(idFuncionario, funcionarioDto);

        return funcionarioService.encontrarFuncionario(idFuncionario);
    }

    @DeleteMapping(value = "/remover/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity removerFuncionario(@PathVariable("id") Integer idFuncionario) {
        funcionarioService.removerFuncionario(idFuncionario);

        return ResponseEntity.ok(new RespostaDto("Funcionário removido com sucesso."));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Funcionario consultarFuncionario(@PathVariable("id") Integer idFuncionario) {
        return funcionarioService.encontrarFuncionario(idFuncionario);
    }

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Funcionario> listarFuncionarios() {
        return funcionarioService.listarFuncionarios();
    }

}
