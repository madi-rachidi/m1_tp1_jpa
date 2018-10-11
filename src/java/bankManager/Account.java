/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Madi
 */
@Entity
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(nullable = false, length = 11)
    private String id;
    @Column(nullable = false)
    private String libelle;
    @Column(length = 27)
    private String iban;
    @Column(nullable = false)
    private double solde;
    
    @ManyToMany(mappedBy = "sesComptes")
    private List<Client> lesClient = new ArrayList();
    
    @ManyToOne
    private BankBranch agence;

    public Account(String libelle, String iban, double solde) {
        this.libelle = libelle;
        this.iban = iban;
        this.solde = solde;
    }
            
    public void setLesClient(List<Client> lesClient) {
        this.lesClient = lesClient;
    }
    
    public Account() {
    }

    public BankBranch getAgence() {
        return agence;
    }

    public void setAgence(BankBranch agence) {
        this.agence = agence;
    }
      

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public List<Client> getLesClient() {
        return lesClient;
    }

    public void setLesClient(ArrayList<Client> lesClient) {
        this.lesClient = lesClient;
    }
    
    public void addClient(Client client){
        this.lesClient.add(client);
    }
    
    public void removeClient(Client client){
        this.lesClient.remove(client);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bankManager.Account[ id=" + id + " ]";
    }
    
}
