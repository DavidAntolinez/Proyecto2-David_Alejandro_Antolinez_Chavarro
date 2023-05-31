import javax.swing.JOptionPane;

//import javax.swing.JOptionPane;

public class PilaNotas {
    private int Limite, Tope, Vec[];

    public int getLimite() {
        return Limite;
    }

    public int getTope() {
        return Tope;
    }

    public PilaNotas() {
        Limite = 3;
        Tope = -1;
        Vec = new int[4];
    }

    Boolean PilaVacia() {
        return Tope == -1;
    }

    Boolean PilaLlena() {
        return Tope == Limite;
    }

    void Apilar(int d) {
        Tope++;
        Vec[Tope] = d;
    }

    void Llenar(){
        for(int i = 1;i<=4;i++){
            Apilar(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Nota Núnemro: "+i)));
        }
    }

    int DesApilar() {
        Tope--;
        return Vec[Tope + 1];
    }

    int MostrarTope() {
        return Vec[Tope];
    }

    void PasarDatos(PilaNotas P) {
        while (!this.PilaVacia()) {
            P.Apilar(this.DesApilar());
        }
    }
    int Promedio(){
        PilaNotas aux = new PilaNotas();
        PasarDatos(aux);
        int b = 0;
        int d;
        while(!PilaLlena()){
            d = aux.DesApilar();
            Apilar(d);
            b = b + d;
        }
        return b/4;
    }

    String Aprobo(int d) {
        if (d >= 3) {
            return "Aprobo";
        } else {
            return "No Aprobo";
        }
    }

}
