package View.SuperUsuario;

import Controller.SesionController;
import Model.Sesion;
import Model.Usuario;
import View.Supervisor.SupervisorMainMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioSesion extends JFrame {

    public InicioSesion() {
        initComponents();
        this.setLocationRelativeTo(null);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String documento = txtFieldUser.getText();
                String password = txtfieldPassword.getText();
                SesionController sesionController = new SesionController();
                Sesion sesion = sesionController.buscarUsuario(documento,password);
                Usuario usuario = sesion.getUsuario();
                System.out.println(usuario.getClass());
                String tipo = String.valueOf(usuario.getClass());
                tipo= tipo.replace("class Model.","");
                System.out.println(tipo);
                switch (tipo) {
                    case "SuperUsuario":
                        SuperUsuarioMainMenu superUsuarioMainMenu = new SuperUsuarioMainMenu(usuario);
                        superUsuarioMainMenu.setVisible(true);
                        dispose();
                        break;
                    case "Supervisor":
                        SupervisorMainMenu supervisorMainMenu = new SupervisorMainMenu(usuario);
                        supervisorMainMenu.setVisible(true);
                        dispose();
                        break;
                    case "Guarda":
                        JOptionPane.showMessageDialog(null, "Bienvenido Guarda " + usuario.getNombre());
                        break;
                    case "Funcionario":
                        JOptionPane.showMessageDialog(null, "Bienvenido Funcionario " + usuario.getNombre());
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        background = new javax.swing.JPanel();
        lblBienvenida = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        txtFieldUser = new javax.swing.JTextField();
        txtfieldPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(52, 33, 91));
        setResizable(false);

        background.setBackground(new java.awt.Color(52, 33, 91));

        lblBienvenida.setFont(new java.awt.Font("FreeSans", 1, 48)); // NOI18N
        lblBienvenida.setForeground(new java.awt.Color(255, 255, 255));
        lblBienvenida.setText("BIENVENIDO");

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logoZona.png"))); // NOI18N

        lblPassword.setFont(new java.awt.Font("FreeSans", 1, 24)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("Contraseña");

        lblUser.setFont(new java.awt.Font("FreeSans", 1, 24)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setText("Usuario");

        btnLogin.setText("INGRESAR");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
                backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(backgroundLayout.createSequentialGroup()
                                                .addGap(233, 233, 233)
                                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(backgroundLayout.createSequentialGroup()
                                                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblPassword, javax.swing.GroupLayout.Alignment.TRAILING))
                                                                .addGap(26, 26, 26)
                                                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(txtFieldUser, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                                                        .addComponent(txtfieldPassword)))
                                                        .addComponent(lblImage)))
                                        .addGroup(backgroundLayout.createSequentialGroup()
                                                .addGap(243, 243, 243)
                                                .addComponent(lblBienvenida))
                                        .addGroup(backgroundLayout.createSequentialGroup()
                                                .addGap(326, 326, 326)
                                                .addComponent(btnLogin)))
                                .addContainerGap(258, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
                backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(lblBienvenida)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblImage)
                                .addGap(38, 38, 38)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(backgroundLayout.createSequentialGroup()
                                                .addComponent(txtFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                                .addComponent(txtfieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36))
                                        .addGroup(backgroundLayout.createSequentialGroup()
                                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(backgroundLayout.createSequentialGroup()
                                                                .addGap(56, 56, 56)
                                                                .addComponent(lblPassword))
                                                        .addComponent(lblUser))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(btnLogin)
                                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>


    // Variables declaration - do not modify
    private javax.swing.JPanel background;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextField txtFieldUser;
    private javax.swing.JPasswordField txtfieldPassword;
    // End of variables declaration
}
