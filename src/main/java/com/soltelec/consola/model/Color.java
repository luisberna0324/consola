/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soltelec.consola.model;

import javax.persistence.*;
import java.io.Serializable;

/**
*http://192.168.248.90/ci2_cda_ws/sincrofur.asmx
* @author Gerencia Desarrollo de Soluciones Tecnologicas
*/
@Entity
@Table( name = "colores")
@NamedQueries({
    @NamedQuery(name = "Color.findAll", query = "SELECT c FROM Color c"),
    @NamedQuery(name = "Color.findByColor", query = "SELECT c FROM Color c WHERE c.id = :id"),
    @NamedQuery(name = "Color.findMaxId", query = "SELECT Max(c.id) FROM Color c "),
    @NamedQuery(name = "Color.findByDescColor", query = "SELECT c FROM Color c  WHERE c.nombre LIKE :descColor order by c.nombre "),
    @NamedQuery(name = "Color.findByNombrecolor", query = "SELECT c FROM Color c WHERE c.nombre = :nombre")})
public class Color implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "COLOR")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Nombre_color")
    private String nombre;
    
    public Color() {
    }

    public Color(Integer id) {
        this.id = id;
    }

    public Color(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer color) {
        this.id = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombrecolor) {
        this.nombre = nombrecolor;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Color)) {
            return false;
        }
        Color other = (Color) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
