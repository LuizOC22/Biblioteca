package com.example.biblioteca;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity // Isso avisa ao Spring: "Crie uma tabela 'livro' no MySQL baseada nessa classe"
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório") // Não deixa salvar título vazio
    private String titulo;

    @NotBlank(message = "O autor é obrigatório")
    private String autor;

    @NotNull(message = "A quantidade de exemplares é obrigatória")
    @Min(value = 0, message = "A quantidade não pode ser negativa") // Regra de Ouro!
    private Integer exemplares;

    // --- Construtor Vazio (Obrigatório para o JPA) ---
    public Livro() {
    }

    // --- Construtor Cheio (Facilita para nós) ---
    public Livro(String titulo, String autor, Integer exemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.exemplares = exemplares;
    }

    // --- Getters e Setters (Essenciais para o Spring ler e gravar os dados) ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public Integer getExemplares() {
        return exemplares;
    }
    public void setExemplares(Integer exemplares) { this.exemplares = exemplares; }
}