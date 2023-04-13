package me.dio.academia.digital.controller;

import jakarta.validation.Valid;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;


    @PostMapping //para enviar dados
    public Aluno create(@Valid @RequestBody AlunoForm form){//passando no corpo da requisição o formulário do aluno
        return service.create(form);
    }
        //notacao @Valid valida os dados no formulario para serem salvos de acordo com o padrão de validação definido

    @GetMapping("avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisica(@PathVariable Long id){
        return service.getAllAvaliacaoFisicaId(id);

    }

    @GetMapping // para receber dados
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento){
        return service.getAll(dataDeNascimento);
    }




}
