package mx.datafit.escolarex;

/**
 * Created by Gerardo on 29/09/2017.
 */

public class Tareas {

    private String tarea;
    private String archivo;
    private String fechaPublicacion;

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public String toString() {
        return "Tareas{" +
                "tarea='" + tarea + '\'' +
                ", archivo='" + archivo + '\'' +
                ", fechaPublicacion='" + fechaPublicacion + '\'' +
                '}';
    }
}
