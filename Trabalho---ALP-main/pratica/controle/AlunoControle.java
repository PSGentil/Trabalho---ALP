package controle;

import java.util.ArrayList;

import modelo.AlunoModelo;
import modelo.AlunoVO;

public class AlunoControle {

	private AlunoModelo modelo;
	
	public AlunoControle() {
		
		modelo = new AlunoModelo();
	}
	
	public boolean ehVazia() {
		return modelo.ehVazia();
	}

	public ArrayList<AlunoVO> obterListaAluno() {
		return modelo.obterListaAluno();
	}
	public void atualizarDados(String pront, String nome, int inst, String fav, double val) {
		modelo.atualizarDados( pront, nome, inst, fav, val);
	}

	public boolean existePront(String Pront) {
		return modelo.existePront(Pront);
	}
	public void ensaiar() {
		modelo.ensaiar();
	}

	public void adiciona(AlunoVO novoAluno) {
		modelo.adiciona(novoAluno);
	}
	public void remover(String p) {
		modelo.remover(p);
	}

}
