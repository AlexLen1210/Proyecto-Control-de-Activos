
package modelo;


public class Usuario {
    int idus;
    String user,pass,tip;

    public Usuario() {
    }

    public Usuario(int idus, String user, String pass, String tip) {
        this.idus = idus;
        this.user = user;
        this.pass = pass;
        this.tip = tip;
    }

    public int getIdus() {
        return idus;
    }

    public void setIdus(int idus) {
        this.idus = idus;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

   

    
  
}
