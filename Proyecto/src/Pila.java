import javax.swing.JOptionPane;
import java.util.Scanner;

public class Pila {
    private int Limite, Tope, Vec[];

    public int getLimite() {
        return Limite;
    }

    public int getTope() {
        return Tope;
    }

    public Pila(int d) {
        Limite = d - 1;
        Tope = -1;
        Vec = new int[d];
    }

    public Boolean PilaVacia() {
        return Tope == -1;
    }

    Boolean PilaLlena() {
        return Tope == Limite;
    }

    void Apilar(int d) {
        Tope++;
        Vec[Tope] = d;
    }

    int DesApilar() {
        Tope--;
        return Vec[Tope + 1];
    }

    int MostrarTope() {
        return Vec[Tope];
    }

    void PasarDatos(Pila P) {
        while (!this.PilaVacia()) {
            P.Apilar(this.DesApilar());
        }
    }

    void MostrarPila() {
        Pila aux = new Pila(Tope + 1);
        String s = "";
        while (!PilaVacia() && !aux.PilaLlena()) {
            int d = DesApilar();
            s = s + "\n[" + d + "]";
            aux.Apilar(d);
        }
        aux.PasarDatos(this);
        JOptionPane.showMessageDialog(null, s);
    }

    void ApilarOrdenado(int d, String t) {
        Pila aux = new Pila(Tope + 1);
        if (t == "Ascendente") {
            while (!PilaVacia() && MostrarTope() > d) {
                aux.Apilar(DesApilar());
            }
        } else {
            while (!PilaVacia() && MostrarTope() < d) {
                aux.Apilar(DesApilar());
            }
        }
        Apilar(d);
        aux.PasarDatos(this);

    }

    void OrdenarAscendente() {
        Pila aux1 = new Pila(Tope + 1);
        int d = Tope;
        PasarDatos(aux1);
        while (d > Tope) {
            Apilar(aux1.datomenor());
        }
    }

    void OrdenarDescendente() {
        Pila aux1 = new Pila(Tope + 1);
        int d = Tope;
        PasarDatos(aux1);
        while (d > Tope) {
            Apilar(aux1.datomayor());
        }
    }

    int datomenor() {
        Pila aux = new Pila(Tope + 1);
        int menor = DesApilar();
        while (!PilaVacia()) {
            if (MostrarTope() < menor) {
                aux.Apilar(menor);
                menor = DesApilar();
            } else {
                aux.Apilar(DesApilar());
            }
        }
        aux.PasarDatos(this);
        return menor;
    }

    int datomayor() {
        Pila aux = new Pila(Tope + 1);
        int menor = DesApilar();
        while (!PilaVacia()) {
            if (MostrarTope() > menor) {
                aux.Apilar(menor);
                menor = DesApilar();
            } else {
                aux.Apilar(DesApilar());
            }
        }
        aux.PasarDatos(this);
        return menor;
    }

    void Juego1() {
        Scanner t = new Scanner(System.in);
        int n;
        do {
            Pila P1 = new Pila(4);
            Pila P2 = new Pila(4);
            Pila P3 = new Pila(4);
            while (!P1.PilaLlena()) {
                P1.Apilar(1);
                P1.Apilar(2);
            }
            while (!P2.PilaLlena()) {
                P2.Apilar(2);
                P2.Apilar(1);
            }
            System.out.println("Bienvenido, quieres ver las instrucciones del juego?\n 1)Si\n 2)No");
            int r = t.nextInt();
            if (r == 1) {
                System.out.println(
                        "El juego se trata de organizar todos los 1 en la pila de la izquierda y todos los 2 en la de la derecha \npara ello puedes agarrar los numeros que estan en el tope de las pilas\n y moverlos a otras pilas, los 0 significan que no hay numero con dos condiciones, 1.No puedes pasar un numero a una pila llena,\n 2.Solo puedes pasar un numero a otra pila si y solo si la pila esta vacia o el mismo numero esta en el tope de esa pila.");
            }
            Boolean ganar;
            String R;
            do {
                System.out.println(
                        MostrarJuego(P1, P2, P3) + "\n¿que quieres hacer?"
                                + "\npara mover un numero, escriba desde que pila hasta que pila, ejemplo: P1P2, tambien te puedes rendir escribiendo: SoyTonto");
                R = t.next();
                if (R.equals("P1P2")) {
                    if (P1.MIlegal(P2)) {
                        System.out.println("Movimiento Ilegal");
                    } else {
                        P2.Apilar(P1.DesApilar());
                    }
                } else if (R.equals("P1P3")) {
                    if (P1.MIlegal(P3)) {
                        System.out.println("Movimiento Ilegal");
                    } else {
                        P3.Apilar(P1.DesApilar());
                    }
                } else if (R.equals("P2P1")) {
                    if (P2.MIlegal(P1)) {
                        System.out.println("Movimiento Ilegal");
                    } else {
                        P1.Apilar(P2.DesApilar());
                    }
                } else if (R.equals("P2P3")) {
                    if (P2.MIlegal(P3)) {
                        System.out.println("Movimiento Ilegal");
                    } else {
                        P3.Apilar(P2.DesApilar());
                    }
                } else if (R.equals("P3P1")) {
                    if (P3.MIlegal(P1)) {
                        System.out.println("Movimiento Ilegal");
                    } else {
                        P1.Apilar(P3.DesApilar());
                    }
                } else if (R.equals("P3P2")) {
                    if (P3.MIlegal(P2)) {
                        System.out.println("Movimiento Ilegal");
                    } else {
                        P2.Apilar(P3.DesApilar());
                    }
                } else {
                    System.out.println("Al momento de ingresar su movimiento imite al ejemplo");
                }
                ganar = Ganar(P1, P2, P3);
                System.out.println("\033[H\033[2J");
                System.out.flush();
            } while (!ganar && !R.equals("SoyTonto"));
            if (ganar) {
                System.out.println(
                        "\nFELICIDADES!!!!!!!!!!! GANASTE!!!!\n\nsi quieres repetir el juego ingresa 1, de lo contrario ingresa cualquier otro numero.");
            } else {
                System.out.println(
                        "\nque perdedor\n\nsi quieres repetir el juego ingresa 1, de lo contrario ingresa cualquier otro numero.");
            }
            n = t.nextInt();
        } while (n == 1);
    }

    static String MostrarJuego(Pila p1, Pila p2, Pila p3) {
        Pila aux1 = new Pila(4);
        Pila aux2 = new Pila(4);
        Pila aux3 = new Pila(4);
        String s = "";
        int dif1 = 4 - (p1.getTope() + 1);
        int dif2 = 4 - (p2.getTope() + 1);
        int dif3 = 4 - (p3.getTope() + 1);
        for (int i = 1; i <= 4; i++) {
            int d1, d2, d3;
            if (dif1 == 0) {
                d1 = p1.DesApilar();
                aux1.Apilar(d1);
            } else {
                d1 = 0;
                dif1--;
            }
            if (dif2 == 0) {
                d2 = p2.DesApilar();
                aux2.Apilar(d2);
            } else {
                d2 = 0;
                dif2--;
            }
            if (dif3 == 0) {
                d3 = p3.DesApilar();
                aux3.Apilar(d3);
            } else {
                d3 = 0;
                dif3--;
            }
            s = s + "\n[" + d1 + "] " + " [" + d2 + "] " + " [" + d3 + "]";
        }
        aux1.PasarDatos(p1);
        aux2.PasarDatos(p2);
        aux3.PasarDatos(p3);
        return s;
    }

    Boolean Ganar(Pila p1, Pila p2, Pila p3) {
        Pila aux1 = new Pila(p1.Tope + 1);
        Pila aux2 = new Pila(p2.Tope + 1);
        Pila aux3 = new Pila(p3.Tope + 1);
        aux1.CopiarPila(p1);
        aux2.CopiarPila(p2);
        aux3.CopiarPila(p3);
        Boolean igual1, igual2, igual3, gano = false;
        igual1 = aux1.Compprobacion();
        igual2 = aux2.Compprobacion();
        igual3 = aux3.Compprobacion();
        if (igual1 == true && igual2 == true && igual3 == false) {
            gano = true;
        } else if (igual1 == true && igual2 == false && igual3 == true) {
            gano = true;
        } else if (igual1 == false && igual2 == true && igual3 == true) {
            gano = true;
        }
        return gano;
    }

    Boolean Compprobacion() {
        int uno = 0, dos = 0;
        while (!PilaVacia()) {
            int d = DesApilar();
            if (d == 1) {
                uno++;
            } else {
                dos++;
            }
        }
        return uno == 4 || dos == 4;
    }

    Boolean MIlegal(Pila p) {
        Boolean t;
        if (p.PilaVacia()) {
            t = this.PilaVacia();
        } else {
            t = this.PilaVacia() || p.PilaLlena() || this.MostrarTope() != p.MostrarTope();
        }
        return t;
    }

    void CopiarPila(Pila p) {
        Pila aux = new Pila(p.Tope + 1);
        p.PasarDatos(aux);
        while (!PilaLlena()) {
            int d = aux.DesApilar();
            p.Apilar(d);
            Apilar(d);
        }
    }

}
