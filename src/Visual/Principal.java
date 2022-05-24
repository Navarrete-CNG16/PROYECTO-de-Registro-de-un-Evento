/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Conexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CLAUDIA NAVARRETE
 */
public class Principal extends javax.swing.JFrame {
     
     Conectar  con= new Conectar();   
    Connection reg = con.getConnection();
    
public Principal() {
        initComponents();
        
        this.setLocationRelativeTo(null);
    }
boolean ValidaNum(JTextField campo){
    int limite=10;
    if(campo.getText().length()== limite){
        return false;
    } 
       javax.swing.JOptionPane.showMessageDialog(this, "Verifica tu Numero");
        return true;
}
void verRegistrosConferencia(){
    DefaultTableModel miModelo = new DefaultTableModel();
       //Titulo de las columnas
       miModelo.addColumn("NumVenta");
       miModelo.addColumn("FolioRegistrado");
       miModelo.addColumn("Imparte");
       miModelo.addColumn("Conferencia");
       miModelo.addColumn("Dia");
       miModelo.addColumn("Hora");
       miModelo.addColumn("Costo");
       
       tablaRconfe.setModel(miModelo);
       //Arreglo para llenar la tabla
       String[]datos = new String[7];
       String sql="";
       
      // if(numTarjeta.equals("")){
           sql = "SELECT * FROM ventaconfe";
      // }
       /*else{
           sql="SELECT*FROM ventaspeliculas WHERE Nombre='"+numTarjeta+"' AND Parentesco='"+paren+"'";
       }*/
   try{
           Statement sentencia=reg.createStatement();
           ResultSet rs= sentencia.executeQuery(sql);
           while(rs.next()){
               datos[0]= rs.getString(1);
               datos[1]= rs.getString(2);
               datos[2]= rs.getString(3);
               datos[3]= rs.getString(4);
               datos[4]= rs.getString(5);
               datos[5]= rs.getString(6);
               datos[6]= rs.getString(7);
               miModelo.addRow(datos);
           }
            tablaRconfe.setModel(miModelo);
       }catch(SQLException ex){
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE,null,ex);      
       }   
    }

void verRegistrosTaller(){
    DefaultTableModel miModelo = new DefaultTableModel();
       //Titulo de las columnas
       miModelo.addColumn("NumVenta");
       miModelo.addColumn("FolioRegistrado");
       miModelo.addColumn("Imparte");
       miModelo.addColumn("Taller");
       miModelo.addColumn("Dia");
       miModelo.addColumn("Hora");
       miModelo.addColumn("Costo");
       
       TablaTalleresV.setModel(miModelo);
       //Arreglo para llenar la tabla
       String[]datos = new String[7];
       String sql="";
       
      // if(numTarjeta.equals("")){
           sql = "SELECT * FROM taller";
      // }
       /*else{
           sql="SELECT*FROM ventaspeliculas WHERE Nombre='"+numTarjeta+"' AND Parentesco='"+paren+"'";
       }*/
   try{
           Statement sentencia=reg.createStatement();
           ResultSet rs= sentencia.executeQuery(sql);
           while(rs.next()){
               datos[0]= rs.getString(1);
               datos[1]= rs.getString(2);
               datos[2]= rs.getString(3);
               datos[3]= rs.getString(4);
               datos[4]= rs.getString(5);
               datos[5]= rs.getString(6);
               datos[6]= rs.getString(7);
               miModelo.addRow(datos);
           }
            TablaTalleresV.setModel(miModelo);
       }catch(SQLException ex){
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE,null,ex);      
       }   
    }

void verAlumnosRegistrados(){
    DefaultTableModel miModelo = new DefaultTableModel();
       //Titulo de las columnas
       miModelo.addColumn("Folio");
       miModelo.addColumn("Control");
       miModelo.addColumn("Nombre");
       miModelo.addColumn("Carrera");
       miModelo.addColumn("Semestre");
       miModelo.addColumn("Celular");
       
       TablaRegA.setModel(miModelo);
       //Arreglo para llenar la tabla
       String[]datos = new String[6];
       String sql="";
      
           sql = "SELECT * FROM registroa";
      
   try{
           Statement sentencia=reg.createStatement();
           ResultSet rs= sentencia.executeQuery(sql);
           while(rs.next()){
               datos[0]= rs.getString(1);
               datos[1]= rs.getString(2);
               datos[2]= rs.getString(3);
               datos[3]= rs.getString(4);
               datos[4]= rs.getString(5);
               datos[5]= rs.getString(6);
               miModelo.addRow(datos);
           }
            TablaRegA.setModel(miModelo);
       }catch(SQLException ex){
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE,null,ex);      
       }   
    }

void verMaestrosRegistrados(){
    DefaultTableModel miModelo = new DefaultTableModel();
       //Titulo de las columnas
       miModelo.addColumn("Folio");
       miModelo.addColumn("Clave");
       miModelo.addColumn("Nombre");
       miModelo.addColumn("Carrera");
       miModelo.addColumn("Semestre");
       miModelo.addColumn("Celular");
       
       TablaRegistroM.setModel(miModelo);
       //Arreglo para llenar la tabla
       String[]datos = new String[6];
       String sql="";
      
           sql = "SELECT * FROM registro";
      
   try{
           Statement sentencia=reg.createStatement();
           ResultSet rs= sentencia.executeQuery(sql);
           while(rs.next()){
               datos[0]= rs.getString(1);
               datos[1]= rs.getString(2);
               datos[2]= rs.getString(3);
               datos[3]= rs.getString(4);
               datos[4]= rs.getString(5);
               datos[5]= rs.getString(6);
               miModelo.addRow(datos);
           }
            TablaRegistroM.setModel(miModelo);
       }catch(SQLException ex){
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE,null,ex);      
       }   
    }

void verRegistrosAmbos(){
    DefaultTableModel miModelo = new DefaultTableModel();
       //Titulo de las columnas
       miModelo.addColumn("NumVenta");
       miModelo.addColumn("FolioRegistrado");
       miModelo.addColumn("Conferencia");
       miModelo.addColumn("Taller");
       miModelo.addColumn("Precio Total");
       miModelo.addColumn("Dia");
       miModelo.addColumn("Hora");
       
       tablaAmbos.setModel(miModelo);
       //Arreglo para llenar la tabla
       String[]datos = new String[7];
       String sql="";
      
           sql = "SELECT * FROM ventaambos";
     
       
   try{
           Statement sentencia=reg.createStatement();
           ResultSet rs= sentencia.executeQuery(sql);
           while(rs.next()){
               datos[0]= rs.getString(1);
               datos[1]= rs.getString(2);
               datos[2]= rs.getString(3);
               datos[3]= rs.getString(4);
               datos[4]= rs.getString(5);
               datos[5]= rs.getString(6);
               datos[6]= rs.getString(7);
               miModelo.addRow(datos);
           }
            tablaAmbos.setModel(miModelo);
       }catch(SQLException ex){
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE,null,ex);      
       }   
    }

    public int miCant(String tit){
   
   String sql;
   
   sql="SELECT ExistenciaV FROM peliculas WHERE titulo='"+tit+"'";
          
     String c="";
     int cantidad;
     
     try{
         Statement s= reg.createStatement();
         ResultSet rs= s.executeQuery(sql);
         
         while(rs.next()){
             c= rs.getString("ExistenciaV");
         }
     }catch(SQLException e){
         Logger.getLogger(Venta.class.getName()).log(Level.SEVERE,null,e);
     }
      
     cantidad= Integer.parseInt(c);
     return cantidad;
     
   }
    
    public void limpiarA(){
       txtFolioA.setText("");
       txtnombreA.setText("");
       txtcontrol.setText("");
       txtcarreraA.setText("");
       txtsemestre.setText("");
       txtcelular.setText("");
       
    }
     
    public void limpiarM(){
       txtfolioM.setText("");
       txtnombreM.setText("");
       txtclave.setText("");
       txtcarreraM.setText("");
       txtsemestreM.setText("");
       txtcelularM.setText("");
       
    }
     
    public String generarNA(){
        String numA;
        int na= (int)Math.floor(Math.random()*(500+100+1)+100);
        numA= "TECH"+ na;
        return numA;
    }
    
    boolean Valida(JTextField campo){
    if(campo.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Llene los campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
 //javax.swing.JOptionPane.showMessageDialog(this, "Llene los campos vacios");
        return true;
    } 
        return false;
} 
    
    void gananciaC(){
       float total=0, concat=0;
       
       for(int i=0; i<tablaRconfe.getRowCount();i++){
           total= Float.parseFloat(tablaRconfe.getValueAt(i, 6).toString());
           concat+=total;
       }
       gananciaT.setText(String.valueOf(concat));
   }
    void gananciaT(){
       float total=0, concat=0;
       
       for(int i=0; i<TablaTalleresV.getRowCount();i++){
           total= Float.parseFloat(TablaTalleresV.getValueAt(i, 6).toString());
           concat+=total;
       }
       gananciaT1.setText(String.valueOf(concat));
   }
    void gananciaTC(){
       float total=0, concat=0;
       
       for(int i=0; i<tablaAmbos.getRowCount();i++){
           total= Float.parseFloat(tablaAmbos.getValueAt(i, 4).toString());
           concat+=total;
       }
       gananciaT3.setText(String.valueOf(concat));
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Radioinicio = new javax.swing.ButtonGroup();
        RegistroA = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtFolioA = new javax.swing.JTextField();
        txtcontrol = new javax.swing.JTextField();
        txtnombreA = new javax.swing.JTextField();
        txtcarreraA = new javax.swing.JTextField();
        txtsemestre = new javax.swing.JTextField();
        txtcelular = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();
        opAntRegistro = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        RegAlum = new javax.swing.JRadioButton();
        RegMaestro = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        RegYa = new javax.swing.JRadioButton();
        Direc = new javax.swing.JRadioButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        RegistroM = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtfolioM = new javax.swing.JTextField();
        txtclave = new javax.swing.JTextField();
        txtnombreM = new javax.swing.JTextField();
        txtcarreraM = new javax.swing.JTextField();
        txtsemestreM = new javax.swing.JTextField();
        txtcelularM = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        fondo1 = new javax.swing.JLabel();
        Direccion = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        gananciaT2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaRegA = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaRegistroM = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaRconfe = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        gananciaT = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        gananciaT1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTalleresV = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaAmbos = new javax.swing.JTable();
        gananciaT3 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        entraraDireccion = new javax.swing.JDialog();
        jPanel11 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        usuarioD = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        contraseñaD = new javax.swing.JPasswordField();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        RegistroA.setTitle("Registro para alumnos");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel2.setText("Registro Alumnos");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Folio de Registro");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Numero de Control");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Nombre ");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Carrera");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Semestre");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Celular");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, -1));

        txtFolioA.setEditable(false);
        txtFolioA.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.add(txtFolioA, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 160, -1));

        txtcontrol.setToolTipText("Solo Numeros");
        txtcontrol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcontrolKeyTyped(evt);
            }
        });
        jPanel3.add(txtcontrol, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 160, -1));

        txtnombreA.setToolTipText("Nombre Completo");
        jPanel3.add(txtnombreA, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 160, -1));
        jPanel3.add(txtcarreraA, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 160, -1));
        jPanel3.add(txtsemestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 160, -1));

        txtcelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcelularActionPerformed(evt);
            }
        });
        txtcelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcelularKeyTyped(evt);
            }
        });
        jPanel3.add(txtcelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 160, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton2.setText("Registrarme");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo4.png"))); // NOI18N
        jPanel3.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 464, 330));

        javax.swing.GroupLayout RegistroALayout = new javax.swing.GroupLayout(RegistroA.getContentPane());
        RegistroA.getContentPane().setLayout(RegistroALayout);
        RegistroALayout.setHorizontalGroup(
            RegistroALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        RegistroALayout.setVerticalGroup(
            RegistroALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistroALayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        opAntRegistro.setTitle("Opciones");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        buttonGroup1.add(RegAlum);
        RegAlum.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        RegAlum.setText("Soy Alumno");
        RegAlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegAlumActionPerformed(evt);
            }
        });

        buttonGroup1.add(RegMaestro);
        RegMaestro.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        RegMaestro.setText("Soy Maestro");
        RegMaestro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegMaestroActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/alumno.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reunion.png"))); // NOI18N

        buttonGroup1.add(RegYa);
        RegYa.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        RegYa.setText("Ya estoy Registrado");
        RegYa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegYaActionPerformed(evt);
            }
        });

        buttonGroup1.add(Direc);
        Direc.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        Direc.setText("Directivos");
        Direc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DirecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(RegYa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Direc))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(RegAlum)
                        .addGap(43, 43, 43)
                        .addComponent(RegMaestro)))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(89, 89, 89))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RegAlum)
                    .addComponent(RegMaestro))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegYa)
                    .addComponent(Direc))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout opAntRegistroLayout = new javax.swing.GroupLayout(opAntRegistro.getContentPane());
        opAntRegistro.getContentPane().setLayout(opAntRegistroLayout);
        opAntRegistroLayout.setHorizontalGroup(
            opAntRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        opAntRegistroLayout.setVerticalGroup(
            opAntRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        RegistroM.setTitle("Registro para Maestros");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel14.setText("Registro Maestros");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Folio de Registro");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Clave Maestro");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setText("Nombre ");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Carrera Imparte");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setText("Semestre Imparte");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setText("Celular");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, -1));

        txtfolioM.setEditable(false);
        txtfolioM.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.add(txtfolioM, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 160, -1));

        txtclave.setToolTipText("Solo Numeros");
        txtclave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtclaveKeyTyped(evt);
            }
        });
        jPanel5.add(txtclave, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 160, -1));

        txtnombreM.setToolTipText("Nombre Completo");
        jPanel5.add(txtnombreM, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 160, -1));
        jPanel5.add(txtcarreraM, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 160, -1));
        jPanel5.add(txtsemestreM, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 160, -1));

        txtcelularM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcelularMActionPerformed(evt);
            }
        });
        txtcelularM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcelularMKeyTyped(evt);
            }
        });
        jPanel5.add(txtcelularM, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 160, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton3.setText("Registrarme");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, -1, -1));

        fondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo4.png"))); // NOI18N
        jPanel5.add(fondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 464, 330));

        javax.swing.GroupLayout RegistroMLayout = new javax.swing.GroupLayout(RegistroM.getContentPane());
        RegistroM.getContentPane().setLayout(RegistroMLayout);
        RegistroMLayout.setHorizontalGroup(
            RegistroMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        RegistroMLayout.setVerticalGroup(
            RegistroMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistroMLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Direccion.setTitle("Directivos");

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane1.setFocusCycleRoot(true);
        jTabbedPane1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jButton4.setBackground(new java.awt.Color(255, 255, 204));
        jButton4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton4.setText("Agregar");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel27.setText("Ganancias Totales   $ ");

        gananciaT2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        gananciaT2.setText("0");

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jButton6.setText("Salir");
        jButton6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jButton7.setText("Regresar");
        jButton7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addComponent(gananciaT2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gananciaT2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Agregar Conferencista", jPanel8);

        jPanel10.setBackground(new java.awt.Color(165, 207, 244));
        jPanel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel10.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        jLabel26.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel26.setText("Alumnos Registrados");

        TablaRegA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(TablaRegA);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel26))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registros de Alumos", jPanel10);

        jPanel9.setBackground(new java.awt.Color(165, 207, 244));

        jLabel29.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel29.setText("Maestros Registrados");

        TablaRegistroM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(TablaRegistroM);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabel29)
                    .addContainerGap(287, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jLabel29)
                    .addContainerGap(377, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Registros de Maestros", jPanel9);

        jPanel7.setBackground(new java.awt.Color(165, 207, 244));

        jLabel21.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel21.setText("Venta de Conferencias");

        tablaRconfe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tablaRconfe);

        jLabel22.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel22.setText("Ganancias    $");

        gananciaT.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        gananciaT.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel22)
                        .addGap(70, 70, 70)
                        .addComponent(gananciaT, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gananciaT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ganancias Conf y Registros", jPanel7);

        jPanel12.setBackground(new java.awt.Color(165, 207, 244));

        jLabel23.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel23.setText("Venta de Talleres");

        jLabel25.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel25.setText("Ganancias    $");

        gananciaT1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        gananciaT1.setText("0");

        TablaTalleresV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaTalleresV);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(53, 53, 53)
                                .addComponent(gananciaT1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gananciaT1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        jTabbedPane1.addTab("Ganancias Taller y Registros", jPanel12);

        jPanel2.setBackground(new java.awt.Color(165, 207, 244));

        jLabel28.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel28.setText("Venta de Conferencia y Talleres");

        tablaAmbos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tablaAmbos);

        gananciaT3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        gananciaT3.setText("0");

        jLabel30.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel30.setText("Ganancias     $");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(53, 53, 53)
                        .addComponent(gananciaT3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gananciaT3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ganancias Taller y Conferencias", jPanel2);

        jPanel6.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 450));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo4.png"))); // NOI18N
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 460));

        javax.swing.GroupLayout DireccionLayout = new javax.swing.GroupLayout(Direccion.getContentPane());
        Direccion.getContentPane().setLayout(DireccionLayout);
        DireccionLayout.setHorizontalGroup(
            DireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DireccionLayout.setVerticalGroup(
            DireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        entraraDireccion.setTitle("Inicio");

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel1.setText("Usuario");

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel5.setText("Contraseña");

        contraseñaD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseñaDActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jButton5.setText("Acceder");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuarioD, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contraseñaD, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel5))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel1))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jButton5)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usuarioD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contraseñaD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap())
        );

        javax.swing.GroupLayout entraraDireccionLayout = new javax.swing.GroupLayout(entraraDireccion.getContentPane());
        entraraDireccion.getContentPane().setLayout(entraraDireccionLayout);
        entraraDireccionLayout.setHorizontalGroup(
            entraraDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        entraraDireccionLayout.setVerticalGroup(
            entraraDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio a TechDay");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 102, 204));
        jButton1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton1.setText("Entrar");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/TechDays2.jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegYaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegYaActionPerformed
        if(RegYa.isSelected()){
           
            Venta ini = new Venta();
            ini.show();
            this.setVisible(false);
            
        }
    }//GEN-LAST:event_RegYaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        opAntRegistro.setVisible(true);
        opAntRegistro.setLocation(480,250);
        opAntRegistro.setSize(400,230);
    //    this.setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtcelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcelularActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
     String sql,folio,nom,cel,carrera,semestre,control;
   
     folio= txtFolioA.getText();
     control= txtcontrol.getText();
     nom=txtnombreA.getText();
     carrera= txtcarreraA.getText();
     semestre= txtsemestre.getText();
     cel= txtcelular.getText();
     
      if(Valida(txtcontrol)== false && Valida(txtnombreA)== false && Valida(txtcarreraA)== false && Valida(txtsemestre)== false &&ValidaNum(txtcelular)== false){
           //para insertar en las tabla de empleado(los campos de la tabla) valores(variables)
       sql="INSERT INTO registroa (Folio,Control,Nombre,Carrera,Semestre,Celular)VALUES(?,?,?,?,?,?)";
       try{
         PreparedStatement ps=reg.prepareStatement(sql);//ayuda a hacer la inseccion
         ps.setString(1,folio);
         ps.setString(2,control);
         ps.setString(3,nom);
         ps.setString(4,carrera);
         ps.setString(5,semestre);
         ps.setString(6,cel);
         ps.executeUpdate();
    // vertabla("");
         JOptionPane.showMessageDialog(null,"Registrado Correctamente, Tu Folio es: "+ folio);
         limpiarA(); 
         RegistroA.setVisible(false);//
     }catch(SQLException ex){
         Logger.getLogger(Principal.class.getName()).log(Level.SEVERE,null,ex);
     }
      }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtcelularMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcelularMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcelularMActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
     String sql,folio,nom,cel,carrera,semestre,control;
    // txtfolioM.setText(generarNA());
     folio= txtfolioM.getText();
     control= txtclave.getText();
     nom=txtnombreM.getText();
     carrera= txtcarreraM.getText();
     semestre= txtsemestreM.getText();
     cel= txtcelularM.getText();
     
      if(Valida(txtclave)== false && Valida(txtnombreM)== false && Valida(txtcarreraM)== false && Valida(txtsemestreM)== false &&ValidaNum(txtcelularM)== false){
           //para insertar en las tabla de empleado(los campos de la tabla) valores(variables)
       sql="INSERT INTO registro (FolioM, idClave,Nombre,Carrera,Semestre,Celular)VALUES(?,?,?,?,?,?)";
       try{
         PreparedStatement ps=reg.prepareStatement(sql);//ayuda a hacer la inseccion
         ps.setString(1,folio);
         ps.setString(2,control);
         ps.setString(3,nom);
         ps.setString(4,carrera);
         ps.setString(5,semestre);
         ps.setString(6,cel);
         ps.executeUpdate();
    // vertabla("");
        JOptionPane.showMessageDialog(null,"Registrado Correctamente, Tu Folio es: "+ folio);
         limpiarM();
         RegistroM.setVisible(false);
     }catch(SQLException ex){
         Logger.getLogger(Principal.class.getName()).log(Level.SEVERE,null,ex);
     }
      } 
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void RegAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegAlumActionPerformed
        if(RegAlum.isSelected()){
              RegistroA.setVisible(true);
              RegistroA.setSize(450,350);
              RegistroA.setLocation(400,200);
              txtFolioA.setText(generarNA());
        }
            
    }//GEN-LAST:event_RegAlumActionPerformed

    private void RegMaestroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegMaestroActionPerformed
          if(RegMaestro.isSelected()){
            RegistroM.setVisible(true);
            RegistroM.setSize(450,350);
            RegistroM.setLocation(400,200);
            txtfolioM.setText(generarNA());
        }
    }//GEN-LAST:event_RegMaestroActionPerformed

    private void DirecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DirecActionPerformed
     if(Direc.isSelected()){
           entraraDireccion.setVisible(true);
           entraraDireccion.setLocation(550,270);
           entraraDireccion.setSize(250,210);
        }
    }//GEN-LAST:event_DirecActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Visual ini = new Visual();
            ini.show();
            Direccion.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtcontrolKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontrolKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_txtcontrolKeyTyped

    private void txtcelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcelularKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_txtcelularKeyTyped

    private void txtclaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtclaveKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_txtclaveKeyTyped

    private void txtcelularMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcelularMKeyTyped
       char car = evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_txtcelularMKeyTyped

    private void contraseñaDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseñaDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraseñaDActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       String a= contraseñaD.getText();
       String b= usuarioD.getText();
        if(a.equals("Tecnologico2021") && b.equals("Tecnologico de Durango")){
            
            Direccion.setVisible(true);
            Direccion.setSize(560,490);
            Direccion.setLocation(400,150);
            verRegistrosConferencia();
            verRegistrosTaller();
            verAlumnosRegistrados();
            verMaestrosRegistrados();
            verRegistrosAmbos();
            gananciaC();
            gananciaT();
            gananciaTC();
    String s,s1,s2;
    float S,S1,S2,suma;
    s= gananciaT.getText();
    S= Float.parseFloat(s);
    s1=gananciaT1.getText();
    S1=Float.parseFloat(s1);
    s2=gananciaT3.getText();
    S2=Float.parseFloat(s2);
    suma= S+S1+S2;
    gananciaT2.setText(String.valueOf(suma)); 
            
            
            
            this.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "Verifica tu Contraseña y/o Usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Principal ini = new Principal();
        ini.show();
        Direccion.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Direc;
    private javax.swing.JDialog Direccion;
    private javax.swing.ButtonGroup Radioinicio;
    private javax.swing.JRadioButton RegAlum;
    private javax.swing.JRadioButton RegMaestro;
    private javax.swing.JRadioButton RegYa;
    private javax.swing.JDialog RegistroA;
    private javax.swing.JDialog RegistroM;
    private javax.swing.JTable TablaRegA;
    private javax.swing.JTable TablaRegistroM;
    private javax.swing.JTable TablaTalleresV;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPasswordField contraseñaD;
    private javax.swing.JDialog entraraDireccion;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel fondo1;
    private javax.swing.JLabel gananciaT;
    private javax.swing.JLabel gananciaT1;
    private javax.swing.JLabel gananciaT2;
    private javax.swing.JLabel gananciaT3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JDialog opAntRegistro;
    private javax.swing.JTable tablaAmbos;
    private javax.swing.JTable tablaRconfe;
    private javax.swing.JTextField txtFolioA;
    private javax.swing.JTextField txtcarreraA;
    private javax.swing.JTextField txtcarreraM;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtcelularM;
    private javax.swing.JTextField txtclave;
    private javax.swing.JTextField txtcontrol;
    private javax.swing.JTextField txtfolioM;
    private javax.swing.JTextField txtnombreA;
    private javax.swing.JTextField txtnombreM;
    private javax.swing.JTextField txtsemestre;
    private javax.swing.JTextField txtsemestreM;
    private javax.swing.JTextField usuarioD;
    // End of variables declaration//GEN-END:variables
}
