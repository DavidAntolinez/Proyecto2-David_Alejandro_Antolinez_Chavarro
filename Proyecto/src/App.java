
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        int opcP;
        do {
            opcP = MenuPrincipal();
            int opc;
            switch (opcP) {
                case 1:
                    ListaEstudiantes ListaEstudiantes = new ListaEstudiantes();
                    do {
                        opc = MenuEstudiantes();
                        switch (opc) {
                            case 1:
                                ListaEstudiantes.InsertarFinal();
                                break;
                            case 2:
                                if (ListaEstudiantes.getPunta() != null) {
                                    ListaEstudiantes.Mostrar();
                                } else {
                                    JOptionPane.showMessageDialog(null, "La Lista esta Vacia");
                                }
                                break;
                            case 3:
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
                                break;
                        }
                    } while (opc != 3);
                    break;
                case 2:
                    Cola C1 = new Cola(
                            Integer.parseInt(JOptionPane
                                    .showInputDialog("Bienvenido, ingrese el tamaño de la Cola a crear:\n")));
                    do {
                        opc = MenuCola();
                        switch (opc) {
                            case 1:
                                if (!C1.ColaLlena()) {
                                    C1.EnColar(Integer
                                            .parseInt(JOptionPane.showInputDialog("Ingrese el dato a Encolar:\n")));
                                } else {
                                    JOptionPane.showMessageDialog(null, "La Cola esta llena");
                                }
                                break;
                            case 2:
                                if (!C1.ColaVacia()) {
                                    JOptionPane.showMessageDialog(null, "Se a DesEncolo el dato " +
                                            C1.DesEnColar());
                                } else {
                                    JOptionPane.showMessageDialog(null, "La Cola esta vacia");
                                }
                                break;
                            case 3:
                                if (!C1.ColaLlena()) {
                                    int opc2;
                                    do {
                                        opc2 = submenu1();
                                        switch (opc2) {
                                            case 1:
                                                C1.EncolarAscendente(
                                                        Integer.parseInt(
                                                                JOptionPane.showInputDialog("ingrese un valor:")));
                                                break;
                                            case 2:
                                                C1.EncolarDescendente(
                                                        Integer.parseInt(
                                                                JOptionPane.showInputDialog("ingrese un valor:")));
                                                break;
                                            case 3:
                                                break;
                                            default:
                                                JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                                                break;
                                        }
                                    } while (opc2 != 3 && opc2 != 2 && opc2 != 1);
                                } else {
                                    JOptionPane.showMessageDialog(null, "La Cola esta llena");
                                }
                                break;
                            case 4:
                            if (!C1.ColaVacia()) {
                                int opc2;
                                do {
                                    opc2 = submenu1();
                                    switch (opc2) {
                                        case 1:
                                            C1.OrdenarAscendente();
                                            break;
                                        case 2:
                                            C1.OrdenarDescendente();
                                            break;
                                        case 3:
                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                                            break;
                                    }
                                } while (opc2 != 3 && opc2 != 2 && opc2 != 1);
                            } else {
                                JOptionPane.showMessageDialog(null, "La Cola esta Vacia");
                            }
                                break;
                            case 5:
                                if (!C1.ColaVacia()) {
                                    C1.MostrarCola();
                                } else {
                                    JOptionPane.showMessageDialog(null, "La Cola esta vacia");
                                }
                                break;
                            case 6:

                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                                break;
                        }
                    } while (opc != 6);
                    break;
                case 3:
                    Pila P1 = new Pila(
                            Integer.parseInt(JOptionPane
                                    .showInputDialog("Bienvenido, ingrese el tamaño de la pila a crear:\n")));
                    do {
                        opc = MenuPila();
                        switch (opc) {
                            case 1:
                                if (!P1.PilaLlena()) {
                                    P1.Apilar(Integer
                                            .parseInt(JOptionPane.showInputDialog("Ingrese el dato a Apilar:\n")));
                                } else {
                                    JOptionPane.showMessageDialog(null, "La Pila esta llena");
                                }
                                break;
                            case 2:
                                if (!P1.PilaVacia()) {
                                    JOptionPane.showMessageDialog(null, "Se a DesApilado el dato " +
                                            P1.DesApilar());
                                } else {
                                    JOptionPane.showMessageDialog(null, "La Pila esta vacia");
                                }
                                break;
                            case 3:
                                if (!P1.PilaLlena()) {
                                    int opc2;
                                    do {
                                        opc2 = submenu1();
                                        switch (opc2) {
                                            case 1:
                                                P1.ApilarOrdenado(
                                                        Integer.parseInt(
                                                                JOptionPane.showInputDialog("ingrese un valor:")),
                                                        "Ascendente");
                                                break;
                                            case 2:
                                                P1.ApilarOrdenado(
                                                        Integer.parseInt(
                                                                JOptionPane.showInputDialog("ingrese un valor:")),
                                                        "Descendente");
                                                break;
                                            case 3:
                                                break;
                                            default:
                                                JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                                                break;
                                        }
                                    } while (opc2 != 3 && opc2 != 2 && opc2 != 1);
                                } else {
                                    JOptionPane.showMessageDialog(null, "La Pila esta llena");
                                }
                                break;
                            case 4:
                            if (!P1.PilaVacia()) {
                                int opc2;
                                do {
                                    opc2 = submenu1();
                                    switch (opc2) {
                                        case 1:
                                            P1.OrdenarAscendente();
                                            break;
                                        case 2:
                                            P1.OrdenarDescendente();
                                            break;
                                        case 3:
                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                                            break;
                                    }
                                } while (opc2 != 3 && opc2 != 2 && opc2 != 1);
                            } else {
                                JOptionPane.showMessageDialog(null, "La Pila esta Vacia");
                            }
                                break;
                            case 5:
                                if (!P1.PilaVacia()) {
                                    P1.MostrarPila();
                                } else {
                                    JOptionPane.showMessageDialog(null, "La Pila esta vacia");
                                }
                                break;
                            case 6:

                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                                break;
                        }
                    } while (opc != 6);

                    break;
                case 4:
                    Pila p = new Pila(0);
                    p.Juego1();
                    break;
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
                    break;
            }
        } while (opcP != 5);
    }

    public static int MenuPrincipal() {
        return Integer.parseInt(JOptionPane.showInputDialog("*** Menu Principal ***\n\n"
                + "¿Que quieres hacer?\n"
                + "1. Ir Lista Estudiantes\n"// hecho
                + "2. Ir Cola\n"//hecho
                + "3. Ir Pila\n"//hecho
                + "4. Jugar Juego\n"// hecho
                + "5. Salir\n\n\n"
                + "Ingrese la opcion:"));
    }

    public static int MenuEstudiantes() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("*** Menu Lista de Estudiantes ***\n\n"
                + "1. Ingresar Estudiante\n"
                + "2. Mostrar Lista\n"
                + "3. Salir\n\n\n"
                + "Ingrese la opcion:"));
        return opc;
    }

    public static int submenu1() {
        int opc2 = Integer.parseInt(JOptionPane.showInputDialog(
                "1. Ascendente\n"
                        + "2. Descendente\n"
                        + "3. Salir\n\n\n"
                        + "Ingrese la opcion:"));
        return opc2;
    }

    static int MenuPila() {
        return Integer.parseInt(JOptionPane.showInputDialog("*** Menu Principal ***\n\n"
                + "1. Apilar\n"// hecho
                + "2. Desapilar\n"// hecho
                + "3. Apilar Ordenado\n"// hecho
                + "4. Ordenar\n"
                + "5. Mostrar Pila\n"// hecho
                + "6. Salir\n\n\n"
                + "Ingrese la opcion:"));
    }

    static int MenuCola() {
        return Integer.parseInt(JOptionPane.showInputDialog("*** Menu Principal ***\n\n"
                + "1. Encolar\n"// hecho
                + "2. DesEncolar\n"// hecho
                + "3. Encolar Ordenado\n"// hecho
                + "4. Ordenar\n"
                + "5. Mostrar Cola\n"// hecho
                + "6. Salir\n\n\n"
                + "Ingrese la opcion:"));
    }
}
