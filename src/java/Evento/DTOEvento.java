package Evento;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author USER
 */
public class DTOEvento {
    private long idEvento;
    private String nombre_evento;
    private String fecha_evento;
    private int no_participantes;
    private String descripcion;
    private int estatus;

    /**
     * @return the idEvento
     */
    public long getIdEvento() {
        return idEvento;
    }

    /**
     * @param idEvento the idEvento to set
     */
    public void setIdEvento(long idEvento) {
        this.idEvento = idEvento;
    }

    /**
     * @return the nombre_evento
     */
    public String getNombre_evento() {
        return nombre_evento;
    }

    /**
     * @param nombre_evento the nombre_evento to set
     */
    public void setNombre_evento(String nombre_evento) {
        this.nombre_evento = nombre_evento;
    }

    /**
     * @return the fecha_evento
     */
    public String getFecha_evento() {
        return fecha_evento;
    }

    /**
     * @param fecha_evento the fecha_evento to set
     */
    public void setFecha_evento(String fecha_evento) {
        this.fecha_evento = fecha_evento;
    }

    /**
     * @return the no_participantes
     */
    public int getNo_participantes() {
        return no_participantes;
    }

    /**
     * @param no_participantes the no_participantes to set
     */
    public void setNo_participantes(int no_participantes) {
        this.no_participantes = no_participantes;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the estatus
     */
    public int getEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
    
}
