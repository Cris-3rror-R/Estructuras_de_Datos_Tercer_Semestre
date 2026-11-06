package pkg23630177_12;
    public class Mueble {
        int ID;
        String Modelo;
        int Cantidad;
        float Precio;
        String Tama;
        Mueble Proximo;

    public Mueble(int ID, String Modelo, int Cantidad, float Precio, String Tama, Mueble Proximo) {
        this.ID = ID;
        this.Modelo = Modelo;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.Tama = Tama;
        this.Proximo = Proximo;
    }
    public Mueble() {
        this.ID = 0;
        this.Modelo ="*";
        this.Cantidad = 0;
        this.Precio = 0;
        this.Tama ="*";
        this.Proximo = null;
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

    public Mueble getProximo() {
        return Proximo;
    }

    public void setProximo(Mueble Proximo) {
        this.Proximo = Proximo;
    }
    
    }
