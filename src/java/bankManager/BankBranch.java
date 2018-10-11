/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Madi
 */
@Entity
public class BankBranch implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(length = 5)
    private Long id;
    private String adresse;
    
    @OneToMany(mappedBy = "agence")
    private List<Account> lesComptes = new ArrayList();

    public String getAdresse() {
        return adresse;
    }

    public BankBranch(String adresse) {
        this.adresse = adresse;
    }
    
    public BankBranch() {
    }
    
    

    public List<Account> getLesComptes() {
        return lesComptes;
    }

    public void setLesComptes(List<Account> lesComptes) {
        this.lesComptes = lesComptes;
    }
    
    

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void addCompte(Account compte){
        this.lesComptes.add(compte);
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
        if (!(object instanceof BankBranch)) {
            return false;
        }
        BankBranch other = (BankBranch) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bankManager.BankBranch[ id=" + id + " ]";
    }
    
}
