/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import java.util.logging.*;
import Conexion.Conectar;
import Tabla.ProductoDAO;
import Tabla.ProductoVO;
import Tabla.Tabla_Venta;
import Tabla.Tabla_VentaTaller;
import Tabla.Tabla_todas;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.util.Calendar;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CLAUDIA NAVARRETE
 */
public class Venta extends javax.swing.JFrame {

    ProductoDAO dao;
    ProductoVO vo = new ProductoVO();
    Tabla_Venta t = new Tabla_Venta();
    Tabla_VentaTaller t2 = new Tabla_VentaTaller();
    Tabla_todas t1 = new Tabla_todas();
    Principal ini= new Principal();
    int codigo = 0;
    Conectar  con= new Conectar();   
    Connection reg = con.getConnection();
    
    
    public Venta() {
        initComponents();
        t1.visualizar_todas(tabla);
         
        Calendar cal=Calendar.getInstance(); 
        String fecha=cal.get(Calendar.DATE)+"/"+cal.get(cal.MONTH)+"/"+cal.get(cal.YEAR); 
        String hora=cal.get(cal.HOUR_OF_DAY)+":"+cal.get(cal.MINUTE)+":"+cal.get(cal.SECOND);
        this.Fecha.setText(fecha); 
        this.Fecha1.setText(fecha); 
        this.Fecha2.setText(fecha); 
        this.Hora.setText(hora); 
        this.Hora1.setText(hora);
        this.Hora2.setText(hora);
        this.setLocationRelativeTo(null);
        
        String folio,A_M;
     //   A_M= JOptionPane.showInputDialog(null,"Maestro o Alumno");
        folio= JOptionPane.showInputDialog(null,"Danos tu registro");
        
    /*   ME FALLO PARA PODER BUSCAR SI EL USUARIO ESTABA O NO YA REGISTRADO
        String sq,sM,sA;   
    if(A_M.equals("")){
           JOptionPane.showMessageDialog(null,"Ingresa Valores");
        }
    else{
//busca en Maestros el folio
String a;
       if(A_M.equals("Maestro")){
           sM="SELECT FolioM FROM registro WHERE FolioM='"+folio+"'";
           try{
           Conectar conec = new Conectar();
           Statement sentencia=reg.createStatement();
           ResultSet rs = null;
           PreparedStatement ps = null;
           ps = conec.getConnection().prepareStatement(sM);
           ps.executeQuery();
           a=  rs.getString(1);
           
           if(folio.equals(a)){
               labelRegistro.setText(folio);
           }else{
               JOptionPane.showMessageDialog(null,"No estas Registrado");
               Principal ini = new Principal();
               ini.show();
               this.setVisible(false);
           }
           }catch(SQLException ex){
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE,null,ex);      
           }
          }
//Busca en Alumnos el folio  
       if(A_M.equals("Alumno")){
            sA="SELECT FolioM * FROM registro where FolioM = '"+folio+"'";
            labelRegistro.setText(sA);
       } 
    }     */
     
        FolioIngreso.setText(folio);
        folioingresoc.setText(folio);
        registroLB.setText(folio);
        labelRegistro.setText(folio);
        
           
    }

   
    void Buscar(String valores){
      DefaultTableModel Modelo = new DefaultTableModel();
       //Titulo de las columnas
        Modelo.addColumn("Foto");
        Modelo.addColumn("Nombre");
        Modelo.addColumn("Conferencia");
        Modelo.addColumn("Taller");
        Modelo.addColumn("Fecha");
        Modelo.addColumn("Hora");
        Modelo.addColumn("Fecha Taller");
        Modelo.addColumn("Hora Taller");
        Modelo.addColumn("Costo");
        Modelo.addColumn("Costo Taller");
       tabla.setModel(Modelo);
       //Arreglo para llenar la tabla
       String[]datos = new String[11];
       String sql="";
      
       if(valores.equals("")){
           sql = "SELECT * FROM regconferencistas";
       }else{
           sql="SELECT*FROM regconferencistas WHERE NomConferencista='"+valores+"'";
       }
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
               datos[7]= rs.getString(8);
               datos[8]= rs.getString(9);
               datos[9]= rs.getString(10);
               datos[10]= rs.getString(11);
         
               Modelo.addRow(datos);
           }
            tabla.setModel(Modelo);
       }catch(SQLException ex){
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE,null,ex);      
       }
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
  
   
  
   
   
   
   //Este era para los lugares, pero ya no se lo agrege:(
public int miCant(String tit){
        return 0;
   
  /* String sql;
   
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
     return cantidad;*/
     
   }
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TiketConfe = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Fecha = new javax.swing.JLabel();
        Hora = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Tcant = new javax.swing.JLabel();
        lbconfe = new javax.swing.JLabel();
        rprecioc1 = new javax.swing.JLabel();
        Ttotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        comprarConferencia = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        folioingresoc = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        imparteC1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        fechac1 = new javax.swing.JLabel();
        horac1 = new javax.swing.JLabel();
        Confe_Taller = new javax.swing.ButtonGroup();
        TiketTaller = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        Fecha1 = new javax.swing.JLabel();
        Hora1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        Tcant1 = new javax.swing.JLabel();
        nomTaller = new javax.swing.JLabel();
        Tunit1 = new javax.swing.JLabel();
        Ttotal1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        ventaTaller = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        registroLB = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        imparteTaller = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        lbFechaTaller = new javax.swing.JLabel();
        lbHoraTaller = new javax.swing.JLabel();
        TiketAmbos = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        Fecha2 = new javax.swing.JLabel();
        Hora2 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        Tcant2 = new javax.swing.JLabel();
        lbnomconferencia = new javax.swing.JLabel();
        precioC = new javax.swing.JLabel();
        Ttotal2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        FolioIngreso = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        imparte = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        lbFechaC = new javax.swing.JLabel();
        lbHoraC = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        precioT = new javax.swing.JLabel();
        Ttotal2T = new javax.swing.JLabel();
        Tcant2T = new javax.swing.JLabel();
        lbnomTaller = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        lbFechaT = new javax.swing.JLabel();
        lbHoraT = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        buscaConferencista = new javax.swing.JTextField();
        verTaller = new javax.swing.JRadioButton();
        Verconfe = new javax.swing.JRadioButton();
        verTodo = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        labelRegistro = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        TiketConfe.setTitle("Tiket de Conferencia");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Instituto Tecnologico de Durango");

        jLabel4.setText("Blvd. Felipe Pescador 1830, Nueva Vizcaya, 34080 Durango, Dgo.");

        Fecha.setText("Fecha");

        Hora.setText("Hora");

        jLabel6.setText("Cant.");

        jLabel7.setText("Conferencia");

        jLabel8.setText("Pre.Unit");

        jLabel9.setText("Total");

        Tcant.setText("1      ");

        lbconfe.setText("Avatar");

        rprecioc1.setText("30");

        Ttotal.setText("30");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Para mayor informacion acerca\ndel tratamiento de sus datos,\nusted puede consultar la version\nintegral del Aviso de Privacidad,\nen las oficinas del Instituto\nTecnologico de Durango y para \nfacturacion en \nhttps://www.itdurango.edu.mx/");
        jTextArea1.setBorder(null);
        jScrollPane1.setViewportView(jTextArea1);

        comprarConferencia.setBackground(new java.awt.Color(255, 153, 255));
        comprarConferencia.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        comprarConferencia.setText("Comprar");
        comprarConferencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        comprarConferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprarConferenciaActionPerformed(evt);
            }
        });

        jLabel11.setText("Codigo: ");

        folioingresoc.setText("TECH000");

        jLabel15.setText("Conferencista");

        imparteC1.setText("jLabel16");

        jLabel17.setText("Fecha y Hora");

        fechac1.setText("jLabel19");

        horac1.setText("jLabel20");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(imparteC1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(Tcant)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbconfe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                        .addGap(63, 63, 63)))
                                .addComponent(Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(fechac1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(horac1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(comprarConferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(folioingresoc, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(rprecioc1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Ttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Fecha)
                    .addComponent(Hora))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(folioingresoc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Tcant)
                            .addComponent(lbconfe)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rprecioc1)
                            .addComponent(Ttotal))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(imparteC1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(fechac1)
                    .addComponent(horac1))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comprarConferencia)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout TiketConfeLayout = new javax.swing.GroupLayout(TiketConfe.getContentPane());
        TiketConfe.getContentPane().setLayout(TiketConfeLayout);
        TiketConfeLayout.setHorizontalGroup(
            TiketConfeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TiketConfeLayout.setVerticalGroup(
            TiketConfeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TiketTaller.setTitle("Tiket de Taller");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setText("Instituto Tecnologico de Durango");

        jLabel22.setText("Blvd. Felipe Pescador 1830, Nueva Vizcaya, 34080 Durango, Dgo.");

        Fecha1.setText("Fecha");

        Hora1.setText("Hora");

        jLabel23.setText("Cant.");

        jLabel24.setText("Taller");

        jLabel25.setText("Pre.Unit");

        jLabel26.setText("Total");

        Tcant1.setText("1      ");

        nomTaller.setText("Avatar");

        Tunit1.setText("30");

        Ttotal1.setText("30");

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setText("Para mayor informacion acerca\ndel tratamiento de sus datos,\nusted puede consultar la version\nintegral del Aviso de Privacidad,\nen las oficinas del Instituto\nTecnologico de Durango y para \nfacturacion en \nhttps://www.itdurango.edu.mx/");
        jTextArea2.setBorder(null);
        jScrollPane4.setViewportView(jTextArea2);

        ventaTaller.setBackground(new java.awt.Color(255, 153, 255));
        ventaTaller.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        ventaTaller.setText("Comprar");
        ventaTaller.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ventaTaller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaTallerActionPerformed(evt);
            }
        });

        jLabel29.setText("Codigo de Registro: ");

        registroLB.setText("jLabel14");

        jLabel31.setText("Imparte");

        imparteTaller.setText("jLabel16");

        jLabel33.setText("Fecha y Hora");

        lbFechaTaller.setText("jLabel19");

        lbHoraTaller.setText("jLabel20");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(Fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(imparteTaller, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel21))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(Tcant1)
                                        .addGap(18, 18, 18)
                                        .addComponent(nomTaller, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel29)
                                            .addComponent(jLabel24))
                                        .addGap(62, 62, 62)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Hora1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(Tunit1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Ttotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(registroLB, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel33)
                        .addGap(18, 18, 18)
                        .addComponent(lbFechaTaller)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbHoraTaller))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(ventaTaller, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Fecha1)
                    .addComponent(Hora1))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(registroLB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Tcant1)
                            .addComponent(nomTaller)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Tunit1)
                            .addComponent(Ttotal1))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imparteTaller)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(lbFechaTaller)
                    .addComponent(lbHoraTaller))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ventaTaller)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout TiketTallerLayout = new javax.swing.GroupLayout(TiketTaller.getContentPane());
        TiketTaller.getContentPane().setLayout(TiketTallerLayout);
        TiketTallerLayout.setHorizontalGroup(
            TiketTallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TiketTallerLayout.setVerticalGroup(
            TiketTallerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TiketAmbos.setTitle("Tiket Conferencia y Taller");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel36.setText("Instituto Tecnologico de Durango");

        jLabel37.setText("Blvd. Felipe Pescador 1830, Nueva Vizcaya, 34080 Durango, Dgo.");

        Fecha2.setText("Fecha");

        Hora2.setText("Hora");

        jLabel38.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel38.setText("Cant.");

        jLabel39.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel39.setText("Conferencia");

        jLabel40.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel40.setText("Pre.Unit");

        jLabel41.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel41.setText("Total ");

        Tcant2.setText("1      ");

        lbnomconferencia.setText("La Tecnologia en el Mundo");

        precioC.setText("30");

        Ttotal2.setText("30");

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jTextArea3.setRows(5);
        jTextArea3.setText("Para mayor informacion acerca\ndel tratamiento de sus datos,\nusted puede consultar la version\nintegral del Aviso de Privacidad,\nen las oficinas del Instituto\nTecnologico de Durango y para \nfacturacion en \nhttps://www.itdurango.edu.mx/");
        jTextArea3.setBorder(null);
        jScrollPane5.setViewportView(jTextArea3);

        jButton5.setBackground(new java.awt.Color(255, 153, 255));
        jButton5.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButton5.setText("Comprar");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel44.setText("Bienvenido, Folio:");

        FolioIngreso.setText("TECH789");

        jLabel46.setText("Imparte");

        imparte.setText("jLabel16");

        jLabel48.setText("Fecha y Hora Conferencia");

        lbFechaC.setText("jLabel19");

        lbHoraC.setText("jLabel20");

        jLabel51.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel51.setText("Cant.");

        jLabel52.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel52.setText("Taller");

        precioT.setText("30  ");

        Ttotal2T.setText("30  ");

        Tcant2T.setText("1 ");

        lbnomTaller.setText("Brillando el sol");

        jLabel57.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel57.setText("SubTotal");

        total.setText("60");

        jLabel59.setText("Fecha y Hora Taller");

        lbFechaT.setText("jLabel60");

        lbHoraT.setText("jLabel61");

        jLabel27.setText("-15 Desc. por eleccion de ambas");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel52))
                            .addComponent(Tcant2)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(Tcant2T, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbnomTaller)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel39)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel40)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel57)
                        .addGap(70, 70, 70))))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(85, 85, 85)
                                        .addComponent(Hora2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel37)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel48)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGap(26, 26, 26)
                                            .addComponent(jLabel46))
                                        .addComponent(jLabel59))
                                    .addGap(59, 59, 59)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(imparte, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(lbFechaC)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lbHoraC))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(lbFechaT)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lbHoraT)))))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGap(28, 28, 28)
                                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGap(61, 61, 61)
                                            .addComponent(lbnomconferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGap(1, 1, 1)
                                            .addComponent(FolioIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGap(34, 34, 34)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                    .addComponent(precioC, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(Ttotal2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                    .addComponent(precioT, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(Ttotal2T, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))))))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel36)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Fecha2)
                    .addComponent(Hora2))
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(FolioIngreso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel57))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tcant2)
                    .addComponent(lbnomconferencia)
                    .addComponent(precioC)
                    .addComponent(Ttotal2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jLabel52))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Tcant2T)
                            .addComponent(lbnomTaller)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(precioT)
                            .addComponent(Ttotal2T))))
                .addGap(7, 7, 7)
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imparte)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(lbFechaC)
                    .addComponent(lbHoraC))
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(lbFechaT)
                    .addComponent(lbHoraT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout TiketAmbosLayout = new javax.swing.GroupLayout(TiketAmbos.getContentPane());
        TiketAmbos.getContentPane().setLayout(TiketAmbosLayout);
        TiketAmbosLayout.setHorizontalGroup(
            TiketAmbosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TiketAmbosLayout.setVerticalGroup(
            TiketAmbosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TiketAmbosLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conferencias y Talleres");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 590, 250));

        jButton6.setBackground(new java.awt.Color(0, 102, 153));
        jButton6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton6.setText("Regresar");
        jButton6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 85, 31));

        jLabel18.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        jLabel18.setText("Conferencias y Talleres");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 102, 153));
        jButton1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jButton1.setText("Comprar");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 90, 30));

        buscaConferencista.setToolTipText("Buscar Conferencista");
        buscaConferencista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaConferencistaActionPerformed(evt);
            }
        });
        buscaConferencista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscaConferencistaKeyReleased(evt);
            }
        });
        jPanel1.add(buscaConferencista, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 200, -1));

        Confe_Taller.add(verTaller);
        verTaller.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        verTaller.setText("Ver Talleres");
        verTaller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verTallerActionPerformed(evt);
            }
        });
        jPanel1.add(verTaller, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, -1, -1));

        Confe_Taller.add(Verconfe);
        Verconfe.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Verconfe.setText("Ver Conferencias");
        Verconfe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerconfeActionPerformed(evt);
            }
        });
        jPanel1.add(Verconfe, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, -1, -1));

        Confe_Taller.add(verTodo);
        verTodo.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        verTodo.setText("Ver Todo");
        verTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verTodoActionPerformed(evt);
            }
        });
        jPanel1.add(verTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel1.setText("Bucar por nombre Completo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 70, 220, -1));

        labelRegistro.setText("TECH000");
        jPanel1.add(labelRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 100, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo2.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(2, 2, 2)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
  
if(verTodo.isSelected()){
          int clic = tabla.rowAtPoint(evt.getPoint());
         String NombreConferencista = ""+tabla.getValueAt(clic, 1);
         String NombreConferencia = ""+tabla.getValueAt(clic, 2);
         String NomTaller = ""+tabla.getValueAt(clic, 3);
         String Fecha = ""+tabla.getValueAt(clic, 4);
         String Hora = ""+tabla.getValueAt(clic, 5);
         String FechaT = ""+tabla.getValueAt(clic, 6);
         String HoraT = ""+tabla.getValueAt(clic, 7);
         float costo =(float) tabla.getValueAt(clic,8);
         float costoT =(float) tabla.getValueAt(clic, 9);
       
        //esto va para el tiket
          lbnomconferencia.setText(NombreConferencia);
          precioC.setText(String.valueOf(costo));
          lbnomTaller.setText(NomTaller);
          precioT.setText(String.valueOf(costoT));
          imparte.setText(NombreConferencista);
             lbFechaC.setText(Fecha);
             lbFechaT.setText(FechaT);
             lbHoraC.setText(Hora);
             lbHoraT.setText(HoraT);
      }
if(Verconfe.isSelected()){
          int clic = tabla.rowAtPoint(evt.getPoint());
       
         String NombreConferencista = ""+tabla.getValueAt(clic, 1);
         String NombreConferencia = ""+tabla.getValueAt(clic, 2);
         String Fecha = ""+tabla.getValueAt(clic, 3);
         String Hora = ""+tabla.getValueAt(clic, 4);
         float costo =(float) tabla.getValueAt(clic,5);
        //esto va para el tiket
          lbconfe.setText(NombreConferencia);
          rprecioc1.setText(String.valueOf(costo));
          imparteC1.setText(NombreConferencista);
             fechac1.setText(Fecha);
             horac1.setText(Hora);
      } 
if(verTaller.isSelected()){
          int clic = tabla.rowAtPoint(evt.getPoint());
         String NombreConferencista = ""+tabla.getValueAt(clic, 1);
         String NomTaller = ""+tabla.getValueAt(clic, 2);
         String FechaT = ""+tabla.getValueAt(clic, 3);
         String HoraT = ""+tabla.getValueAt(clic, 4);
         float costoT =(float) tabla.getValueAt(clic, 5);
       
        //esto va para el tiket
          nomTaller.setText(NomTaller);
          Tunit1.setText(String.valueOf(costoT));
          imparteTaller.setText(NombreConferencista);
             lbFechaTaller.setText(FechaT);
             lbHoraTaller.setText(HoraT);
      }
else{
        JOptionPane.showMessageDialog(null,"Selecciona una opcion");
    }   
        
            
          
       
    }//GEN-LAST:event_tablaMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Principal ini = new Principal();
        ini.show();
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     String r,mul;
     float t,s,tot, suma;
     
     String rT,mulT;
     float tT,sT,totT;   
     
if(Verconfe.isSelected()){
       r= JOptionPane.showInputDialog("¿Cuantos lugares son, para conferencia?"); 
       Tcant.setText(r);
       t= Float.parseFloat(r); //mi cantidad a vender ya en numero
       mul= rprecioc1.getText();
       s= Float.parseFloat(mul);
       tot= t*s;
       Ttotal.setText(String.valueOf(tot));
           TiketConfe.setVisible(true);
           TiketConfe.setSize(450,580);
           TiketConfe.setLocation(450,100);
      }
if(verTaller.isSelected()){
    r= JOptionPane.showInputDialog("¿Cuantos lugares son, para Taller?"); 
       Tcant1.setText(r);
       t= Float.parseFloat(r); //mi cantidad a vender ya en numero
       mul= Tunit1.getText();
       s= Float.parseFloat(mul);
       tot= t*s;
       Ttotal1.setText(String.valueOf(tot));
           TiketTaller.setVisible(true);
           TiketTaller.setSize(450,580);
           TiketTaller.setLocation(450,100);
      }
      
if(verTodo.isSelected()){
      
       r= JOptionPane.showInputDialog("¿Cuantos lugares son, para conferencia?"); 
       Tcant2.setText(r);
       t= Float.parseFloat(r); //mi cantidad a vender ya en numero
       mul= precioC.getText();
       s= Float.parseFloat(mul);
       tot= t*s;
       Ttotal2.setText(String.valueOf(tot));
       
       rT= JOptionPane.showInputDialog("¿Cuantos lugares son, para el Taller?"); 
       Tcant2T.setText(rT);
       tT= Float.parseFloat(rT); //mi cantidad a vender ya en numero
       mulT= precioT.getText();
       sT= Float.parseFloat(mulT);
       totT= tT*sT;
       Ttotal2T.setText(String.valueOf(totT));
       
       suma= (float) ((tot+totT) * 0.85);
       total.setText(String.valueOf(suma));
       
       TiketAmbos.setVisible(true);
       TiketAmbos.setSize(450,580);
       TiketAmbos.setLocation(450,100);
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comprarConferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprarConferenciaActionPerformed
   
     String sql,F,H,comprador, nconfe,imparte,precioT;
   
     F= Fecha.getText();
     H=  Hora.getText();
     comprador = folioingresoc.getText();
     nconfe= lbconfe.getText();
     imparte= imparteC1.getText();
     precioT= Ttotal.getText();
      
     sql="INSERT INTO ventaconfe (FolioReg,Imparte,Conferencia,Dia,Hora,Costo)VALUES(?,?,?,?,?,?)";
       try{
         PreparedStatement ps=reg.prepareStatement(sql);//ayuda a hacer la inseccion
         ps.setString(1,comprador);
         ps.setString(2,imparte);
         ps.setString(3,nconfe);
         ps.setString(4,F);
         ps.setString(5,H);
         ps.setString(6,precioT);
         ps.executeUpdate();
    // vertabla("");
         JOptionPane.showMessageDialog(null,"Compra Realizada con Exito");
         TiketConfe.setVisible(false);
  /*     
    p= miCant(articulo);
    nuevaEx= p-cant;   
    */
       
     }catch(SQLException ex){
         Logger.getLogger(Venta.class.getName()).log(Level.SEVERE,null,ex);
     }   
        
        
    }//GEN-LAST:event_comprarConferenciaActionPerformed

    private void buscaConferencistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaConferencistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscaConferencistaActionPerformed

    private void verTallerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verTallerActionPerformed
        if(verTaller.isSelected()){
             t2.visualizar_taller(tabla);
             
        }
    }//GEN-LAST:event_verTallerActionPerformed

    private void VerconfeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerconfeActionPerformed
       if(Verconfe.isSelected()){
            t.visualizar_cliente(tabla);
       }
    }//GEN-LAST:event_VerconfeActionPerformed

    private void verTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verTodoActionPerformed
      if(verTodo.isSelected()){
           t1.visualizar_todas(tabla);
      }
    }//GEN-LAST:event_verTodoActionPerformed

    private void ventaTallerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaTallerActionPerformed
      String sql,F,H,comprador, ntaller,imparte,precioT;
   
     F= Fecha1.getText();
     H=  Hora1.getText();
     comprador = registroLB.getText();
     ntaller= nomTaller.getText();
     imparte= imparteTaller.getText();
     precioT= Ttotal1.getText();
      
     sql="INSERT INTO taller (FolioRegT,Inpartidor,NomTaller,Fecha,Hora,Costo)VALUES(?,?,?,?,?,?)";
       try{
         PreparedStatement ps=reg.prepareStatement(sql);//ayuda a hacer la inseccion
         ps.setString(1,comprador);
         ps.setString(2,imparte);
         ps.setString(3,ntaller);
         ps.setString(4,F);
         ps.setString(5,H);
         ps.setString(6,precioT);
         ps.executeUpdate();
    // vertabla("");
         JOptionPane.showMessageDialog(null,"Compra Realizada con Exito");
         TiketTaller.setVisible(false);
  /*     
    p= miCant(articulo);
    nuevaEx= p-cant;   
    */
       
     }catch(SQLException ex){
         Logger.getLogger(Venta.class.getName()).log(Level.SEVERE,null,ex);
     }  
    }//GEN-LAST:event_ventaTallerActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
     String sql,F,H,comprador, nconfe,ntaller,precioT;
   
     F= Fecha2.getText();
     H=  Hora2.getText();
     comprador = FolioIngreso.getText();
     nconfe= lbnomconferencia.getText();
     ntaller= lbnomTaller.getText();
     precioT= total.getText();
      
     sql="INSERT INTO ventaambos (comprador,Nconfe,NTaller,PrecioT,Fecha,Hora)VALUES(?,?,?,?,?,?)";
       try{
         PreparedStatement ps=reg.prepareStatement(sql);//ayuda a hacer la inseccion
         ps.setString(1,comprador);
         ps.setString(2,nconfe);
         ps.setString(3,ntaller);
         ps.setString(4,precioT);
         ps.setString(5,F);
         ps.setString(6,H);
         ps.executeUpdate();
    // vertabla("");
         JOptionPane.showMessageDialog(null,"Compra Realizada con Exito");
         TiketAmbos.setVisible(false);
  /*     
    p= miCant(articulo);
    nuevaEx= p-cant;   
    */
       
     }catch(SQLException ex){
         Logger.getLogger(Venta.class.getName()).log(Level.SEVERE,null,ex);
     }
       
  

    }//GEN-LAST:event_jButton5ActionPerformed

    private void buscaConferencistaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaConferencistaKeyReleased
     Buscar(buscaConferencista.getText());
    }//GEN-LAST:event_buscaConferencistaKeyReleased

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
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Venta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Confe_Taller;
    private javax.swing.JLabel Fecha;
    private javax.swing.JLabel Fecha1;
    private javax.swing.JLabel Fecha2;
    private javax.swing.JLabel FolioIngreso;
    private javax.swing.JLabel Hora;
    private javax.swing.JLabel Hora1;
    private javax.swing.JLabel Hora2;
    private javax.swing.JLabel Tcant;
    private javax.swing.JLabel Tcant1;
    private javax.swing.JLabel Tcant2;
    private javax.swing.JLabel Tcant2T;
    private javax.swing.JDialog TiketAmbos;
    private javax.swing.JDialog TiketConfe;
    private javax.swing.JDialog TiketTaller;
    private javax.swing.JLabel Ttotal;
    private javax.swing.JLabel Ttotal1;
    private javax.swing.JLabel Ttotal2;
    private javax.swing.JLabel Ttotal2T;
    private javax.swing.JLabel Tunit1;
    private javax.swing.JRadioButton Verconfe;
    private javax.swing.JTextField buscaConferencista;
    private javax.swing.JButton comprarConferencia;
    private javax.swing.JLabel fechac1;
    private javax.swing.JLabel folioingresoc;
    private javax.swing.JLabel horac1;
    private javax.swing.JLabel imparte;
    private javax.swing.JLabel imparteC1;
    private javax.swing.JLabel imparteTaller;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JLabel labelRegistro;
    private javax.swing.JLabel lbFechaC;
    private javax.swing.JLabel lbFechaT;
    private javax.swing.JLabel lbFechaTaller;
    private javax.swing.JLabel lbHoraC;
    private javax.swing.JLabel lbHoraT;
    private javax.swing.JLabel lbHoraTaller;
    private javax.swing.JLabel lbconfe;
    private javax.swing.JLabel lbnomTaller;
    private javax.swing.JLabel lbnomconferencia;
    private javax.swing.JLabel nomTaller;
    private javax.swing.JLabel precioC;
    private javax.swing.JLabel precioT;
    private javax.swing.JLabel registroLB;
    private javax.swing.JLabel rprecioc1;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel total;
    private javax.swing.JButton ventaTaller;
    private javax.swing.JRadioButton verTaller;
    private javax.swing.JRadioButton verTodo;
    // End of variables declaration//GEN-END:variables
}
