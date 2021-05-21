
package contolador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Timer;
import modelo.DBconexion;
import vista.*;


public class Logincontroller {
   
    public Timer tiempo;
    int cont;
    public final static int TWO_SECOND=5;
    
    DBconexion conectar=new DBconexion();
    Connection con;
    PreparedStatement ps;
     ResultSet rs;  
    
     public static Ventanalogin ventana= new Ventanalogin();
    public static void mostrar(){
        ventana.setVisible(true);
    }
    public static void ocultar(){
        ventana.setVisible(false);
    }
  
 class timerListener implements ActionListener{

        public void actionPerformed(ActionEvent ae) {
           cont++;
           ventana.pgblogin.setValue(cont);
           if(cont==100){
               tiempo.stop();
              Principalcontroller.mostrar();
              limpiar();
              ocultar();
              
            }
        }
     
 }
    public void activar(){tiempo.start();}
    
  public  void ingresar(){
      String user= ventana.txtuser.getText();
       String passw= ventana.jpfpass.getText();
      
            String sql="select Usuario, Contraseña, Tipo" + " from usuario where Usuario='"+user+"'";
          try {   
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            if (rs.next()){
                String u=rs.getString("Usuario");
                String p=rs.getString("Contraseña");
                String priv=rs.getString("Tipo");
                 
                if(passw.equals(p)){
                    
                    if(priv.equals("usuario")){
                       ventana.pgblogin.setVisible(true);
                       cont=-1;
                       ventana.pgblogin.setValue(0);
                       ventana.pgblogin.setStringPainted(true);
                       tiempo= new Timer(TWO_SECOND,new timerListener());
                       activar(); 
                       Principalcontroller.invisibleboton();
                       Principalcontroller.invisiblebotonemp();

                    }else if(priv.equals("administrador")){
                       ventana.pgblogin.setVisible(true);
                       cont=-1;
                       ventana.pgblogin.setValue(0);
                       ventana.pgblogin.setStringPainted(true);
                       tiempo= new Timer(TWO_SECOND,new timerListener());
                       activar();
                        //Principalcontroller.visibleboton();
                        //Principalcontroller.visiblebotonemp();
                    }
                }else {
                     JOptionPane.showMessageDialog(null,"La contraseña o Usuario es incorrecta");
                }
                                    
            }else{
                JOptionPane.showMessageDialog(null,"El usuario no existe");
            }
            
        } catch (SQLException ex) {
           
        }  
  }  
  public static void limpiar(){
        ventana.txtuser.setText("");
        ventana.jpfpass.setText("");
  }
  
}
