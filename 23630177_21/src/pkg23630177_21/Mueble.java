package pkg23630177_21;
    public class Mueble {
    int ID;
    String Modelo;
    int Cantidad;
    float Precio;
    String Tama;
    Mueble HijoDerecho;
    Mueble HijoIzquierdo;
    
    public Mueble(int ID, String Modelo, int Cantidad, float Precio, String Tama,Mueble HijoDerecho,Mueble HijoIzquierdo) {
        this.ID = ID;
        this.Modelo = Modelo;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.Tama = Tama;
        this.HijoDerecho=HijoDerecho;
        this.HijoIzquierdo=HijoIzquierdo;
    }

    public Mueble() {
        this.ID = 0;
        this.Modelo ="*";
        this.Cantidad =0;
        this.Precio = 0;
        this.Tama ="*";
        this.HijoDerecho=null;
        this.HijoIzquierdo=null;
    }
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public String getTama() {
        return Tama;
    }

    public void setTama(String Tama) {
        this.Tama = Tama;
    }

    public Mueble getHijoDerecho() {
        return HijoDerecho;
    }

    public void setHijoDerecho(Mueble HijoDerecho) {
        this.HijoDerecho = HijoDerecho;
    }

    public Mueble getHijoIzquierdo() {
        return HijoIzquierdo;
    }

    public void setHijoIzquierdo(Mueble HijoIzquierdo) {
        this.HijoIzquierdo = HijoIzquierdo;
    }

    
    
    }
