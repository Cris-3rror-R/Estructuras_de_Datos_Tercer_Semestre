package pkg23630177_19;
    public class Mueble {
        int ID;
        String Modelo;
        int Cantidad;
        float Precio;
        String Tama;
        Mueble Derecha;
        Mueble Izquierda;
        

    public Mueble(int ID, String Modelo, int Cantidad, float Precio, String Tama, Mueble Derecha,Mueble Izquierda) {
        this.ID = ID;
        this.Modelo = Modelo;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.Tama = Tama;
        this.Derecha= Derecha;
        this.Izquierda = Izquierda;
    }
    public Mueble() {
        this.ID = 0;
        this.Modelo ="*";
        this.Cantidad = 0;
        this.Precio = 0;
        this.Tama ="*";
        this.Derecha = null;
        this.Izquierda = null;
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

    public Mueble getDerecha() {
        return Derecha;
    }

    public void setDerecha(Mueble Derecha) {
        this.Derecha = Derecha;
    }

    public Mueble getIzquierda() {
        return Izquierda;
    }

    public void setIzquierda(Mueble Izquierda) {
        this.Izquierda = Izquierda;
    }
    
    
    }
