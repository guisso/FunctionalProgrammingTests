/* 
 * Material didático destinado ao curso de 
 * Programação Orientada a Objetos
 * do Bacharelado em Ciência da Computação do IFNMG 
 * - Câmpus Montes Claros.
 *
 * O uso deste material é livre e regido pela licença 
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package io.github.guisso.functionalprogrammingtests;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Classe Docente
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 * @version 0.1, 21/06/2022
 */
public class Docente {

    private Long matricula;
    private String nome;
    private LocalDate nascimento;
    private Byte idade;

    public Docente() {
    }

    public Docente(Long matricula, String nome, LocalDate nascimento) {
        setMatricula(matricula);
        setNome(nome);
        setNascimento(nascimento);
    }

    public final Long getMatricula() {
        return matricula;
    }

    public final void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public final String getNome() {
        return nome;
    }

    public final void setNome(String nome) {
        this.nome = nome;
    }

    public final LocalDate getNascimento() {
        return nascimento;
    }

    public final void setNascimento(LocalDate nascimento) {
        this.idade = (byte) nascimento.until(
                LocalDate.now(),
                ChronoUnit.YEARS);
        this.nascimento = nascimento;
    }

    public final Byte getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Docente{" 
                + "matricula=" + matricula 
                + ", nome=" + nome 
                + ", nascimento=" + nascimento 
                + ", idade=" + idade 
                + '}';
    }
    

}
