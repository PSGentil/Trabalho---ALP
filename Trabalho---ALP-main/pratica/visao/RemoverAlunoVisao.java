package visao;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import controle.*;
import modelo.AlunoVO;

public class RemoverAlunoVisao extends JFrame {
    
    private AlunoControle controle;
    public ListarAlunoVisao lista;

    private JLabel lbFav, lbNome, lbpront, lbInst;
    private JTextField txtpront;
    private JButton btBuscar, btFecha, btRemover;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public RemoverAlunoVisao(AlunoControle controle, ListarAlunoVisao lista) {

        this.controle = controle;
        this.lista = lista;

        setSize(230, 265);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Remover Aluno");
        setLayout(new FlowLayout());
        setLocation(((int) screenSize.getWidth()/2) - 430, 40);
        setResizable(false);
        setAlwaysOnTop(true);

        buttonHandler handler = new buttonHandler();

        // Input de pront
        JPanel pront = new JPanel();
        pront.setLayout(new FlowLayout());
        lbpront = new JLabel(" Prontuário: ");
        txtpront = new JTextField(10);
        pront.add(lbpront);
        pront.add(txtpront);

        JPanel busca = new JPanel();
        // Input de nome
        JPanel nome = new JPanel();
        nome.setLayout(new FlowLayout());
        lbNome = new JLabel();
        nome.add(lbNome);

        String[] numeros = new String[13];
        for (int i = 1; i <= 13; i++) {
            numeros[i - 1] = String.valueOf(i);
        }
        // Input de intrumentos
        JPanel instrumentos = new JPanel();
        instrumentos.setLayout(new FlowLayout());
        lbInst = new JLabel();
        instrumentos.add(lbInst);
        

        // Input de favoritos
        JPanel favorito = new JPanel();
        favorito.setLayout(new FlowLayout());
        lbFav = new JLabel();
       
        favorito.add(lbFav);
        

        // Painel de botões
        JPanel botoes = new JPanel();
        btBuscar = new JButton("                                Buscar                                 ");
        btBuscar.addActionListener(handler);
        busca.add(btBuscar);
        btFecha = new JButton("Fechar");
        btFecha.addActionListener(handler);

        btRemover = new JButton("Remover");
        btRemover.addActionListener(handler);
        btRemover.setEnabled(false);

        botoes.add(btFecha);
        botoes.add(btRemover);

        ImageIcon imagem = new ImageIcon("./imagens/remove.png");
        setIconImage(imagem.getImage());

        add(pront);
        add(busca);
        add(nome);
        add(instrumentos);
        add(favorito);
        add(botoes);
    }

    public void mostrar() {
        setVisible(true);
    }
    private void fechar() {
        dispose();
    }
    private void buscar(String prontuario) {
        ArrayList<AlunoVO> lista = controle.obterListaAluno();

        for (AlunoVO aluno : lista) {

            if (prontuario.trim().toLowerCase().equals(aluno.getProntuario().toLowerCase())) {
               
                lbNome.setText("   Nome: " +  aluno.getNome());
                lbFav.setText("Instrumento favorito: " +  aluno.getFavorito());
                lbInst.setText("  Data de ingressão: " +  aluno.getDataIngressao());
                btRemover.setEnabled(true);
                return;

            }
            
        }
        JOptionPane.showMessageDialog(this, "Não existe aluno com esse prontuário!");
        lbNome.setText("");
        lbFav.setText("");
        lbInst.setText("");
        btRemover.setEnabled(false);
    }
    private class buttonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btBuscar) {
                buscar(txtpront.getText());
            } else if (e.getSource() == btFecha) {
                fechar();
            } else if (e.getSource() == btRemover) {
                controle.remover(txtpront.getText().trim().toLowerCase());
                lista.atualizar(controle);
            }

        }
    }   
}  
