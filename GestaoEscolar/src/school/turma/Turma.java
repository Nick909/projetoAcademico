package school.turma;

import java.util.ArrayList;
import java.util.Scanner;

import school.aluno.Aluno;
import school.professor.Professor;


public class Turma {
	private int cod;
	private String nome;
	private String disciplina;
	private Professor professor;
	private Aluno aluno;
	private int matriculados;
	private Turma turma;

	
	public Turma() {
		
	}
	
	public Turma(int cod, String disciplina, Professor professor, Aluno aluno, int matriculados, Turma turma, String nome) {
		this.nome=nome;
		this.cod = cod;
		this.disciplina = disciplina;
		this.professor = professor;
		this.aluno = aluno;
		this.matriculados = matriculados;
		this.turma = turma;
	}

	

    
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Turma getTurma() {
		return turma;
	}


	public void setTurma(Turma turma) {
		this.turma = turma;
	}


	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public int getMatriculados() {
		return matriculados;
	}

	public void setMatriculados(int matriculados) {
		this.matriculados = matriculados;
	}
	 
	}
