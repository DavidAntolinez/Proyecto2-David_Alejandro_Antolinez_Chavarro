import javax.swing.JOptionPane;

public class ListaEstudiantes {
    private NodoLista Punta, Fin;

    public ListaEstudiantes() {
        Punta = null;
        Fin = null;
    }

    public NodoLista getPunta() {
        return Punta;
    }

    public void setPunta(NodoLista punta) {
        Punta = punta;
    }

    public NodoLista getFin() {
        return Fin;
    }

    public void setFin(NodoLista fin) {
        Fin = fin;
    }

    void InsertarFinal() {
        String apellido, carrera, cedula, nombre;
        nombre = JOptionPane.showInputDialog("Ingrese El Nombre del Estudiante");
        apellido = JOptionPane.showInputDialog("Ingrese El Apellido del Estudiante");
        cedula = JOptionPane.showInputDialog("Ingrese La Cedula del Estudiante");
        carrera = JOptionPane.showInputDialog("Ingrese La Carrera del Estudiante");
        NodoLista p = new NodoLista(apellido, carrera, cedula, nombre);
        p.getMateria().EnColarI();
        if (Punta == null) {
            Punta = p;
            Fin = p;
        } else {
            Fin.setLiga(p);
            Fin = p;
        }
    }

    void Mostrar() {
        NodoLista p = Punta;
        int i = 1, j = 1;
        String s = "";
        while (p != null) {
            s = "Estudiante " + i + "\n Nombre: " + p.getNombre() + "\nApellido: " + p.getApellido() + "\nCedula: "
                    + p.getCedula() + "\nCarrera: " + p.getCarrera();
            NodoCola x = p.getMateria().DesEnColar();
            do {
                s = s + "\nMateria " + j + ": " + x.getMateria() + " Promedio: " + x.getNotas().Promedio() + " "
                        + x.getNotas().Aprobo(x.getNotas().Promedio());
                j++;
                p.getMateria().Encolar(x);
                x = p.getMateria().DesEnColar();
            } while (x != p.getMateria().getPunta());
            p = p.getLiga();
            i++;
        }
        JOptionPane.showMessageDialog(null, s);
    }

}
