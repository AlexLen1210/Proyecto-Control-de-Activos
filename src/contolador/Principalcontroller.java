
package contolador;
import vista.*;

public class Principalcontroller {
    public static Vistaprincipal vista= new Vistaprincipal();
    public static void mostrar(){
        vista.setVisible(true);
    }
    public static void ocultar(){
        vista.setVisible(false);
    }
    
    public static void inventario(){
        ocultar();
        Equipocontroller.mostrar();
    }
     public static void usuario(){
        ocultar();
        Usuariocontroller.mostrar();
    }
    
      public static void invisibleboton(){
          vista.btnusuario.setVisible(false);
      }
     public static void visibleboton(){
          vista.btnusuario.setVisible(true);
      }
     
     public static void invisiblebotonemp(){
          vista.btnempleado.setVisible(false);
      }

     public static void visiblebotonemp(){
          vista.btnempleado.setVisible(true);
      }

}
