package school.principal;

import java.util.ArrayList;
import java.util.Scanner;

import school.aluno.Aluno;
import school.professor.Professor;
import school.turma.Turma;


public class Principal {
	public static void main(String[] args) {
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner (System.in);
	int opt =1;
	do {
		System.out.println("|||| MENU ||||");
		System.out.println("\n1= CADASTRAR ALUNO");
		System.out.println("\n2= CADASTRAR PROFESSOR");
		System.out.println("\n3= LISTAR ALUNOS");
		System.out.println("\n4= LISTAR PROFESSORES");
		System.out.println("\n5= CADASTAR NOTAS DO ALUNO");
		System.out.println("\n6= BUSCAR PROFESSOR");
		System.out.println("\n7= CRIAR TURMA");
		System.out.println("\n8= BUSCAR ALUNO");
		
		opt = scanner.nextInt();
		scanner.nextLine();
		if(opt ==1) {
			formularioAluno();
		}else if(opt == 2) {
			formularioProfessor();
		}else if(opt == 3) {
			listarAlunos(alunoList);
		}else if (opt== 4) {
			listarProfessores();
		}else if (opt== 5) {
		    cadastrarNotas();
		}else if (opt == 6) {
			listarProfessores();	
		}else if (opt == 7) {
			cadastrarTurma();	
		}else if (opt == 8) {
			encontraAlunoPorNome(alunoList);
		}else {
		  break;
	    }
	}while(opt != -1);
	}
	static ArrayList<Aluno> alunoList = new ArrayList<>();
	static ArrayList<Turma> turmaList = new ArrayList<>();
	static ArrayList<Professor> professorList = new ArrayList<>();
	
	
public Principal(ArrayList<Aluno> alunoList, ArrayList<Turma> turmaList, ArrayList<Professor> professorList) {
		super();
		this.alunoList = alunoList;
		this.turmaList = turmaList;
		this.professorList = professorList;
	}
	
public ArrayList<Aluno> getAlunoList() {
		return alunoList;
	}
	public void setAlunoList(ArrayList<Aluno> alunoList) {
		this.alunoList = alunoList;
	}
	public ArrayList<Turma> getTurmaList() {
		return turmaList;
	}
	public void setTurmaList(ArrayList<Turma> turmaList) {
		this.turmaList = turmaList;
	}
	public ArrayList<Professor> getProfessorList() {
		return professorList;
	}
	public void setProfessorList(ArrayList<Professor> professorList) {
		this.professorList = professorList;
	}
	
	//======================M�todos daClasse Aluno=================================================
	//buscar de alunos
	private static Aluno encontraAlunoPorNome(ArrayList<Aluno> alunoList) {
	  Scanner scanner = new Scanner (System.in);
		System.out.println("INFORME O NOME DO ALUNO:  ");
		String nome = scanner.nextLine();
		for (Aluno aluno : alunoList) {
			if (aluno.getNome().equals(nome)) {
				System.out.println(" Aluno Encotrado :D");
				return aluno;	
			}else {
				System.out.println(" Aluno N�o Esta Matriculado :( ");
			}
		}
		return null;
	}
	/*public static int encontraAlunoPorNome(ArrayList<Aluno> alunoList) {
		int quantidade = 0;
		Scanner scanner = new Scanner (System.in);
		System.out.println("INFORME O NOME DO ALUNO:  ");
		String nome = scanner.nextLine();
		if(! alunoList.contains(nome)) {
			System.out.println("O nome n�o existe!");
		}else{
			for(int contador = 0; contador < alunoList.size(); contador++) { 
				
			}
		}
		return quantidade;
	}*/
		
        //Cadastrar Notas
	   public static void cadastrarNotas() {
		   Aluno aluno = new Aluno();
			
			Scanner scanner = new Scanner (System.in);
	
			encontraAlunoPorNome(alunoList);
			System.out.println("INFORME A PRIMEIRA NOTA:  ");
			double nota1 = scanner.nextInt();
			aluno.setNota1(nota1);
			System.out.println("INFORME A SEGUNDA NOTA:  ");
			double nota2 = scanner.nextInt();
			aluno.setNota1(nota2);
			
			aluno.media();
			aluno.rendimento();
			aluno.ver_Notas(aluno);
	   }
	   public static void formularioAluno() {
			System.out.println("--------------ADICIONAR ALUNO---------------- ");
			Aluno aluno = new Aluno();
			
			Scanner scanner = new Scanner (System.in);
			System.out.println("INFORME O NOME DO ALUNO:  ");
			String nome = scanner.nextLine();
			aluno.setNome(nome);

			System.out.println("INFORME O CPF DO ALUNO:  ");
			String cpf = scanner.nextLine();
			aluno.setCpf(cpf);
			
			int matricula = gerarMatricula();
			aluno.setMatricula(matricula);
			
			addAluno(aluno);
			
		}
		public static void addAluno(Aluno aluno) {	
			
			alunoList.add(aluno);
		
		}
		public static int gerarMatricula() {
			int i;
		int [] vetor = new int[100];
		   for(i=0;i<=0;i++){
			   vetor[i] = (int) (1+ (Math.random()*100 + (999)));
		   }
		   for(i=0;i<=0;i++){
			   System.out.println(vetor[i]);
		   }
		
		return vetor[i];
	}  
		//Listar Alunos
		public static void listarAlunos(ArrayList<Aluno> alunoList) {
					System.out.println("\tLISTANDO Alunos: \n");
					for (Aluno aluno : alunoList) {
						aluno.exibeInformacoes(alunoList);
					}
					System.out.println();
					
		}
		public void exibeInformacoes(ArrayList<Aluno> alunoList) {
			Aluno aluno = new Aluno();
					String id = "Indice: " + alunoList.indexOf(this);
					String nome = "Nome do Aluno: " + aluno.getNome();
					String cpf = "CPF: " + aluno.getCpf();
					String matricula = "Matricula: " + aluno.getMatricula();
					String nota1 = "1� NOTA: "+aluno.getNota1();
					String nota2 = "1� NOTA: "+aluno.getNota2();
					System.out.println(id + "\n, " + nome + "\n, " + cpf +" \n"+matricula+"\n "+ nota1 + "\n "+nota2+"\n " );
	
	}
	//======================M�todos daClasse Professor=================================================
		//buscar de Professores
		private static Professor encontraProfessorPorNome(ArrayList<Professor> professorList, String nome) {
			for (Professor professor : professorList) {
				if (professor.getNome().equals(nome)) {
					return professor;
				}
			}
			return null;
		}
		//Listar Professores
		public static void listarProfessores() {
			System.out.println("\tLISTANDO PROFESSORES: \n");
			for (Professor professor : professorList) {
				professor.exibeInformacoesProfessor(professorList);
			}
			System.out.println();
			
		}
		public static void formularioProfessor() {
			System.out.println("--------------ADICIONAR PROFESSOR---------------- ");
			Professor professor = new Professor();
			
			Scanner scanner = new Scanner (System.in);
			System.out.println("INFORME O NOME DO PROFESSOR:  ");
			String nome = scanner.nextLine();
			professor.setNome(nome);
		
			System.out.println("INFORME O CPF DO PROFESSOR:  ");
			String cpf = scanner.nextLine();
			professor.setCpf(cpf);
			
			System.out.println("INFORME O DEPARTAMENTO DO PROFESSOR:  ");
			int dpto = scanner.nextInt();
			professor.setDpto(dpto);
			
			addProfessor(professor);
		}
		public static void addProfessor(Professor professor) {	
			professorList.add(professor);
		}	
//======================M�todos daClasse Turma=================================================
		Aluno aluno = new Aluno();
	public boolean matriculandoAlunosNaTurma(String nome, ArrayList<Aluno> alunoList) {
		listarAlunos(alunoList);
		Scanner scanner = new Scanner (System.in);
		System.out.println("INFORME O NOME DO ALUNO: ");
		String nomeDoAluno = scanner.nextLine();
		encontraAlunoPorNome(alunoList);
        if (this.aluno.getNome() == null) {
        	for(Turma turma :turmaList) {
        		this.addTurma(turma);
        	}
            System.out.println("Matriculando o Aluno: " + nome + ".");
        } else {

           System.out.println("Aluno " + nome + ", J� est� matricula em uma turma");
        }
		return true;
    }
 public static void cadastrarTurma() {
	 System.out.println("--------------ADICIONAR NOVA TURMA---------------- ");
		Turma turma = new Turma();
		Scanner scanner = new Scanner (System.in);
		System.out.println("INFORME O DESCRI��O DA TURMA:  ");
		String nome= scanner.nextLine();
		turma.setNome(nome);
		
		System.out.println("INFORME O CODIGO DA TURMA:  ");
		int cod = scanner.nextInt();
		turma.setCod(cod);
		
		addTurma(turma);
 }

 public static void addTurma(Turma turma) {	
	
	turmaList.add(turma);	
    }
}


