package View.Supervisor;


import Controller.SupervisorController;
import Model.Funcionario;
import Model.Persona;
import Model.Usuario;
import Repository.Impl.ConcurrenciaRegistros;
import View.SuperUsuario.InicioSesion;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

public class AnotacionesMenu extends javax.swing.JFrame {

    private Usuario supervisor;
    public AnotacionesMenu(Usuario supervisor) {
        this.supervisor = supervisor;
        initComponents();
        this.setLocationRelativeTo(null);
        lblNombreUsuario.setText(supervisor.getNombre());
        ConcurrenciaRegistros.manejoRegistros(jTextArea2, supervisor);

        btnHouse1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupervisorMainMenu supervisorMainMenu = new SupervisorMainMenu(supervisor);
                supervisorMainMenu.setVisible(true);
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

        // CREAR ANOTACIONES
        btnCrear1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String documento = txtFieldDocumento.getText();
                SupervisorController supervisorController = new SupervisorController();
                Persona persona = supervisorController.obtenerPersona(documento);
                CrearAnotacion crearAnotacion = new CrearAnotacion(supervisor, persona);
                crearAnotacion.setVisible(true);
                dispose();

            }
        });

        // VER ANOTACIONES de persona
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String documento = txtFieldDocumento.getText();
                SupervisorController supervisorController = new SupervisorController();
                Persona persona = supervisorController.obtenerPersona(documento);
                AnotacionesPersona anotacionesPersona = new AnotacionesPersona(supervisor, persona);
                anotacionesPersona.setVisible(true);
                dispose();
            }
        });

        // LUPITA -
        btnHouse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String documento = txtFieldDocumento.getText();
                System.out.println(documento);
                SupervisorController supervisorController = new SupervisorController();
                Persona persona = supervisorController.obtenerPersona(documento);
                System.out.println(persona);
                txtFieldEmpresa.setText(persona.getNombre());
            }
        });


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        superiorBackground = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        lblTipoUsuario = new javax.swing.JLabel();
        lblImgSide = new javax.swing.JLabel();
        lblCrearSupervisor = new javax.swing.JLabel();
        DocLabel = new javax.swing.JLabel();
        lblEmpresa = new javax.swing.JLabel();
        txtFieldDocumento = new javax.swing.JTextField();
        txtFieldEmpresa = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        btnHouse = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        btnCrear1 = new javax.swing.JButton();
        btnHouse1 = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

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
        lblTipoUsuario.setText("SUPERVISOR");

        javax.swing.GroupLayout superiorBackgroundLayout = new javax.swing.GroupLayout(superiorBackground);
        superiorBackground.setLayout(superiorBackgroundLayout);
        superiorBackgroundLayout.setHorizontalGroup(
                superiorBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(superiorBackgroundLayout.createSequentialGroup()
                                .addComponent(lblLogo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 433, Short.MAX_VALUE)
                                .addGroup(superiorBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblTipoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(16, 16, 16))
        );
        superiorBackgroundLayout.setVerticalGroup(
                superiorBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(superiorBackgroundLayout.createSequentialGroup()
                                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, superiorBackgroundLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblTipoUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNombreUsuario)
                                .addGap(12, 12, 12))
        );

        lblImgSide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/anotaciones.png"))); // NOI18N
        lblImgSide.setText("jLabel1");

        lblCrearSupervisor.setFont(new java.awt.Font("FreeSans", 1, 36)); // NOI18N
        lblCrearSupervisor.setText("Anotaciones");

        DocLabel.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        DocLabel.setText("Documento");

        lblEmpresa.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        lblEmpresa.setText("Nombre");

        btnCrear.setBackground(new java.awt.Color(205, 181, 255));
        btnCrear.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        btnCrear.setText("Ver Anotación");
        btnCrear.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));


        btnHouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Lupa.png"))); // NOI18N
        btnHouse.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));


        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logout.png"))); // NOI18N
        btnLogout.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        btnCrear1.setBackground(new java.awt.Color(205, 181, 255));
        btnCrear1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        btnCrear1.setText("Crear Restricción");
        btnCrear1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));


        btnHouse1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/casa.png"))); // NOI18N
        btnHouse1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(superiorBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(lblImgSide, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(83, 83, 83)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(DocLabel)
                                                        .addComponent(lblEmpresa)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(btnCrear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnCrear1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(txtFieldEmpresa, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lblCrearSupervisor, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtFieldDocumento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(btnHouse)))
                                                .addGap(18, 101, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnLogout)
                                                .addGap(8, 8, 8)))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(725, Short.MAX_VALUE)
                                        .addComponent(btnHouse1)
                                        .addGap(329, 329, 329)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(superiorBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblImgSide, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblCrearSupervisor)
                                                .addGap(18, 18, 18)
                                                .addComponent(DocLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(txtFieldDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnHouse))
                                                .addGap(42, 42, 42)
                                                .addComponent(lblEmpresa)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtFieldEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(56, 56, 56)
                                                .addComponent(btnCrear1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14)
                                                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(42, 42, 42))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(562, Short.MAX_VALUE)
                                        .addComponent(btnHouse1)
                                        .addGap(95, 95, 95)))
        );

        pack();
    }// </editor-fold>


    // Variables declaration - do not modify
    private javax.swing.JLabel DocLabel;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnCrear1;
    private javax.swing.JButton btnHouse;
    private javax.swing.JButton btnHouse1;
    private javax.swing.JButton btnLogout;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel lblCrearSupervisor;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblImgSide;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JPanel superiorBackground;
    private javax.swing.JTextField txtFieldDocumento;
    private javax.swing.JTextField txtFieldEmpresa;
    // End of variables declaration
}
