package pkg23630177_18;
    public class Mueble {
    int ID;
    String Modelo;
    int Cantidad;
    float Precio;
    String Tama;
    String Derecha;
    String Izquierda;
    
    public Mueble(int ID, String Modelo, int Cantidad, float Precio, String Tama,String Derecha,String Izquierda) {
        this.ID = ID;
        this.Modelo = Modelo;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.Tama = Tama;
        this.Derecha=Derecha;
        this.Izquierda=Izquierda;
    }

    public Mueble() {
        this.ID = 0;
        this.Modelo ="*";
        this.Cantidad =0;
        this.Precio = 0;
        this.Tama ="*";
        this.Derecha="-1";
        this.Izquierda="-1";
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

    public String getDerecha() {
        return Derecha;
    }

    public void setDerecha(String Derecha) {
        this.Derecha = Derecha;
    }

    public String getIzquierda() {
        return Izquierda;
    }

    public void setIzquierda(String Izquierda) {
        this.Izquierda = Izquierda;
    }
    
    
    }
