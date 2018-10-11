/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Madi
 */
@Entity
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(length = 8)
    private Long id;
    private String nom;
    private String prenom;
    
    @Temporal(TemporalType.DATE)
    private Date dateNais;
    
    @ManyToMany()
    @JoinTable(name = "CompteClient",
    joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "compte_id", referencedColumnName = "id"))
    
    
    private List<Account> sesComptes = new ArrayList();

    public Client(String nom, String prenom, Date dateNais) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNais = dateNais;
    }

    public void setSesComptes(List<Account> sesComptes) {
        this.sesComptes = sesComptes;
    }
    

    public Client() {
    }
    
    
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNais() {
        return dateNais;
    }

    public void setDateNais(Date dateNais) {
        this.dateNais = dateNais;
    }

    public List<Account> getSesComptes() {
        return sesComptes;
    }

    public void setSesComptes(ArrayList<Account> sesComptes) {
        this.sesComptes = sesComptes;
    }
    
    public void addCompte(Account compte){
        this.sesComptes.add(compte);
    }
    
    public void removeCompte(Account compte){
        this.sesComptes.remove(compte);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bankManager.Client[ id=" + id + " ]";
    }
    
}
