/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
[INF2] TP1 MADI-RACHIDI DEKKAR 21/10
 */
package bankManager;

import java.util.Date;

/**
 *
 * @author Madi
 */
public class Main {
    public static void main(String[] args){
        Dao dao = new Dao();
        Date date = new Date("01/01/2000");
        
        Client client = new Client("toto","prenom",date);
        Account compte = new Account("cmpte 1", "AZERTY7654RTYU7654RTYU765RT",10);
        Account compte1 = new Account("cmpte 2", "AZERTY7654RTYU7654RTYU765RT",10);
        BankBranch banque = new BankBranch("LCL Paris");
        
        dao.persist(client);
        dao.persist(banque);
        
        compte.setAgence(banque);
        compte1.setAgence(banque);
        
        dao.persist(compte1);
        dao.persist(compte);
        
        client.addCompte(compte);
        client.addCompte(compte1);
        
        dao.persist(client);
        dao.close();
        
    }
    
    
}
