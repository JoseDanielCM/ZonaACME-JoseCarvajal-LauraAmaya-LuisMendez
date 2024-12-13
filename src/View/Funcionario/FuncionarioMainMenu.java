package View.Funcionario;

import Model.Usuario;
import View.SuperUsuario.InicioSesion;

import javax.swing.*;
import java.awt.event.ActionListener;
    public class FuncionarioMainMenu extends javax.swing.JFrame {

        private Usuario funcionario;

        public FuncionarioMainMenu(Usuario funcionario) {
            this.funcionario = funcionario;
            initComponents();
            this.setLocationRelativeTo(null);
            lblBienvenida.setText(funcionario.getNombre());

            // --------------------------------------------------------------------------------
            jButton2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    InicioSesion inicioSesion = new InicioSesion();
                    inicioSesion.setVisible(true);
                    dispose();
                }
            });
            // --------------------------------------------------------------------------------
            brnCrearSupervisor1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    GestionPersonasMenu gestionPersonasMenu = new GestionPersonasMenu(funcionario);
                    gestionPersonasMenu.setVisible(true);
                    dispose();
                }
            });
            btnDesactivarSupervisor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    PersonasActivasMenu personasActivasMenu = new PersonasActivasMenu(funcionario);
                    personasActivasMenu.setVisible(true);
                    dispose();
                }
            });
            btnConfigurarDB1.addActionListener(new ActionListener() {
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
            brnCrearSupervisor = new javax.swing.JButton();
            btnEmpresa = new javax.swing.JButton();
            btnDesactivarSupervisor = new javax.swing.JButton();
            btnConfigurarDB = new javax.swing.JButton();
            brnCrearSupervisor1 = new javax.swing.JButton();
            btnConfigurarDB1 = new javax.swing.JButton();
            jButton2 = new javax.swing.JButton();
            jScrollPane1 = new javax.swing.JScrollPane();
            jTextArea1 = new javax.swing.JTextArea();

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
            lblBienvenida2.setText("Funcionario");

            javax.swing.GroupLayout superiorBackgroundLayout = new javax.swing.GroupLayout(superiorBackground);
            superiorBackground.setLayout(superiorBackgroundLayout);
            superiorBackgroundLayout.setHorizontalGroup(
                    superiorBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(superiorBackgroundLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 474, Short.MAX_VALUE)
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

            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/"))); // NOI18N
            jLabel1.setText("jLabel1");


            btnEmpresa.setBackground(new java.awt.Color(52, 33, 91));
            btnEmpresa.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
            btnEmpresa.setForeground(new java.awt.Color(255, 255, 255));
            btnEmpresa.setText("Actualizar Persona");
            btnEmpresa.setToolTipText("");
            btnEmpresa.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnEmpresaActionPerformed(evt);
                }
            });

            btnDesactivarSupervisor.setBackground(new java.awt.Color(52, 33, 91));
            btnDesactivarSupervisor.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
            btnDesactivarSupervisor.setForeground(new java.awt.Color(255, 255, 255));
            btnDesactivarSupervisor.setText("Personas Activas");
            btnDesactivarSupervisor.setToolTipText("");
            btnDesactivarSupervisor.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnDesactivarSupervisorActionPerformed(evt);
                }
            });

            btnConfigurarDB.setBackground(new java.awt.Color(52, 33, 91));
            btnConfigurarDB.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
            btnConfigurarDB.setForeground(new java.awt.Color(255, 255, 255));
            btnConfigurarDB.setText("Desactivar Persona");
            btnConfigurarDB.setToolTipText("");
            btnConfigurarDB.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnConfigurarDBActionPerformed(evt);
                }
            });

            brnCrearSupervisor1.setBackground(new java.awt.Color(52, 33, 91));
            brnCrearSupervisor1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
            brnCrearSupervisor1.setForeground(new java.awt.Color(255, 255, 255));
            brnCrearSupervisor1.setText("Gestión Personas");
            brnCrearSupervisor1.setToolTipText("");
            brnCrearSupervisor1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    brnCrearSupervisor1ActionPerformed(evt);
                }
            });

            btnConfigurarDB1.setBackground(new java.awt.Color(52, 33, 91));
            btnConfigurarDB1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
            btnConfigurarDB1.setForeground(new java.awt.Color(255, 255, 255));
            btnConfigurarDB1.setText("Salida Manual");
            btnConfigurarDB1.setToolTipText("");
            btnConfigurarDB1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnConfigurarDB1ActionPerformed(evt);
                }
            });

            jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logout.png"))); // NOI18N
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });

            jTextArea1.setColumns(20);
            jTextArea1.setRows(5);
            jScrollPane1.setViewportView(jTextArea1);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(superiorBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(26, 26, 26)
                                                    .addComponent(brnCrearSupervisor))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(40, 40, 40)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(btnEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(btnDesactivarSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(brnCrearSupervisor1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                            .addComponent(btnConfigurarDB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                            .addComponent(btnConfigurarDB1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addGap(71, 71, 71)
                                                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addGap(33, 33, 33)
                                                                    .addComponent(btnDesactivarSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                    .addComponent(brnCrearSupervisor1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                    .addComponent(btnEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addGroup(layout.createSequentialGroup()
                                                                                    .addComponent(btnConfigurarDB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                    .addComponent(btnConfigurarDB1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addGap(87, 87, 87))
                                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addGap(68, 68, 68))))
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                                    .addComponent(brnCrearSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, Short.MAX_VALUE))))
            );

            pack();
        }// </editor-fold>

        private void brnCrearSupervisorActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }

        private void btnEmpresaActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }

        private void btnDesactivarSupervisorActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }

        private void btnConfigurarDBActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }

        private void brnCrearSupervisor1ActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }

        private void btnConfigurarDB1ActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }


        // Variables declaration - do not modify
        private javax.swing.JButton brnCrearSupervisor;
        private javax.swing.JButton brnCrearSupervisor1;
        private javax.swing.JButton btnConfigurarDB;
        private javax.swing.JButton btnConfigurarDB1;
        private javax.swing.JButton btnDesactivarSupervisor;
        private javax.swing.JButton btnEmpresa;
        private javax.swing.JButton jButton2;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTextArea jTextArea1;
        private javax.swing.JLabel lblBienvenida;
        private javax.swing.JLabel lblBienvenida2;
        private javax.swing.JPanel superiorBackground;
        // End of variables declaration
    }
