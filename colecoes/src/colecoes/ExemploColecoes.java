package colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class ExemploColecoes {
	public static void main(String[] args) {
		System.out.println("Discando...");
		
		do {
			//excutando repetidas vezes até alguém atender
			System.out.println("Telefone tocando");
		
		}while(tocando());
		
		System.out.println("Alô !!!");
	}
	private static boolean tocando() {
		boolean atendeu = new Random().nextInt(3)==1;
		System.out.println("Atendeu? " + atendeu);
		//negando o ato de continuar tocando
		return ! atendeu;
	}

	static void exemploListObject() {
		List<Aluno> alunos = new ArrayList();
		alunos.add(new Aluno("ray"));
		alunos.add(new Aluno("athos"));
		alunos.add(new Aluno("viviane"));
		alunos.add(new Aluno("marcelle"));

		Collections.sort(alunos);

		System.out.println(alunos.get(2));

		for (Aluno aluno : alunos) {
			System.out.println(aluno.getNome());
		}
	}

	static void exemploList() {
		List<String> alunos = new Vector();
		alunos.add("ray");
		alunos.add("athos");
		alunos.add("viviane");
		alunos.add("marcelle");

		System.out.println(alunos.size());

		Collections.sort(alunos);

		for (String aluno : alunos) {
			System.out.println(aluno);
		}
		System.out.println(alunos.contains("gleyson"));
		System.out.println(alunos.contains("marcelle"));
	}
}
