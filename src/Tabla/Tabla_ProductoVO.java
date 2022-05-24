//Primera Pagina ._.
//Aqui visualizo los datos en la tabla y lleno la tabla.


package Tabla;

import Tabla.ProductoDAO;
import Tabla.ProductoVO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Tabla_ProductoVO{

   ProductoDAO dao = null;


    public void visualizar_ProductoVO(JTable tabla){
        
        tabla.setDefaultRenderer(Object.class, new hacerLabel());
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dt.addColumn("Clave");
        dt.addColumn("Foto");
        dt.addColumn("Conferencista");
        dt.addColumn("Conferencia");
        dt.addColumn("Taller");
        dt.addColumn("Fecha");
        dt.addColumn("Hora");
        dt.addColumn("FechaTaller");
        dt.addColumn("HoraTaller");
        dt.addColumn("Costo");
        dt.addColumn("CostoTaller");

        dao = new ProductoDAO();
        ProductoVO vo = new ProductoVO();
        ArrayList<ProductoVO> list = dao.Listar_ProductoVO();

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[11];
                vo = list.get(i);
                fila[0] = vo.getclave();
                fila[2] = vo.getNombreConferencista();
                fila[3] = vo.getNombreConferencia();
                fila[4] = vo.getNombreTaller();
                fila[5] = vo.getFechaa();
                fila[6] = vo.getHoraa();
                fila[7] = vo.getFechaT();
                fila[8] = vo.getHoraT();
                fila[9] = vo.getCosto();
                fila[10] = vo.getCostoT();
               
                try{
                    byte[] bi = vo.getFoto();
                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                    fila[1] = new JLabel(imgi);

                }catch(Exception ex){
                    fila[1] = new JLabel("No imagen");
                }
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(60);
        }
    }
}


