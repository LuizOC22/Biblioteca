package com.example.biblioteca;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeLeitor; // quem pego o bagui
    private LocalDate dataEmprestimo; // quando pegou o bagui

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    public Emprestimo() {}

    public Emprestimo(String nomeLeitor, Livro livro) {
        this.nomeLeitor = nomeLeitor;
        this.livro = livro;
        this.dataEmprestimo = LocalDate.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNomeLeitor() { return nomeLeitor; }
    public void setNomeLeitor(String nomeLeitor) { this.nomeLeitor = nomeLeitor; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public void setDataEmprestimo(LocalDate dataEmprestimo) { this.dataEmprestimo = dataEmprestimo; }
    public Livro getLivro() { return livro; }
    public void setLivro(Livro livro) { this.livro = livro; }

}
