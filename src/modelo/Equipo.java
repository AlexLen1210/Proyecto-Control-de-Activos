
package modelo;


public class Equipo {
     public int ideq,ser,can=0;
    public String  desc,mod,fech,obs,marca; 
    public Double pun,tot;
       
    public Equipo() {
    }

    public Equipo(int ideq, int ser, String desc, String mod, String fech, String obs, String marca, Double pun, Double tot) {
        this.ideq = ideq;
        this.ser = ser;
        this.desc = desc;
        this.mod = mod;
        this.fech = fech;
        this.obs = obs;
        this.marca = marca;
        this.pun = pun;
        this.tot = tot;
    }

    public int getIdeq() {
        return ideq;
    }

    public void setIdeq(int ideq) {
        this.ideq = ideq;
    }

    public int getSer() {
        return ser;
    }

    public void setSer(int ser) {
        this.ser = ser;
    }

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can = can;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMod() {
        return mod;
    }

    public void setMod(String mod) {
        this.mod = mod;
    }

    public String getFech() {
        return fech;
    }

    public void setFech(String fech) {
        this.fech = fech;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPun() {
        return pun;
    }

    public void setPun(Double pun) {
        this.pun = pun;
    }

    public Double getTot() {
        return tot;
    }

    public void setTot(Double tot) {
        this.tot = tot;
    }

   

  
    
    
}
