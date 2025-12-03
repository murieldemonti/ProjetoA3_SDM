package View;

import java.awt.*;
import javax.swing.*;

public class PainelInicial extends JPanel {

    private TelaPrincipal telaprincipal;
    private JPanel painel;
    private JLabel titulo;
    private JButton BotaoCadastrar;
    private JButton BotaoGerenciar;
    private JButton BotaoVender;
    private JButton BotaoSair;


    public PainelInicial(TelaPrincipal telaPrincipal) {
        this.telaprincipal = telaPrincipal;
        initComponents();
    }

    private void initComponents() {

        // BACKGROUND
        BackgroundPanel background = new BackgroundPanel();
        background.setLayout(new BorderLayout());

        // PAINEL
        painel = new JPanel();
        painel.setOpaque(false);
        painel.setLayout(null);


        //TITULO
        titulo = new JLabel("Wine & Rose");
        titulo.setForeground(Color.WHITE);
        try {
            Font alexBrush = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/Fontes/AlexBrush-Regular.ttf"));
            alexBrush = alexBrush.deriveFont(100f);

            titulo.setFont(alexBrush);

        } catch (Exception e) {
            e.printStackTrace();
            // FALLBACK SE DER ERRO
            titulo.setFont(new Font("Segoe UI", Font.BOLD, 72));
        }


        painel.add(titulo);


        // BOTÕES
        BotaoCadastrar = new JButton();
        BotaoGerenciar = new JButton();
        BotaoVender = new JButton();
        BotaoSair = new JButton();


        BotaoCadastrar.setBorderPainted(false);
        BotaoCadastrar.setContentAreaFilled(false);
        BotaoCadastrar.setFocusPainted(false);
        BotaoCadastrar.setOpaque(false);
        BotaoCadastrar.setText("Cadastrar");
        BotaoCadastrar.setForeground(Color.WHITE);


        BotaoGerenciar.setBorderPainted(false);
        BotaoGerenciar.setContentAreaFilled(false);
        BotaoGerenciar.setFocusPainted(false);
        BotaoGerenciar.setOpaque(false);
        BotaoGerenciar.setText("Gerenciar");
        BotaoGerenciar.setForeground(Color.WHITE);


        BotaoVender.setBorderPainted(false);
        BotaoVender.setContentAreaFilled(false);
        BotaoVender.setFocusPainted(false);
        BotaoVender.setOpaque(false);
        BotaoVender.setText("Vender");
        BotaoVender.setForeground(Color.WHITE);


        BotaoSair.setBorderPainted(false);
        BotaoSair.setContentAreaFilled(false);
        BotaoSair.setFocusPainted(false);
        BotaoSair.setOpaque(false);
        BotaoSair.setText("Sair");
        BotaoSair.setForeground(Color.WHITE);


        try {
            Font poppins = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/Fontes/Poppins-Regular.ttf")).deriveFont(24f);

            BotaoCadastrar.setFont(poppins);
            BotaoGerenciar.setFont(poppins);
            BotaoVender.setFont(poppins);
            BotaoSair.setFont(poppins);

        } catch (Exception e) {
            e.printStackTrace();

            // FALLBACK SE DER ERRO
            Font fallback = new Font("Segoe UI", Font.BOLD, 24);
            BotaoCadastrar.setFont(fallback);
            BotaoGerenciar.setFont(fallback);
            BotaoVender.setFont(fallback);
            BotaoSair.setFont(fallback);
        }

        // EVENTOS
        BotaoCadastrar.addActionListener(e -> BotaoCadastrarActionPerformed(e));
        BotaoGerenciar.addActionListener(e -> BotaoGerenciarActionPerformed(e));
        BotaoVender.addActionListener(e -> BotaoVenderActionPerformed(e));
        BotaoSair.addActionListener(e -> BotaoSairActionPerformed(e));

        painel.add(BotaoCadastrar);
        painel.add(BotaoGerenciar);
        painel.add(BotaoVender);
        painel.add(BotaoSair);


        // ADICIONA AO FUNDO
        background.add(painel, BorderLayout.CENTER);

        this.setLayout(new BorderLayout());
        this.add(background, BorderLayout.CENTER);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                centralizar();
            }
        });
        centralizar();
    }

    // CLASSE DO FUNDO
    class BackgroundPanel extends JPanel {

        private Image backgroundImage;

        public BackgroundPanel() {
            backgroundImage = new ImageIcon(getClass().getResource("/Imagens/oak.jpg")).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    private int getLarguraJanela() {
        Window janela = SwingUtilities.getWindowAncestor(this);
        return (janela != null) ? janela.getWidth() : getWidth();
    }

    private void centralizar() {
        int largura = getLarguraJanela();

        int larguraBotao = 250;
        int offset = 315;

        int x = ((largura - larguraBotao) / 2) - offset;

        BotaoCadastrar.setBounds(x, 245, 250, 30);
        BotaoGerenciar.setBounds(x, 345, 250, 30);
        BotaoVender.setBounds(x, 445, 250, 30);
        BotaoSair.setBounds(x, 545, 250, 30);

        int larguraTitulo = titulo.getPreferredSize().width;
        int alturaTitulo = titulo.getPreferredSize().height;

        int xTitulo = ((largura - larguraTitulo) / 2) - offset;

        titulo.setBounds(xTitulo, 45, larguraTitulo, alturaTitulo);
    }

    // AÇÕES BOTÕES
    private void BotaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        telaprincipal.setPainel(new CadastroVinho(telaprincipal));
    }

    private void BotaoGerenciarActionPerformed(java.awt.event.ActionEvent evt) {
        telaprincipal.setPainel(new GerenciaVinho(telaprincipal));
    }

    private void BotaoVenderActionPerformed(java.awt.event.ActionEvent evt) {
        telaprincipal.setPainel(new VendeVinho(telaprincipal));
    }

    private void BotaoSairActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

}