package com.example.biblioteca;

public class DadosEmprestimo {
    // As variáveis que recebem o JSON
    private Long livroId;
    private Long usuarioId;


    public Long getLivroId() {
        return livroId;
    }
    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
