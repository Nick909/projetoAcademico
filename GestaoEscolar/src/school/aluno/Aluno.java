package school.aluno;

import java.util.ArrayList;

import school.pessoa.Pessoa;
import school.turma.Turma;


public class Aluno extends Pessoa {
	private int matricula;
	private int cre;
	private Turma turma;
	private double nota1, nota2, nota3, nota4;
	ArrayList<Aluno> alunoList = new ArrayList<>();
	

	public Aluno() {
		
	}

	public Aluno(String nome, String cpf, int matricula, int cre, Turma turma, double nota1,
			double nota2) {
		super(nome, cpf);
		this.matricula = matricula;
		this.cre = cre;
		this.turma = turma;
		this.nota1 = nota1;
		this.nota2 = nota2;
		
	}


	public Aluno(String nome, String cpf, int matricula) {
		super(nome, cpf);
		this.matricula = matricula;
	}

	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public int getCre() {
		return cre;
	}
	public void setCre(int cre) {
		this.cre = cre;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	//notas
	
		public double getNota1() {
			return nota1;
		}

		public boolean setNota1(double nota1) {
			if(nota1 > 10) {
				return false;
			}
			this.nota1 = nota1;
				return true;
		}

		public double getNota2() {
			return nota2;
		}

		public boolean setNota2(double nota2) {
			if(nota2 > 10) {
				return false;
			}
			this.nota2 = nota2;
				return true;
		}

		//fazer m�dia
		
		public double media(){
				return (this.nota1+this.nota2)/2;
				
			}

			//rendimento
			public String rendimento() {
				if(this.media()> 6) {
					return "Aluno Aprovado";
				}
				return "Aluno Reprovado";
			
			}
			//ver_Notas
			public void ver_Notas(Aluno aluno) {
				System.out.println("1� Nota: " + aluno.nota1);
				System.out.println("2� Nota: " + aluno.nota2);
			
			}
			public void exibeInformacoes(ArrayList<Aluno> alunoList) {
				String id = "Indice: " + alunoList.indexOf(this);
				String nome = "Nome do Aluno: " + getNome();
				String cpf = "CPF: " + getCpf();
				String matricula = "Matricula: " + getMatricula();
				String nota1 = "1� NOTA: "+getNota1();
				String nota2 = "1� NOTA: "+getNota2();
				System.out.println(id + "\n, " + nome + "\n, " + cpf +" \n"+matricula+"\n "+ nota1 + "\n "+nota2+"\n " );
			}

			

			
	}




