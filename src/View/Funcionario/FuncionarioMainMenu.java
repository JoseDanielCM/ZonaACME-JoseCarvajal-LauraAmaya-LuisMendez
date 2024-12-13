package View.Funcionario;

import Model.Usuario;
import View.SuperUsuario.InicioSesion;

import javax.swing.*;
import java.awt.event.ActionListener;

public class FuncionarioMainMenu extends JFrame {
    private Usuario funcionario;

    public FuncionarioMainMenu(Usuario funcionario) {
        this.funcionario = funcionario;
        initComponents();
        this.setLocationRelativeTo(null);
        lblBienvenida.setText(funcionario.getNombre());

        // --------------------------------------------------------------------------------
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioSesion inicioSesion = new InicioSesion();
                inicioSesion.setVisible(true);
                dispose();
            }
        });
        // --------------------------------------------------------------------------------
        btnGestionPersonas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionPersonasMenu gestionPersonasMenu = new GestionPersonasMenu(funcionario);
                gestionPersonasMenu.setVisible(true);
                dispose();
            }
        });
        btnPersonasActivas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PersonasActivasMenu personasActivasMenu = new PersonasActivasMenu(funcionario);
                personasActivasMenu.setVisible(true);
                dispose();
            }
        });
        btnRegistroManual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroManualMenu registroManualMenu = new RegistroManualMenu();
                registroManualMenu.setVisible(true);
                dispose();
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        superiorBackground = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblBienvenida = new javax.swing.JLabel();
        lblBienvenida2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnGestionPersonas = new javax.swing.JButton();
        btnPersonasActivas = new javax.swing.JButton();
        btnRegistroManual = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(52, 33, 91));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        superiorBackground.setBackground(new java.awt.Color(52, 33, 91));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Banner.png"))); // NOI18N

        lblBienvenida.setFont(new java.awt.Font("FreeSans", 1, 18)); // NOI18N
        lblBienvenida.setForeground(new java.awt.Color(255, 255, 255));
        lblBienvenida.setText("Username");

        lblBienvenida2.setFont(new java.awt.Font("FreeSans", 1, 36)); // NOI18N
        lblBienvenida2.setForeground(new java.awt.Color(255, 255, 255));
        lblBienvenida2.setText("FUNCIONARIO");

        javax.swing.GroupLayout superiorBackgroundLayout = new javax.swing.GroupLayout(superiorBackground);
        superiorBackground.setLayout(superiorBackgroundLayout);
        superiorBackgroundLayout.setHorizontalGroup(
                superiorBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(superiorBackgroundLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(superiorBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblBienvenida2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblBienvenida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(16, 16, 16))
        );
        superiorBackgroundLayout.setVerticalGroup(
                superiorBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(superiorBackgroundLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, superiorBackgroundLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblBienvenida2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBienvenida)
                                .addGap(12, 12, 12))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Empresa.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        btnGestionPersonas.setBackground(new java.awt.Color(52, 33, 91));
        btnGestionPersonas.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        btnGestionPersonas.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionPersonas.setText("Gestion Personas");
        btnGestionPersonas.setToolTipText("");


        btnPersonasActivas.setBackground(new java.awt.Color(52, 33, 91));
        btnPersonasActivas.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        btnPersonasActivas.setForeground(new java.awt.Color(255, 255, 255));
        btnPersonasActivas.setText("Personas Activas");
        btnPersonasActivas.setToolTipText("");


        btnRegistroManual.setBackground(new java.awt.Color(52, 33, 91));
        btnRegistroManual.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        btnRegistroManual.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistroManual.setText("Registro Manual");
        btnRegistroManual.setToolTipText("");


        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logout.png"))); // NOI18N
        btnLogout.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(superiorBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnLogout)
                                                .addGap(22, 22, 22))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(184, 184, 184)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnPersonasActivas, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnGestionPersonas)
                                                        .addComponent(btnRegistroManual, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 300, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(superiorBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addComponent(btnGestionPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(70, 70, 70)
                                                .addComponent(btnPersonasActivas, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnRegistroManual, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30))))
        );

        pack();
    }// </editor-fold>



    // Variables declaration - do not modify
    private javax.swing.JButton btnGestionPersonas;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPersonasActivas;
    private javax.swing.JButton btnRegistroManual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblBienvenida2;
    private javax.swing.JPanel superiorBackground;
    // End of variables declaration
}
