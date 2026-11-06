package pkg23630177_24;
    public class Nodo {
    int Dato;
    Nodo HijoDerecho;
    Nodo HijoIzquierdo;
    
    public Nodo(int Dato,Nodo HijoDerecho,Nodo HijoIzquierdo) {
        this.Dato = Dato;
        this.HijoDerecho=HijoDerecho;
        this.HijoIzquierdo=HijoIzquierdo;
    }

    public Nodo() {
        this.Dato =0;
        this.HijoDerecho=null;
        this.HijoIzquierdo=null;
    }

    public int getDato() {
        return Dato;
    }

    public void setDato(int Dato) {
        this.Dato = Dato;
    }
    
    public Nodo getHijoDerecho() {
        return HijoDerecho;
    }

    public void setHijoDerecho(Nodo HijoDerecho) {
        this.HijoDerecho = HijoDerecho;
    }

    public Nodo getHijoIzquierdo() {
        return HijoIzquierdo;
    }

    public void setHijoIzquierdo(Nodo HijoIzquierdo) {
        this.HijoIzquierdo = HijoIzquierdo;
    }

    
    
    }
