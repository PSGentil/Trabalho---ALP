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

	public ArrayList obterListaAluno() {
		return modelo.obterListaAluno();
	}


	public boolean existePront(String Pront) {
		return modelo.existePront(Pront);
	}

	public void adiciona(AlunoVO novoAluno) {
		modelo.adiciona(novoAluno);
	}

}
