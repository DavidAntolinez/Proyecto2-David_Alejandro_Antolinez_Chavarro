import javax.swing.JOptionPane;

public class ColaMaterias {
    private NodoCola Punta, Fin;

    public ColaMaterias() {
        Punta = null;
        Fin = null;
    }

    public NodoCola getPunta() {
        return Punta;
    }

    public void setPunta(NodoCola punta) {
        Punta = punta;
    }

    public NodoCola getFin() {
        return Fin;
    }

    public void setFin(NodoCola fin) {
        Fin = fin;
    }

    NodoCola MostrarPrimero(){
        return Punta;
    }

    void EnColarI() {
        int opc = 1, i = 1;
        do {
            if (i <= 1) {
                Encolar(i);
            } else {
                opc = SubMenu1();
                switch (opc) {
                    case 1:
                        Encolar(i);
                        break;
                    case 2:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
                        break;
                }
            }
            i++;
        } while (opc != 2);
    }

    void Encolar(int i) {
        NodoCola x = new NodoCola(JOptionPane.showInputDialog("Ingrese El Nombre de la Materia Numero " + i));
        x.getNotas().Llenar();
        if (Punta == null) {
            Punta = x;
            Fin = x;
        } else {
            Fin.setLiga(x);
            Fin = x;
        }
    }

    void Encolar(NodoCola x) {
        if (Punta == null) {
            Punta = x;
            Fin = x;
        } else {
            Fin.setLiga(x);
            Fin = x;
        }
    }

    NodoCola DesEnColar() {
        NodoCola p = Punta;
        if (Punta == Fin) {
            Fin = null;
            Punta = null;
        }
        Punta = p.getLiga();
        p.setLiga(null);
        return p;
    }

    int SubMenu1() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("*** Menu Principal ***\n\n"
                + "1. Ingresar Más materias\n"
                + "2. Salir\n\n\n"
                + "Ingrese la opcion:"));
        return opc;
    }

}
