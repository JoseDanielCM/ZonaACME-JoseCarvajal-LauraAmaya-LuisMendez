package View.SuperUsuario.Reportes;

import Controller.FuncionarioController;
import Controller.SuperUsuarioController;
import Controller.SupervisorController;
import Model.Persona;
import Model.Supervisor;
import Model.Usuario;
import Repository.Impl.ConcurrenciaRegistros;
import View.Funcionario.FuncionarioMainMenu;
import View.SuperUsuario.InicioSesion;
import View.SuperUsuario.SuperUsuarioMainMenu;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class ReporteActivos extends JFrame {
    private Usuario superUsuario;
    DefaultTableModel mt = new DefaultTableModel(new Object[]{"Documento", "Nombre", "Activo", "Empresa"},0){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Deshabilitar edición
        }
    };
    public ReporteActivos(Usuario superUsuario) {
        this.superUsuario = superUsuario;
        initComponents();
        this.setLocationRelativeTo(null);
        lblNombreUsuario.setText(superUsuario.getNombre());

        // TABLA ----------------------------------------------------------------
        jTable1.setModel(mt);


// -----------------------------------------------------------------------
        btnHouse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuperUsuarioMainMenu superUsuarioMainMenu = new SuperUsuarioMainMenu(superUsuario);
                superUsuarioMainMenu.setVisible(true);
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
// -----------------------------------------------------------------------
        btnSupervisor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuperUsuarioController superUsuarioController = new SuperUsuarioController();
                List<Supervisor> usuarios = superUsuarioController.getAllSupervisors();
                DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Documento", "Nombre", "Activo", "Empresa"},0){
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false; // Deshabilitar edición
                    }
                };
                jTable1.setModel(modelo);
                for (Supervisor person : usuarios){
                    modelo.addRow(new Object[]{person.getDocumento(),person.getNombre(),person.isActivo(),person.getEmpresa().getNombre()});
                }
            }
        });

        btnFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupervisorController supervisorController = new SupervisorController();
                List<Usuario> usuarios = supervisorController.mostrarTodosFuncionariosoGuarda(4);
                DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Documento", "Nombre", "Activo", "Empresa"},0){
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false; // Deshabilitar edición
                    }
                };
                jTable1.setModel(modelo);
                for (Usuario person : usuarios){
                    modelo.addRow(new Object[]{person.getDocumento(),person.getNombre(),person.isActivo(),person.getEmpresa().getNombre()});
                }
            }
        });

        btnGuarda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupervisorController supervisorController = new SupervisorController();
                List<Usuario> usuarios = supervisorController.mostrarTodosFuncionariosoGuarda(3);
                DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Documento", "Nombre", "Activo", "Empresa"},0){
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false; // Deshabilitar edición
                    }
                };
                jTable1.setModel(modelo);
                for (Usuario person : usuarios){
                    modelo.addRow(new Object[]{person.getDocumento(),person.getNombre(),person.isActivo(),person.getEmpresa().getNombre()});
                }
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
        btnHouse = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnFuncionario = new javax.swing.JButton();
        btnGuarda = new javax.swing.JButton();
        btnSupervisor = new javax.swing.JButton();

        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                // Obtener el componente predeterminado
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Verificar el valor del atributo "Activo"
                boolean isActive = (boolean) table.getValueAt(row, 2); // Columna 1 es "Activo"
                if (isActive) {
                    c.setBackground(Color.GREEN); // Cambiar el color de fondo si activo es true
                } else {
                    c.setBackground(Color.RED); // Cambiar el color de fondo si activo es false
                }

                // Si la fila está seleccionada, usar el color predeterminado de selección
                if (isSelected) {
                    c.setBackground(table.getSelectionBackground());
                    c.setForeground(table.getSelectionForeground());
                } else {
                    c.setForeground(Color.BLACK); // Texto en negro para ambas condiciones
                }

                return c;
            }
        });

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
        lblTipoUsuario.setText("SUPERUSUARIO");

        javax.swing.GroupLayout superiorBackgroundLayout = new javax.swing.GroupLayout(superiorBackground);
        superiorBackground.setLayout(superiorBackgroundLayout);
        superiorBackgroundLayout.setHorizontalGroup(
                superiorBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(superiorBackgroundLayout.createSequentialGroup()
                                .addComponent(lblLogo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
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

        btnHouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/casa.png"))); // NOI18N
        btnHouse.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));


        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logout.png"))); // NOI18N
        btnLogout.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Documento", "Nombre", "Activo", "Empresa"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);

        btnFuncionario.setBackground(new java.awt.Color(52, 33, 91));
        btnFuncionario.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        btnFuncionario.setForeground(new java.awt.Color(255, 255, 255));
        btnFuncionario.setText("Funcionarios");
        btnFuncionario.setToolTipText("");

        btnGuarda.setBackground(new java.awt.Color(52, 33, 91));
        btnGuarda.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        btnGuarda.setForeground(new java.awt.Color(255, 255, 255));
        btnGuarda.setText("Guardas");
        btnGuarda.setToolTipText("");

        btnSupervisor.setBackground(new java.awt.Color(52, 33, 91));
        btnSupervisor.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        btnSupervisor.setForeground(new java.awt.Color(255, 255, 255));
        btnSupervisor.setText("Supervisores");
        btnSupervisor.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(superiorBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnHouse)
                                .addGap(88, 88, 88)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLogout)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(btnSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(btnGuarda, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(superiorBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnGuarda, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnHouse))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)))
                                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>

    // Variables declaration - do not modify
    private javax.swing.JButton btnFuncionario;
    private javax.swing.JButton btnGuarda;
    private javax.swing.JButton btnHouse;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSupervisor;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JPanel superiorBackground;
    // End of variables declaration
}
