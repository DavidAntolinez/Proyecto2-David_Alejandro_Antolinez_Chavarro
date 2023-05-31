public class NodoCola {
    private String Materia;
    private PilaNotas Notas;
    private NodoCola Liga;

    
    public NodoCola(String materia) {
        Materia = materia;
        Notas = new PilaNotas();
        Liga = null;
    }

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String materia) {
        Materia = materia;
    }

    public PilaNotas getNotas() {
        return Notas;
    }

    public void setNotas(PilaNotas notas) {
        Notas = notas;
    }

    public NodoCola getLiga() {
        return Liga;
    }

    public void setLiga(NodoCola liga) {
        Liga = liga;
    }
    
}
