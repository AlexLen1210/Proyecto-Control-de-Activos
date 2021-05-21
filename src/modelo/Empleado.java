
package modelo;

public class Empleado {
   int idemp,idus,ideq;
   String nom,ape,carg,are,dni;

    public Empleado() {
    }

    public Empleado(int idemp, int idus, int ideq, String nom, String ape, String carg, String are, String dni) {
        this.idemp = idemp;
        this.idus = idus;
        this.ideq = ideq;
        this.nom = nom;
        this.ape = ape;
        this.carg = carg;
        this.are = are;
        this.dni = dni;
    }

    public int getIdemp() {
        return idemp;
    }

    public void setIdemp(int idemp) {
        this.idemp = idemp;
    }

    public int getIdus() {
        return idus;
    }

    public void setIdus(int idus) {
        this.idus = idus;
    }

    public int getIdeq() {
        return ideq;
    }

    public void setIdeq(int ideq) {
        this.ideq = ideq;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public String getCarg() {
        return carg;
    }

    public void setCarg(String carg) {
        this.carg = carg;
    }

    public String getAre() {
        return are;
    }

    public void setAre(String are) {
        this.are = are;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    

    
   
    
   
}
