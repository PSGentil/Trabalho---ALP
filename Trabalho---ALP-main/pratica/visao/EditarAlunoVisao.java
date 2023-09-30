package visao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import controle.*;
import modelo.AlunoVO;

public class EditarAlunoVisao extends JFrame {

    private AlunoControle controle;
    public ListarAlunoVisao lista;
    // ListarAlunoVisao a;
    private JTextField txtpront, txtNome, txtFav, txtBolsa;
    private JButton btBuscar, btFecha, btAtualizar, btLimpar;

    private JComboBox<String> txtInst;
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public EditarAlunoVisao(AlunoControle controle, ListarAlunoVisao lista) {

        this.controle = controle;
        this.lista = lista;

        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Editar Aluno");
        setLayout(new FlowLayout());
        setLocation(((int) screenSize.getWidth()/2) + 200, 40);
        setResizable(false);
        setAlwaysOnTop(true);

        buttonHandler handler = new buttonHandler();

        // Input de pront
        JPanel pront = new JPanel();
        pront.setLayout(new FlowLayout());
        JLabel lbpront = new JLabel("                Prontuário: ");
        txtpront = new JTextField(15);
        pront.add(lbpront);
        pront.add(txtpront);

        JPanel busca = new JPanel();
        // Input de nome
        JPanel nome = new JPanel();
        nome.setLayout(new FlowLayout());
        JLabel lbNome = new JLabel("                           Nome: ");
        txtNome = new JTextField(15);
        txtNome.setEditable(false);
        nome.add(lbNome);
        nome.add(txtNome);

        String[] numeros = new String[13];
        for (int i = 1; i <= 13; i++) {
            numeros[i - 1] = String.valueOf(i);
        }
        // Input de intrumentos
        JPanel instrumentos = new JPanel();
        instrumentos.setLayout(new FlowLayout());
        JLabel lbInst = new JLabel("Instrumentos: ");
        txtInst = new JComboBox<>(numeros);
        txtInst.setEnabled(false);
        instrumentos.add(lbInst);
        instrumentos.add(txtInst);

        // Input de favoritos
        JPanel favorito = new JPanel();
        favorito.setLayout(new FlowLayout());
        JLabel lbFav = new JLabel("Instrumento favorito: ");
        txtFav = new JTextField(15);
        txtFav.setEditable(false);
        favorito.add(lbFav);
        favorito.add(txtFav);

        JPanel bolsa = new JPanel(new FlowLayout());
        JLabel lbBolsa = new JLabel("          Valor da Bolsa: ");
        txtBolsa = new JTextField(15);
        txtBolsa.setEditable(false);
        bolsa.add(lbBolsa);
        bolsa.add(txtBolsa);

        // Painel de botões
        JPanel botoes = new JPanel();
        btBuscar = new JButton("Buscar");
        btBuscar.addActionListener(handler);
        busca.add(btBuscar);
        btFecha = new JButton("Fechar");
        btFecha.addActionListener(handler);

        btAtualizar = new JButton("Atualizar");
        btAtualizar.addActionListener(handler);
        btAtualizar.setEnabled(false);

        btLimpar = new JButton("Limpar");
        btLimpar.addActionListener(handler);

        botoes.add(btFecha);
        botoes.add(btLimpar);
        botoes.add(btAtualizar);

        ImageIcon imagem = new ImageIcon("./imagens/edit.png");
        setIconImage(imagem.getImage());

        add(pront);
        add(busca);
        add(nome);
        add(favorito);
        add(instrumentos);
        add(bolsa);
        add(botoes);
    }

    public void mostrar() {
        setVisible(true);
    }
    private void fechar() {
        dispose();
    }
    private void limpa() {
        txtNome.setEditable(false);
        txtInst.setEnabled(false);
        txtFav.setEditable(false);
        txtBolsa.setEditable(false);
        txtNome.setText("");
        txtInst.setSelectedIndex(0);
        txtFav.setText("");
        txtBolsa.setText("");
        btAtualizar.setEnabled(false);
        txtpront.setText("");
        txtpront.requestFocus();
    }
    private void buscar(String prontuario) {
        ArrayList<AlunoVO> lista = controle.obterListaAluno();

        for (AlunoVO aluno : lista) {

            if (prontuario.trim().toLowerCase().equals(aluno.getProntuario().toLowerCase())) {
                txtNome.setText(aluno.getNome());
                txtInst.setSelectedIndex(aluno.getQtdInstrumentos() - 1);
                txtFav.setText(aluno.getFavorito());
                txtBolsa.setText(String.valueOf(aluno.getValorBolsa()));
                txtNome.setEditable(true);
                txtInst.setEnabled(true);
                txtFav.setEditable(true);
                txtBolsa.setEditable(true);
                btAtualizar.setEnabled(true);
                return;

            }
            
        }
        JOptionPane.showMessageDialog(this, "Não existe aluno com esse prontuário!");
            txtNome.setEditable(false);
            txtInst.setEnabled(false);
            txtFav.setEditable(false);
            txtBolsa.setEditable(false);
            txtNome.setText("");
            txtInst.setSelectedIndex(0);
            txtFav.setText("");
            txtBolsa.setText("");
            btAtualizar.setEnabled(false);
    }
    private void atualizar() {   
        
        controle.atualizarDados(txtpront.getText(),txtNome.getText(),(txtInst.getSelectedIndex() + 1),txtFav.getText(), Double.parseDouble(txtBolsa.getText().trim()));
        lista.atualizar(controle);
        txtNome.setEditable(false);
        txtInst.setEnabled(false);
        txtFav.setEditable(false);
        txtBolsa.setEditable(false);
        txtNome.setText("");
        txtInst.setSelectedIndex(0);
        txtFav.setText("");
        txtBolsa.setText("");
        btAtualizar.setEnabled(false);

    }

    private class buttonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btBuscar) {
                buscar(txtpront.getText());
            } else if (e.getSource() == btAtualizar) {
                atualizar();
            } else if (e.getSource() == btFecha) {
                fechar();
            } else if (e.getSource() == btLimpar) {
                limpa();
            }

        }
    }
}
