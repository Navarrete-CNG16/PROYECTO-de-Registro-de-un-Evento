package Tabla;

import Conexion.Conectar;
import Tabla.ProductoVO;
import java.sql.*;
import java.util.ArrayList;


/*Metodo listar*/
public class ProductoDAO{

    public ArrayList<ProductoVO> Listar_ProductoVO(){
        ArrayList<ProductoVO> list = new ArrayList<ProductoVO>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM regconferencistas;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ProductoVO vo = new ProductoVO();
                vo.setClave(rs.getInt(1));
                vo.setFoto(rs.getBytes(2));
                vo.setNombreConferencista(rs.getString(3));
                vo.setNombreConferencia(rs.getString(4));
                vo.setNombreTaller(rs.getString(5));
                vo.setFechaa(rs.getString(6));
                vo.setHoraa(rs.getString(7));
                vo.setFechaT(rs.getString(8));
                vo.setHoraT(rs.getString(9));
                vo.setCosto(rs.getFloat(10));
                vo.setCostoT(rs.getFloat(11));
                list.add(vo);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }


/*Metodo agregar*/
    public void Agregar_ProductoVO(ProductoVO vo){
        Conectar conec = new Conectar();
        String sql = "INSERT INTO regconferencistas (IdConferencis, Foto, NomConferencista, NomConferencia,NomTaller, Fecha,Hora,FechaT,HoraT,Costo,CostoT)\n" +
"VALUES (NULL,?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            //  ps.setInt(0, vo.getclave());
            ps.setBytes(1, vo.getFoto());
            ps.setString(2, vo.getNombreConferencista());
            ps.setString(3, vo.getNombreConferencia());
            ps.setString(4, vo.getNombreTaller());
            ps.setString(5, vo.getFechaa());
            ps.setString(6, vo.getHoraa());  
            ps.setString(7, vo.getFechaT());
            ps.setString(8, vo.getHoraT());  
            ps.setFloat(9, vo.getCosto());
            ps.setFloat(10, vo.getCostoT());
            
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("A "+ex.getMessage());
        }catch(Exception ex){
            System.out.println("B "+ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }


/*Metodo Modificar*/
    public void Modificar_ProductoVO(ProductoVO vo){
        Conectar conec = new Conectar();
        String sql = "UPDATE regconferencistas SET Foto=?,NomConferencista = ?, NomConferencia = ?,NomTaller =?, Fecha =?, Hora=?,FechaT =?, HoraT=?, Costo =?,CostoT = ? WHERE regconferencistas.IdConferencis = ?";
                
                
        /*"UPDATE regconferencistas SET Foto = ?, "
         + "NomConferencista = ?, NomConferencia = ?,NomTaller =?, Fecha =?, Hora=?,FechaT =?, HoraT=?, Costo =?,CostoT=?\n" +
"WHERE IdConferencis = ?;";*/
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
           
            
            ps.setBytes(1, vo.getFoto());
            ps.setString(2, vo.getNombreConferencista());
            ps.setString(3, vo.getNombreConferencia());
            ps.setString(4, vo.getNombreTaller());
            ps.setString(5, vo.getFechaa());
            ps.setString(6, vo.getHoraa());
            ps.setString(7, vo.getFechaT());
            ps.setString(8, vo.getHoraT());
            ps.setFloat(9, vo.getCosto());
            ps.setFloat(10, vo.getCostoT());
            ps.setInt(11, vo.getclave());
            
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }

    public void Modificar_ProductoVO2(ProductoVO vo){
        Conectar conec = new Conectar();
        String sql = "UPDATE regconferencistas SET  NomConferencista = ?, NomConferencia = ?,NomTaller=?, Fecha =?, Hora=?,FechaT =?, HoraT=?, Costo =?,CostoT=?\n" +
"WHERE IdConferencis = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
           
           // ps.setBytes(1, vo.getFoto());
            ps.setString(1, vo.getNombreConferencista());
            ps.setString(2, vo.getNombreConferencia());
            ps.setString(3, vo.getNombreTaller());
            ps.setString(4, vo.getFechaa());
            ps.setString(5, vo.getHoraa());  
            ps.setString(6, vo.getFechaT());
            ps.setString(7, vo.getHoraT());  
            ps.setFloat(8, vo.getCosto());
            ps.setFloat(9, vo.getCostoT());
            ps.setInt(10, vo.getclave());
            
            ps.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }

/*Metodo Eliminar*/
    public void Eliminar_ProductoVO(ProductoVO vo){
        Conectar conec = new Conectar();
        String sql = "DELETE FROM regconferencistas WHERE IdConferencis = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(2, vo.getclave());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }
}
