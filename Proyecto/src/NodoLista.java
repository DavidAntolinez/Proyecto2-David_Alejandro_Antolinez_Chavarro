public class NodoLista {
    private String Apellido, Carrera, Cedula, Nombre;
    private ColaMaterias Materias;
    private NodoLista Liga;

    

    
    public NodoLista(String apellido, String carrera, String cedula, String nombre) {
        Apellido = apellido;
        Carrera = carrera;
        Cedula = cedula;
        Nombre = nombre;
        Materias = new ColaMaterias();
        Liga = null;

    }

    public ColaMaterias getMateria() {
        return Materias;
    }

    public void setMateria(ColaMaterias materia) {
        Materias = materia;
    }

    
    public String getCarrera() {
        return Carrera;
    }


    public void setCarrera(String carrera) {
        Carrera = carrera;
    }


    public String getCedula() {
        return Cedula;
    }


    public void setCedula(String cedula) {
        Cedula = cedula;
    }


    public String getNombre() {
        return Nombre;
    }


    public void setNombre(String nombre) {
        Nombre = nombre;
    }


    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public NodoLista getLiga() {
        return Liga;
    }

    public void setLiga(NodoLista liga) {
        Liga = liga;
    }

}
