/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soltelec.consola.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
*
* @author Gerencia Desarrollo de Soluciones Tecnologicas
*/
@Entity
@Table( name = "equipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e"),
    @NamedQuery(name = "Equipo.findByIdEquipo", query = "SELECT e FROM Equipo e WHERE e.id = :id"),
    @NamedQuery(name = "Equipo.findByPef", query = "SELECT e FROM Equipo e WHERE e.pef = :pef"),
    @NamedQuery(name = "Equipo.findBySerial", query = "SELECT e FROM Equipo e WHERE e.serial = :serial"),
    @NamedQuery(name = "Equipo.findByMarca", query = "SELECT e FROM Equipo e WHERE e.marca = :marca"),
    @NamedQuery(name = "Equipo.findByNumAnalizador", query = "SELECT e FROM Equipo e WHERE e.numAnalizador = :numAnalizador")})
public class Equipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_equipo")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "pef")
    private int pef;
    @Basic(optional = false)
    @Column(name = "serial")
    private String serial;
    @Basic(optional = false)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @Column(name = "num_analizador")
    private String numAnalizador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipo")
    private List<Calibracion> calibracionesList;

    public Equipo() {
    }

    public Equipo(Integer id) {
        this.id = id;
    }

    public Equipo(Integer id, int pef, String serial, String marca, String numAnalizador) {
        this.id = id;
        this.pef = pef;
        this.serial = serial;
        this.marca = marca;
        this.numAnalizador = numAnalizador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idEquipo) {
        this.id = idEquipo;
    }

    public int getPef() {
        return pef;
    }

    public void setPef(int pef) {
        this.pef = pef;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumAnalizador() {
        return numAnalizador;
    }

    public void setNumAnalizador(String numAnalizador) {
        this.numAnalizador = numAnalizador;
    }

    @XmlTransient
    public List<Calibracion> getCalibracionesList() {
        return calibracionesList;
    }

    public void setCalibracionesList(List<Calibracion> calibracionesList) {
        this.calibracionesList = calibracionesList;
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
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.soltelec.models.entities.Equipo[ idEquipo=" + id + " ]";
    }
    
}
