package modelo;

import java.util.ArrayList;

/***
 * Classe responsavel por realizar as operacoes de PERSIST�NCIA: criar, alterar, remover, listar
 * mais alguns m�todos auxiliares: verificar se esta vazia ou cheia...
 * 
 * @author naur
 * em 25/03/2019
 * alterado 15/08/2023
 */

public class AlunoModelo {

	ArrayList<AlunoVO> listaAluno = new ArrayList<AlunoVO>();

	public boolean ehVazia() {
			return listaAluno.isEmpty();
	}

	
	public ArrayList<AlunoVO> obterListaAluno() {
		return listaAluno;
	}

	
	public boolean existePront(String codigo) {

		for(int i = 0; i < listaAluno.size(); i++) {
			
			if(listaAluno.get(i).getProntuario() != null) {
			
				if(listaAluno.get(i).getProntuario().equals(codigo))
				{
					return true;
				}
			}
		}
		
		return false;
	}


	public void adiciona(AlunoVO novoAmigo) {
		
		listaAluno.add(novoAmigo);

	}
	
} 
