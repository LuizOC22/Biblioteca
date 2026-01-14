package com.example.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public List <Livro> listarTodos(){
        return repository.findAll();
    }

    public Livro cadastrar(Livro livro){
        return repository.save(livro);
    }

    public String emprestar(Long id, String nomeLeitor){
        Livro livro = repository.findById(id).orElse(null);

        if (livro == null){
            return "Livro não encontrado!";
        }

        if (livro.getExemplares() <= 0){
            return "Sem estoque! todos os livros se foram.";
        }

        livro.setExemplares(livro.getExemplares() - 1);
        repository.save(livro);

        Emprestimo emprestimo = new Emprestimo(nomeLeitor, livro);

        System.out.println("--- DEBUG ---");
        System.out.println("Nome que chegou: " + nomeLeitor);
        System.out.println("Nome dentro do objeto: " + emprestimo.getNomeLeitor());
        System.out.println("Data dentro do objeto: " + emprestimo.getDataEmprestimo());
        System.out.println("-----------------");

        emprestimoRepository.save(emprestimo);

        return "Livros emprestados para: " + nomeLeitor + "com sucesso! restam: " + livro.getExemplares();
    }

    public String devolver(Long id){
        Livro livro = repository.findById(id).orElse(null);

        if (livro == null){
            return "Livro não encontrado!";
        }

        livro.setExemplares(livro.getExemplares() + 1);
        repository.save(livro);

        return "Livro devolvido! agora temos: " + livro.getExemplares();
    }
}
