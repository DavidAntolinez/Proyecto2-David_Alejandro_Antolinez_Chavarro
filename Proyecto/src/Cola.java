import javax.swing.JOptionPane;

public class Cola {
    private int Limite, Tope, Vec[];

    public int getLimite() {
        return Limite;
    }

    public int getTope() {
        return Tope;
    }

    public Cola(int d) {
        Limite = d - 1;
        Tope = -1;
        Vec = new int[d];
    }

    Boolean ColaVacia() {
        return Tope == -1;
    }

    Boolean ColaLlena() {
        return Tope == Limite;
    }

    void EnColar(int d) {
        Tope++;
        Vec[Tope] = d;
    }

    int DesEnColar() {
        int dato = Vec[0];
        for (int i = 0; i < Tope; i++) {
            Vec[i] = Vec[i + 1];
        }
        Tope--;
        return dato;
    }

    int MostrarPrimero() {
        return Vec[0];
    }

    void MostrarCola() {
        String s = "";
        for (int i = Tope; i >= 0; i--) {
            int d = DesEnColar();
            s = s + "[" + d + "]";
            EnColar(d);
        }
        JOptionPane.showMessageDialog(null, s);
    }

    void PasarDatos(Cola c) {
        while (!this.ColaVacia()) {
            c.EnColar(this.DesEnColar());
        }
    }

    void EncolarAscendente(int d) {
        if (ColaVacia()) {
            EnColar(d);
        } else {
            Boolean t = true;
            for (int i = Tope; i > -1; i--) {
                if (MostrarPrimero() > d && t) {
                    EnColar(d);
                    t = false;
                }
                EnColar(DesEnColar());
            }
        }
    }

    void EncolarDescendente(int d) {
        if (ColaVacia()) {
            EnColar(d);
        } else {
            Boolean t = true;
            for (int i = Tope; i > -1; i--) {
                if (MostrarPrimero() < d && t) {
                    EnColar(d);
                    t = false;
                }
                EnColar(DesEnColar());
            }
        }
    }

    void OrdenarAscendente() {
            Cola aux = new Cola(Tope + 1);
            while (!aux.ColaLlena()) {
                int d = DesEnColar();
                for (int i = Tope; i > -1; i--){
                    if (d > MostrarPrimero()) {
                        EnColar(d);
                        d = DesEnColar();
                    }
                    EnColar(DesEnColar());
                }
                aux.EnColar(d);
            }
            aux.PasarDatos(this);
    }

    void OrdenarDescendente() {
        Cola aux = new Cola(Tope + 1);
            while (!aux.ColaLlena()) {
                int d = DesEnColar();
                for (int i = Tope; i > -1; i--){
                    if (d < MostrarPrimero()) {
                        EnColar(d);
                        d = DesEnColar();
                    }
                    EnColar(DesEnColar());
                }
                aux.EnColar(d);
            }
            aux.PasarDatos(this);
    }
}