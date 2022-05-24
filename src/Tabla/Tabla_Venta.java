/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabla;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CLAUDIA NAVARRETE
 */
public class Tabla_Venta {
    ProductoDAO dao = null;
    
      public void visualizar_cliente(JTable tabla){
        tabla.setDefaultRenderer(Object.class, new hacerLabel());
        DefaultTableModel dt = new DefaultTableModel();
        
        
     //   dt.addColumn("Clave");
        dt.addColumn("Foto");
        dt.addColumn("Conferencista");
        dt.addColumn("Conferencia");
     //   dt.addColumn("Taller");
        dt.addColumn("Fecha");
        dt.addColumn("Hora");
       // dt.addColumn("FechaTaller");
       // dt.addColumn("HoraTaller");
        dt.addColumn("Costo");
       // dt.addColumn("CostoTaller");
       
       
        dao = new ProductoDAO();
        ProductoVO vo = new ProductoVO();
        ArrayList<ProductoVO> list = dao.Listar_ProductoVO();

        
         if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[11];
                vo = list.get(i);
              //  fila[0] = vo.getclave();
              
                fila[1] = vo.getNombreConferencista();
                fila[2] = vo.getNombreConferencia();
                // fila[4] = vo.getNombreTaller();
                fila[3] = vo.getFechaa();
                fila[4] = vo.getHoraa();
                fila[5] = vo.getCosto();
               
              //  fila[7] = vo.getexistR();
               
                try{
                    byte[] bi = vo.getFoto();
                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                    fila[0] = new JLabel(imgi);

                }catch(Exception ex){
                    fila[0] = new JLabel("No imagen");
                }
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(60);
        }
      }
}

