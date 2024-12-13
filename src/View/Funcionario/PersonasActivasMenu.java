package View.Funcionario;

import Model.Usuario;
import View.SuperUsuario.InicioSesion;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PersonasActivasMenu extends JFrame {
    private Usuario funcionario;

    public PersonasActivasMenu(Usuario funcionario) {
        this.funcionario = funcionario;
        initComponents();
        this.setLocationRelativeTo(null);
        lblNombreUsuario.setText(funcionario.getNombre());

        btnHouse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FuncionarioMainMenu funcionarioMainMenu = new FuncionarioMainMenu(funcionario);
                funcionarioMainMenu.setVisible(true);
                dispose();
            }
        });

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioSesion inicioSesion = new InicioSesion();
                inicioSesion.setVisible(true);
                dispose();
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        superiorBackground = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        lblTipoUsuario = new javax.swing.JLabel();
        lblMonitoreoRegistros = new javax.swing.JLabel();
        btnHouse = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(52, 33, 91));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        superiorBackground.setBackground(new java.awt.Color(52, 33, 91));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Banner.png"))); // NOI18N

        lblNombreUsuario.setFont(new java.awt.Font("FreeSans", 1, 18)); // NOI18N
        lblNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreUsuario.setText("Username");

        lblTipoUsuario.setFont(new java.awt.Font("FreeSans", 1, 36)); // NOI18N
        lblTipoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoUsuario.setText("FUNCIONARIO");

        javax.swing.GroupLayout superiorBackgroundLayout = new javax.swing.GroupLayout(superiorBackground);
        superiorBackground.setLayout(superiorBackgroundLayout);
        superiorBackgroundLayout.setHorizontalGroup(
                superiorBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(superiorBackgroundLayout.createSequentialGroup()
                                .addComponent(lblLogo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(superiorBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblTipoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22))
        );
        superiorBackgroundLayout.setVerticalGroup(
                superiorBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(superiorBackgroundLayout.createSequentialGroup()
                                .addGroup(superiorBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(superiorBackgroundLayout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(lblTipoUsuario)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblNombreUsuario)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblMonitoreoRegistros.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        lblMonitoreoRegistros.setText("Personas Activas");

        btnHouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/casa.png"))); // NOI18N
        btnHouse.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));


        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logout.png"))); // NOI18N
        btnLogout.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(superiorBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnHouse)
                                                .addGap(692, 692, 692)
                                                .addComponent(btnLogout))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(29, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblMonitoreoRegistros)
                                .addGap(266, 266, 266))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(superiorBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblMonitoreoRegistros)
                                .addGap(13, 13, 13)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnHouse))
                                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>



    // Variables declaration - do not modify
    private javax.swing.JButton btnHouse;
    private javax.swing.JButton btnLogout;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMonitoreoRegistros;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JPanel superiorBackground;
    // End of variables declaration


}
