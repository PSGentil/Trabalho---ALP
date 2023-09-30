package visao;

import controle.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.AlunoVO;

public class ListarAlunoVisao extends JFrame { //ADICIONAR BARRA DE PESQUISA

    String retorno = String.format("%9s %15s %25s %15s %25s %15s\n", "Prontuário", "Nome", "Qtd Instrumentos",
            "Favorito", "Data de ingressão", "Valor bolsa");
    JButton btFecha, btBusca;
    JTextArea lista;
    JTextField txtBusca;

    AlunoControle controle;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public ListarAlunoVisao(AlunoControle controle) {

        super("Listagem de alunos");

        this.controle = controle;
        setSize(560, 220);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocation(((int) screenSize.getWidth()/2) - 280, 490);
        setLayout(new FlowLayout());
        setResizable(true);
        
        buttonHandler handler = new buttonHandler();

        JPanel busca = new JPanel();
        txtBusca = new JTextField(15);
        btBusca = new JButton("Buscar");
        btBusca.addActionListener(handler);
        busca.add(txtBusca);
        busca.add(btBusca);

        JPanel listagem = new JPanel();
        lista = new JTextArea(5, 48);
        JScrollPane scroll = new JScrollPane(lista);
        listagem.add(scroll);
        
        JPanel botoes = new JPanel();
        btFecha = new JButton("Fechar");
        btFecha.addActionListener(handler);
        botoes.add(btFecha);

        ArrayList<AlunoVO> texto = controle.obterListaAluno();

        for (AlunoVO alunoVO : texto) {
            retorno += alunoVO;
        }

        

        lista.setText(retorno);

        ImageIcon imagem = new ImageIcon("./imagens/lista.png");
        setIconImage(imagem.getImage());
        add(busca);
        add(listagem);
        add(botoes);

    }

    public void mostrar() {
        setVisible(true);
    }

    public void fecha() {
        dispose();
    }

    public void atualizar(AlunoControle controle) {
        retorno = String.format("%9s %15s %25s %15s %25s %15s\n", "Prontuário", "Nome", "Qtd Instrumentos",
            "Favorito", "Data de ingressão", "Valor bolsa");
        ArrayList<AlunoVO> texto = controle.obterListaAluno();
        for (AlunoVO alunoVO : texto) {
            retorno += alunoVO;
        }
        lista.setText(retorno);
    }
    public void buscar(String busca) {
        retorno = String.format("%9s %15s %25s %15s %25s %15s\n", "Prontuário", "Nome", "Qtd Instrumentos",
            "Favorito", "Data de ingressão", "Valor bolsa");

        ArrayList<AlunoVO> aluno = controle.obterListaAluno();

        for (AlunoVO alunoVO : aluno) {
            if (alunoVO.getNome().toLowerCase().contains(busca.toLowerCase())) {
                retorno += alunoVO;
            }
        }
        lista.setText(retorno);
    }

    private class buttonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btFecha) {
                fecha();
            } else if (e.getSource() == btBusca) {
                buscar(txtBusca.getText());
            }

        }

    }

}
