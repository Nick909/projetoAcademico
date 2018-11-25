package school.professor;

import java.util.ArrayList;
import java.util.Scanner;

import school.pessoa.Pessoa;
import school.turma.Turma;

public class Professor extends Pessoa {
	private int dpto;
	private Turma turma;

	
	public Professor() {
		super();
	}
	public Professor(String nome, String cpf, int dpto) {
		super(nome, cpf);
		this.dpto = dpto;
	}
	public int getDpto() {
		return dpto;
	}
	public void setDpto(int dpto) {
		this.dpto = dpto;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public void exibeInformacoesProfessor(ArrayList<Professor> professorList) {
		String id = "Indice: " + professorList.indexOf(this);
		String nome = "Nome do Professor: " + getNome();
		String cpf = "CPF: " + getCpf();
		
		
		System.out.println(id + "\n, " + nome + "\n, " + cpf +" \n" );

	}
	
}
