package com.example.biblioteca;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    Optional<Emprestimo> findByLivroAndDataDevolucaoIsNull(Livro livro);

}
