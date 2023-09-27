package visao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import controle.*;
import modelo.AlunoVO;

public class AdicionarAlunoVisao extends JFrame {

    private AlunoControle controle;
    public ListarAlunoVisao lista;
    // ListarAlunoVisao a;

    private JTextField txtpront, txtNome, txtInst, txtFav;
    private JButton btAdiciona, btLimpa, btFecha;

    public AdicionarAlunoVisao(AlunoControle controle, ListarAlunoVisao lista) {

        this.controle = controle;
        this.lista = lista;
        // janela = new JFrame();
        setSize(420, 255);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Coletilovers");// chamará-se: Integrantes do coletivo
        setLayout(new FlowLayout());
        setLocation(825, 385);
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

        // Input de nome
        JPanel nome = new JPanel();
        nome.setLayout(new FlowLayout());
        JLabel lbNome = new JLabel("                          Nome: ");
        txtNome = new JTextField(15);

        nome.add(lbNome);
        nome.add(txtNome);

        // Input de intrumentos
        JPanel instrumentos = new JPanel();
        instrumentos.setLayout(new FlowLayout());
        JLabel lbInst = new JLabel("            Instrumentos: ");
        txtInst = new JTextField(15);

        instrumentos.add(lbInst);
        instrumentos.add(txtInst);

        // Input de favoritos
        JPanel favorito = new JPanel();
        favorito.setLayout(new FlowLayout());
        JLabel lbFav = new JLabel("Instrumento favorito: ");
        txtFav = new JTextField(15);

        favorito.add(lbFav);
        favorito.add(txtFav);

        // Painel de botões
        JPanel botoes = new JPanel();
        btAdiciona = new JButton("Adicionar");
        btAdiciona.addActionListener(handler);

        btFecha = new JButton("Fechar");
        btFecha.addActionListener(handler);

        btLimpa = new JButton("Limpar");
        btLimpa.addActionListener(handler);

        botoes.add(btAdiciona);
        botoes.add(btFecha);
        botoes.add(btLimpa);

        // adicionando a janela principal
        add(pront);
        add(nome);
        add(instrumentos);
        add(favorito);
        add(botoes);

        setResizable(true);

    }

    private void adiciona() {

        if (controle.existePront(txtpront.getText())) {
            JOptionPane.showMessageDialog(AdicionarAlunoVisao.this, "Já existe um aluno com este prontuário!");
            txtpront.requestFocus();
        } else {
            controle.adiciona(new AlunoVO(txtpront.getText(), txtNome.getText(),
                    Integer.parseInt(txtInst.getText().trim()), txtFav.getText()));
            JOptionPane.showMessageDialog(AdicionarAlunoVisao.this,
                    "Aluno adicionado! pront: " + txtpront.getText() + " | Nome: " + txtNome.getText()
                            + " | Intrumentos tocados: " + txtInst.getText() + " | favoritos: " + txtFav.getText());
            lista.atualizar(controle);
            limpa();
        }
    }

    private void limpa() {
        txtpront.setText("");
        txtNome.setText("");
        txtInst.setText("");
        txtFav.setText("");
    }

    private void fecha() {
        dispose();
    }

    public void mostrar() {
        setVisible(true);
    }

    private class buttonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btAdiciona) {
                adiciona();
            } else if (e.getSource() == btLimpa) {
                limpa();
            } else if (e.getSource() == btFecha) {
                fecha();
            }

        }

    }

}
