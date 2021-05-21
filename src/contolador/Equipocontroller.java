
package contolador;

import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Dao;
import modelo.Equipo;
import vista.*;
public class Equipocontroller  {
    
   DefaultTableModel modelo=new DefaultTableModel();
  
    public static  Vistaequipo ve= new Vistaequipo();        
    public static void mostrar(){
        ve.setVisible(true);
    }
    public static void ocultar(){
        ve.setVisible(false);
    }
    
    public static void agregar(){
         String nom=ve.txtdesc.getText();
         int  ser=Integer.parseInt(ve.txtserie.getText());
          String mod=ve.txtmodel.getText();
          String marca=ve.txtmarc.getText();
           Double pre=Double.parseDouble(ve.txtpre.getText());
           int can=Integer.parseInt(ve.spcant.getValue().toString());
           double total=pre*can;
           int año=ve.jdcfech.getCalendar().get(Calendar.YEAR);
           int mes=ve.jdcfech.getCalendar().get(Calendar.MONTH);
           int dia=ve.jdcfech.getCalendar().get(Calendar.DAY_OF_MONTH);
           String fecha=año+"-"+mes+"-"+dia;
            String obs=ve.txtobs.getText();
            
            Equipo e=new Equipo();
            e.setDesc(nom);
            e.setSer(ser);
            e.setMod(mod);
            e.setMarca(marca);
            e.setPun(pre);
            e.setCan(can);
            e.setTot(total);
            e.setFech(fecha);           
            e.setObs(obs);
             Dao d=new Dao();
            int r=d.registrar(e);
            if (r==1){
                JOptionPane.showMessageDialog(ve,"registro agregado con exito");
                
    }else {
                 JOptionPane.showMessageDialog(ve,"Debe ingresar un Registro"); 
            }
    }
    
    
    public static void limpiar(){
        ve.txtdesc.setText("");
        ve.txtserie.setText("");
        ve.txtmodel.setText("");
        ve.txtmarc.setText("");
        ve.txtpre.setText("");
        ve.txtobs.setText("");
        
    }
    
     public static void editar(){
          int fila1=ve.tabla.getSelectedRow();
          if(fila1==-1){
            JOptionPane.showMessageDialog(ve,"Debe seleccionar una fila");
          }else{
         int id=Integer.parseInt(ve.txtid.getText());
            String nom=ve.txtdesc.getText();
         int  ser=Integer.parseInt(ve.txtserie.getText());
          String mod=ve.txtmodel.getText();
          String marca=ve.txtmarc.getText();
           Double pre=Double.parseDouble(ve.txtpre.getText());
           int can=Integer.parseInt(ve.spcant.getValue().toString());
           double total=pre*can;
           int año=ve.jdcfech.getCalendar().get(Calendar.YEAR);
           int mes=ve.jdcfech.getCalendar().get(Calendar.MONTH);
           int dia=ve.jdcfech.getCalendar().get(Calendar.DAY_OF_MONTH);
           String fecha=año+"-"+mes+"-"+dia;
            String obs=ve.txtobs.getText();
           Equipo e=new Equipo();
             e.setDesc(nom);
            e.setSer(ser);
            e.setMod(mod);
            e.setMarca(marca);
            e.setPun(pre);
            e.setCan(can);
            e.setTot(total);
            e.setFech(fecha);           
            e.setObs(obs);
            e.setIdeq(id);
            Dao d=new Dao();
       int r= d.modificar(e);
        if(r==1){
            JOptionPane.showMessageDialog(ve,"Datos actuializados con extito ");
            
        }else {
            JOptionPane.showMessageDialog(ve,"Debe seleccionar una fila ");
        }
        
    }
   }  
      public  void listar(JTable tabla){
          modelo=(DefaultTableModel)tabla.getModel();
          
          modelo.setNumRows(0);
          Dao d=new Dao();
       List<Equipo>lista=d.listar();
       Object[]Object=new Object[10];
       for (int i=0;i<lista.size();i++){
           Object[0]=lista.get(i).getIdeq();
           Object[1]=lista.get(i).getDesc();
           Object[2]=lista.get(i).getSer();
           Object[3]=lista.get(i).getMod();
           Object[4]=lista.get(i).getMarca();
           Object[5]=lista.get(i).getPun();
           Object[6]=lista.get(i).getCan();
           Object[7]=lista.get(i).getTot();
           Object[8]=lista.get(i).getFech();
           Object[9]=lista.get(i).getObs();
           modelo.addRow(Object);
       }
       ve.tabla.setModel(modelo);
   
     }
      
       public static void eliminar(){
           Dao d=new Dao();
            int fila=ve.tabla.getSelectedRow();
       if (fila==-1){
           JOptionPane.showMessageDialog(ve,"Debe seleccionar una fila");
            
       }else{
            int id=Integer.parseInt((String)ve.tabla.getValueAt(fila, 0).toString());
           d.delete(id);
            JOptionPane.showMessageDialog(ve,"Registro eliminado");
       }
    }
      
    public static void mouseClicked(MouseEvent me) {
               
               int select=ve.tabla.rowAtPoint(me.getPoint());
                ve.txtid.setText(String.valueOf(ve.tabla.getValueAt(select, 0)));
               ve.txtdesc.setText(String.valueOf(ve.tabla.getValueAt(select,1)));
                ve.txtserie.setText(String.valueOf(ve.tabla.getValueAt(select,2)));
                ve.txtmodel.setText(String.valueOf(ve.tabla.getValueAt(select,3)));
                ve.txtmarc.setText(String.valueOf(ve.tabla.getValueAt(select,4)));
                ve.txtpre.setText(String.valueOf(ve.tabla.getValueAt(select,5)));
                ve.txtobs.setText(String.valueOf(ve.tabla.getValueAt(select,6)));      
            }
              
}
