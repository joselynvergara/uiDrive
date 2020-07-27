package com.example.uidrive.Entidades;

public class DriveDoc {
    private String titulo;

    public int getFormato() {
        return formato;
    }

    public void setFormato(int formato) {
        this.formato = formato;
    }

    public DriveDoc(String titulo,  int formato,String fecha, int imagen) {
        this.titulo = titulo;
        this.formato = formato;
        this.fecha = fecha;
        this.documento = imagen;
    }

    private int formato;

     private String fecha;
    private int documento;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }
}
