import java.util.List;
import java.util.ArrayList;

public class SistemaAcademico {
	public static void main(String[] args) {
		Aluno gustavo = new Aluno(1, "Gustavo", 10);

		Curso computacao = new Curso();
		computacao.cod = 1;
		computacao.nome = "Computação";
		computacao.ch = 3200;

		gustavo.curso = computacao;

		Aluno publio = new Aluno(2, "Sebastian", 10);
		
		publio.curso = computacao;

		// System.out.println(gustavo);
		// System.out.println(publio);

		Bolsista myllene = new Bolsista(3, "Myllene", -10, 't');
		myllene.curso = computacao;
		myllene.setCr(-8);
		// System.out.println(myllene);
		// System.out.println(myllene.compara(myllene));

		Aluno milena;
		milena = new Bolsista(3, "Myllene", -10, 't');
		milena.curso = computacao;
		// System.out.println(myllene.compara(milena));
		// System.out.println(myllene == milena);

		// Pessoa p = new Pessoa("Fulano", "12345678900");

		Professor bazilio = new Professor("Bazilio", "12345678900", "Comp");

		List<Exibivel> comunidadeAcademica;
		comunidadeAcademica = new ArrayList<Exibivel>();

		comunidadeAcademica.add(gustavo);
		comunidadeAcademica.add(publio);
		comunidadeAcademica.add(myllene);
		comunidadeAcademica.add(milena);
		comunidadeAcademica.add(bazilio);
		comunidadeAcademica.add(computacao);

		for (Exibivel p : comunidadeAcademica) {
			p.exibe(); // Polimórfica
		}
	}
}

