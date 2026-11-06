package pkg23630177_03;
    public class Mueble {
    int ID;
    String Modelo;
    int Cantidad;
    float Precio;
    String Tama;

    public Mueble(int ID, String Nombre, int Cantidad, float Precio, String Tama) {
        this.ID = ID;
        this.Modelo = Nombre;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.Tama = Tama;
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
    
    
    }
