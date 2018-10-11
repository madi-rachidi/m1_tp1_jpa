
package bankManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class Dao{
    private EntityManager em;
    
    public Dao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BankManagerPu");
        em = emf.createEntityManager();
    }
    public void persist(Object object){
        try{
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        }catch(Exception e){
            this.close();
        }
    }
    
    public void update(Object object){
        em.merge(object);
    }
    
    public void remove(Object object){
        
    }
    
    public void close(){
        em.close();
    }
}