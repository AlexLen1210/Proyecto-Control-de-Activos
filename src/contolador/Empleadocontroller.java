
package contolador;

import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Dao;
import modelo.Empleado;
import vista.Vistaempleado;

public class Empleadocontroller {
    
    DefaultTableModel modelo=new DefaultTableModel();
    
    public static  Vistaempleado vem= new Vistaempleado();        
    public static void mostrar(){
        vem.setVisible(true);
    }
    public static void ocultar(){
        vem.setVisible(false);
    }
    
     public static void agregar(){
           
         String nom=vem.txtnomep.getText();
          String ape=vem.txtapeemp.getText();
           String dni=vem.txtdni.getText();
           String car=vem.txtcargemp.getText();
          String ar=vem.txtareemp.getText();
         
          
     if (nom.equals("") && ape.equals("")&& dni.equals("")&& car.equals("")&& ar.equals("")){
               JOptionPane.showMessageDialog(null,"Error hay campos vacios");
          }else{                 
            Empleado e=new Empleado();
            e.setNom(nom);
            e.setApe(ape);
            e.setDni(dni);
            e.setCarg(car);
            e.setAre(ar);
           
         
             Dao d=new Dao();
            int r=d.registraremp(e);
            if (r==1){
                JOptionPane.showMessageDialog(vem,"registro agregado con exito");
                
    }else {
                 JOptionPane.showMessageDialog(vem,"Debe ingresar un Registro"); 
            }
    }
     }
     public static void editar(){
          int fila1=vem.tabla2.getSelectedRow();
          if(fila1==-1){
            JOptionPane.showMessageDialog(vem,"Debe seleccionar una fila");
          }else {
         int id=Integer.parseInt(vem.txtidemp.getText());
         String nom=vem.txtnomep.getText();
          String ape=vem.txtapeemp.getText();
           String dni=vem.txtdni.getText();
           String car=vem.txtcargemp.getText();
          String ar=vem.txtareemp.getText();
                   
            Empleado e=new Empleado();
            e.setNom(nom);
            e.setApe(ape);
            e.setDni(dni);
            e.setCarg(car);
            e.setAre(ar);
            
            e.setIdemp(id);
             Dao d=new Dao();
            int r=d.actualizaremp(e);
                    if (r==1){
                  JOptionPane.showMessageDialog(vem,"Datos actuializados con extito ");
                
    }else {
                 JOptionPane.showMessageDialog(vem,"Debe ingresar un Registro"); 
            }
    }
     }
     
       public  void listar(JTable tabla){
          modelo=(DefaultTableModel)tabla.getModel();
          
          modelo.setNumRows(0);
          Dao d=new Dao();
       List<Empleado>lista=d.listaremp();
       Object[]Object=new Object[6];
       for (int i=0;i<lista.size();i++){
           Object[0]=lista.get(i).getIdemp();
           Object[1]=lista.get(i).getNom();
           Object[2]=lista.get(i).getApe();
           Object[3]=lista.get(i).getDni();
           Object[4]=lista.get(i).getCarg();
           Object[5]=lista.get(i).getAre();
           
           modelo.addRow(Object);
       }
       vem.tabla2.setModel(modelo);
   
     }
       
        public static void eliminar(){
           Dao d=new Dao();
            int fila=vem.tabla2.getSelectedRow();
       if (fila==-1){
           JOptionPane.showMessageDialog(vem,"Debe seleccionar una fila");
            
       }else{
            int id=Integer.parseInt((String)vem.tabla2.getValueAt(fila, 0).toString());
           d.deleteemp(id);
            JOptionPane.showMessageDialog(vem,"Registro eliminado");
       }
    }
        
         public static void mouseClicked(MouseEvent me) {
               
               int select=vem.tabla2.rowAtPoint(me.getPoint());
                vem.txtidemp.setText(String.valueOf(vem.tabla2.getValueAt(select, 0)));
               vem.txtnomep.setText(String.valueOf(vem.tabla2.getValueAt(select,1)));
                vem.txtapeemp.setText(String.valueOf(vem.tabla2.getValueAt(select,2)));
                vem.txtdni.setText(String.valueOf(vem.tabla2.getValueAt(select,3)));
                vem.txtcargemp.setText(String.valueOf(vem.tabla2.getValueAt(select,4)));
                vem.txtareemp.setText(String.valueOf(vem.tabla2.getValueAt(select,5)));
              
            }
         
         
          public static void limpiar(){
        vem.txtnomep.setText("");
        vem.txtapeemp.setText("");
        vem.txtdni.setText("");
        vem.txtcargemp.setText("");
        vem.txtareemp.setText("");
       
              
}
}