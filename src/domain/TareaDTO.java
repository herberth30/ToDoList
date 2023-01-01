package domain;

import datos.TareaDAO;

public class TareaDTO {
    int idTarea;
    String titulo;
    String descripcion;
    String estado;
    String comodin;

    public TareaDTO() {
    }

    public TareaDTO(int idTarea) {
        this.idTarea = idTarea;
    }

    public TareaDTO(String comodin) {
        this.comodin = comodin;
    }

    public TareaDTO(String titulo, String descripcion, String estado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public TareaDTO(int idTarea, String titulo, String descripcion, String estado) {
        this.idTarea = idTarea;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public TareaDTO(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComodin() {
        return comodin;
    }

    public void setComodin(String comodin) {
        this.comodin = comodin;
    }

    @Override
    public String toString() {
        return "TareaDTO{" +
                "idTarea=" + idTarea +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }


    public String toStringC() {
        return "TareaDTO{" +
                "comodin='" + comodin + '\'' +
                '}';
    }
}
