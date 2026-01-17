package com.example.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List <Livro> listarTodos(){
        return repository.findAll();
    }

    public Livro cadastrar(Livro livro){
        return repository.save(livro);
    }

    public String emprestar(Long id, Long usuarioId){
        Livro livro = repository.findById(id).orElse(null);

        if (livro == null)
            return "Livro não encontrado!";

        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        if (usuario == null)
            return "Usuario não encontrado! Cadastre-se primeiro";

        if (livro.getExemplares() <= 0)
            return "Sem estoque! todos os livros se foram.";


        livro.setExemplares(livro.getExemplares() - 1);
        repository.save(livro);

        Emprestimo emprestimo = new Emprestimo(usuario, livro);

        System.out.println("--- DEBUG ---");
        System.out.println("Nome que chegou: " + usuarioId);
        System.out.println("Nome dentro do objeto: " + emprestimo.getUsuario());
        System.out.println("Data dentro do objeto: " + emprestimo.getDataEmprestimo());
        System.out.println("-----------------");

        emprestimoRepository.save(emprestimo);

        return "Livros emprestados para: " + usuario.getNome() + "com sucesso! restam: " + livro.getExemplares();
    }

    public String devolver(Long id){
        Livro livro = repository.findById(id).orElse(null);

        if (livro == null){
            return "Livro não encontrado!";
        }

        Emprestimo emprestimo = emprestimoRepository.findByLivroAndDataDevolucaoIsNull(livro).orElse(null);

        if (emprestimo == null) {
            return "Erro: Não encontrei nenhum emprestimo aberto para esse livro! ";
        }

        livro.setExemplares(livro.getExemplares() + 1);
        repository.save(livro);

        emprestimo.setDataDevolucao(LocalDate.now());
        emprestimoRepository.save(emprestimo);

        return "Livro devolvido! agora temos: " + livro.getExemplares();
    }
}
