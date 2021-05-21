
package contolador;

import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Dao;
import modelo.Usuario;
import vista.*;


public class Usuariocontroller {
    
    DefaultTableModel modelo=new DefaultTableModel();
    
      public static  Vistausuario vu= new Vistausuario();        
    public static void mostrar(){
        vu.setVisible(true);
    }
    public static void ocultar(){
        vu.setVisible(false);
    }
    
     public static void agregar(){
         
          String usu=vu.txtuser.getText();
          String pass=vu.pscontra1.getText();
          String pass1=vu.pscontra2.getText();
           String tip=vu.txttip.getText();
          
          if (usu.equals("") && pass.equals("")&& pass1.equals("")&& tip.equals("")){
               JOptionPane.showMessageDialog(null,"Error hay campos vacios");
          }else {
            Usuario u=new Usuario();
            u.setUser(usu);
            u.setPass(pass);
            u.setTip(tip);
             Dao d=new Dao();
  
            int r=d.registraruser(u);
            if (r==1){
                JOptionPane.showMessageDialog(null,"registro agregado con exito");
                
    }else {
                 JOptionPane.showMessageDialog(null,"Debe ingresar un Registro"); 
            }
    }
     }
   
      public  void listar(JTable tabla){
          modelo=(DefaultTableModel)tabla.getModel();
          
          modelo.setNumRows(0);
          Dao d=new Dao();
       List<Usuario>lista=d.listaruser();
       Object[]Object=new Object[4];
       for (int i=0;i<lista.size();i++){
           Object[0]=lista.get(i).getIdus();
           Object[1]=lista.get(i).getUser();
           Object[2]=lista.get(i).getPass();
           Object[3]=lista.get(i).getTip();         
           modelo.addRow(Object);
       }
       vu.tabla1.setModel(modelo);
   
     }
     
         public static void editar(){
           int fila=vu.tabla1.getSelectedRow();
           if (fila==-1){
                JOptionPane.showMessageDialog(vu,"Debe seleccionar una fila");
           }else {
         int id=Integer.parseInt(vu.txtidus.getText());
          String usu=vu.txtuser.getText();
          String pass=vu.pscontra1.getText();
          String tipo=vu.txttip.getText();
            Usuario u=new Usuario();
            u.setIdus(id);
            u.setUser(usu);
            u.setPass(pass);
            u.setTip(tipo);
             Dao d=new Dao();
            int r=d.actualizaruser(u);
            if (r==1){
                JOptionPane.showMessageDialog(null,"Datos actuializados con extito");
                
    }else {
                 JOptionPane.showMessageDialog(null,"Debe ingresar un Registro"); 
            }
    }
         }
         public static void limpiar(){
        vu.txtidus.setText("");
        vu.txtuser.setText("");
        vu.pscontra1.setText("");
         vu.pscontra2.setText("");
         vu.txttip.setText("");
}
         
      public static void mouseClicked(MouseEvent me) {
               
               int select=vu.tabla1.rowAtPoint(me.getPoint());
                vu.txtidus.setText(String.valueOf(vu.tabla1.getValueAt(select, 0)));
                vu.txtuser.setText(String.valueOf(vu.tabla1.getValueAt(select,1)));
                vu.pscontra1.setText(String.valueOf(vu.tabla1.getValueAt(select,2)));
                vu.pscontra2.setText(String.valueOf(vu.tabla1.getValueAt(select,2)));   
                vu.txttip.setText(String.valueOf(vu.tabla1.getValueAt(select,3)));
            }
                  
        public static void eliminar(){
           Dao d=new Dao();
            int fila1=vu.tabla1.getSelectedRow();
       if (fila1==-1){
           JOptionPane.showMessageDialog(vu,"Debe seleccionar una fila");
            
       }else{
            int id=Integer.parseInt((String)vu.tabla1.getValueAt(fila1, 0).toString());
           d.deleteuser(id);
            JOptionPane.showMessageDialog(vu,"Registro eliminado");
       }
    }   
         
}