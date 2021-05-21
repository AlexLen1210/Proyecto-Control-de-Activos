
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    
    DBconexion conectar=new DBconexion();
    Connection con;
    PreparedStatement ps;
     ResultSet rs;  
    
       public int registrar(Equipo eq){
        String sql="INSERT INTO equipo(Articulo,Serie,Modelo,Marca,Precio,Cantidad,Total,Fecha,Observacion)VALUES (?,?,?,?,?,?,?,?,?)";
        try {
           con=conectar.getConnection();
           ps=con.prepareStatement(sql);
            ps.setString(1, eq.getDesc());
            ps.setInt(2, eq.getSer());
            ps.setString(3, eq.getMod());
            ps.setString(4, eq.getMarca());
            ps.setDouble(5, eq.getPun());
            ps.setInt(6, eq.getCan());
            ps.setDouble(7, eq.getTot());
            ps.setString(8, eq.getFech());
           // ps.setString(6, eq.getFech());
            ps.setString(9, eq.getObs());
            ps.executeUpdate();    
        } catch (Exception e) {
        
        }
        
    return 1;
    }
       
        public int modificar(Equipo eq){
        
        String sql="update equipo set Articulo=?, Serie=?, Modelo=?,Marca=?, Precio=?, Cantidad=?, Total=?, Fecha=?,Observacion=? where Id_equipo=?";
   
        try {
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, eq.getDesc());
            ps.setInt(2, eq.getSer());
            ps.setString(3, eq.getMod());
            ps.setString(4, eq.getMarca());
            ps.setDouble(5, eq.getPun());
            ps.setInt(6, eq.getCan());
            ps.setDouble(7, eq.getTot());
            ps.setString(8, eq.getFech());
            ps.setString(9, eq.getObs());
            ps.setInt(10, eq.getIdeq());
            ps.executeUpdate();    
        } catch (Exception e) {
        }
        return 1;
    }
        
         public void delete(int id){
         String sql="delete from equipo where Id_equipo="+id;
         try{
             con=conectar.getConnection();
             ps=con.prepareStatement(sql);
             ps.executeUpdate();
         }catch(Exception e){
             
         }
    }
            public List listar(){
       List<Equipo>datos= new ArrayList<>();
       
        String sql="SELECT * FROM equipo";
    try {
        con=conectar.getConnection();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next()){
            Equipo e=new Equipo();
            e.setIdeq(rs.getInt(1));
            e.setDesc(rs.getString(2));
            e.setSer(rs.getInt(3));
            e.setMod(rs.getString(4));     
            e.setMarca(rs.getString(5)); 
            e.setPun(rs.getDouble(6));
            e.setCan(rs.getInt(7));
            e.setTot(rs.getDouble(8));
            e.setFech(rs.getString(9));
            e.setObs(rs.getString(10));
          datos.add(e);
        }
    }catch (Exception e){
        
    }
     return datos;
    }
    
            
       public int registraruser(Usuario u){
        String sql="INSERT INTO usuario(Usuario,Contraseña,Tipo)VALUES (?,?,?)";
        try {
           con=conectar.getConnection();
           ps=con.prepareStatement(sql);
            ps.setString(1, u.getUser());
            ps.setString(2, u.getPass());
            ps.setString(3, u.getTip());
            ps.executeUpdate();    
        } catch (Exception e) {
        
        }
        
    return 1;
    }       
     
       
       public int actualizaruser(Usuario u){    
        String sql="update usuario set Usuario=?,Contraseña=?, Tipo=? where Id_usuario=?";
        try {
           con=conectar.getConnection();
           ps=con.prepareStatement(sql);
            ps.setString(1, u.getUser());
            ps.setString(2, u.getPass());
            ps.setString(3, u.getTip());
            ps.setInt(4, u.getIdus());
            ps.executeUpdate();          
        }  catch (Exception e) {
        
        }
   return 1;
       }  
       
         public List listaruser(){
       List<Usuario>datos= new ArrayList<>();
       
        String sql="SELECT * FROM usuario";
    try {
        con=conectar.getConnection();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next()){
            Usuario u=new Usuario();
            u.setIdus(rs.getInt(1));
            u.setUser(rs.getString(2));          
            u.setPass(rs.getString(3));
            u.setTip(rs.getString(4));
           
          datos.add(u);
        }
    }catch (Exception e){
        
    }
     return datos;
    }
         
          public void deleteuser(int id){
         String sql="delete from usuario where Id_usuario="+id;
         try{
             con=conectar.getConnection();
             ps=con.prepareStatement(sql);
             ps.executeUpdate();
         }catch(Exception e){
             
         }
    }
    
          public int registraremp(Empleado ep){
        String sql="INSERT INTO empleado(Nombre,Apellido,DNI,Cargo,Area)VALUES (?,?,?,?,?)";
        try {
           con=conectar.getConnection();
           ps=con.prepareStatement(sql);
            ps.setString(1, ep.getNom());
            ps.setString(2, ep.getApe());
            ps.setString(3, ep.getDni());
            ps.setString(4, ep.getCarg());
            ps.setString(5, ep.getAre());
            
            ps.executeUpdate();    
        } catch (Exception e) {
        
        }
        
    return 1;
    }       
   
            public int actualizaremp(Empleado ep){    
        String sql="update empleado set Nombre=?, Apellido=?, DNI=?, Cargo=?, Area=?  where Id_empleado=?";
        try {
           con=conectar.getConnection();
           ps=con.prepareStatement(sql);
             ps.setString(1, ep.getNom());
            ps.setString(2, ep.getApe());
            ps.setString(3, ep.getDni());
            ps.setString(4, ep.getCarg());
            ps.setString(5, ep.getAre());     
            ps.setInt(6, ep.getIdemp());
            ps.executeUpdate();          
        }  catch (Exception e) {
        
        }
   return 1;
       }  
      
              public List listaremp(){
       List<Empleado>datos= new ArrayList<>();
       
        String sql="SELECT * FROM empleado";
    try {
        con=conectar.getConnection();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next()){
            Empleado ep=new Empleado();
            ep.setIdemp(rs.getInt(1));
            ep.setNom(rs.getString(2));          
            ep.setApe(rs.getString(3));
            ep.setDni(rs.getString(4));
            ep.setCarg(rs.getString(5));
            ep.setAre(rs.getString(6));
           
           
          datos.add(ep);
        }
    }catch (Exception e){
        
    }
     return datos;
    }
    
         public void deleteemp(int id){
         String sql="delete from empleado where Id_empleado="+id;
         try{
             con=conectar.getConnection();
             ps=con.prepareStatement(sql);
             ps.executeUpdate();
         }catch(Exception e){
             
         }
    }
               
   }
          

