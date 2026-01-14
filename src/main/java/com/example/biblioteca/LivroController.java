package com.example.biblioteca;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping
    public List<Livro> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Livro cadastrar(@RequestBody Livro livro){
        return service.cadastrar(livro);
    }

    @PostMapping("/emprestar")
    public String emprestar(@RequestBody DadosEmprestimo dados) {
        return service.emprestar(dados.getLivroId(), dados.getNomeLeitor());
    }

    @PostMapping("/{id}/devolver")
    public String devolver(@PathVariable Long id) {
        return service.devolver(id);
    }
}
