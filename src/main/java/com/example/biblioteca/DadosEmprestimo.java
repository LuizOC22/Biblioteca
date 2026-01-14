package com.example.biblioteca;

public class DadosEmprestimo {
    // As variáveis que recebem o JSON
    private Long livroId;
    private String nomeLeitor;

    // --- O QUE DEVE ESTAR FALTANDO AÍ: ---

    // 1. Getters e Setters para livroId
    public Long getLivroId() {
        return livroId;
    }
    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    // 2. Getters e Setters para nomeLeitor
    public String getNomeLeitor() {
        return nomeLeitor;
    }
    public void setNomeLeitor(String nomeLeitor) {
        this.nomeLeitor = nomeLeitor;
    }
}
