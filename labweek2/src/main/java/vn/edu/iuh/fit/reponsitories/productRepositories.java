package vn.edu.iuh.fit.reponsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import vn.edu.iuh.fit.enums.EnumProduct;
import vn.edu.iuh.fit.models.Product;

import java.util.List;
import java.util.Optional;

public class productRepositories {
    private EntityManager em;
    private EntityTransaction trans;

    public productRepositories(){
        em = Persistence.createEntityManagerFactory("labweek2").createEntityManager();
        trans = em.getTransaction();
    }
    public void insertProduct(Product p){
        try {
            trans.begin();
            em.persist(p);
            trans.commit();
        }catch(Exception e){e.printStackTrace();}
    }
    public void deleteProduct(long id){
        try
        { trans.begin();
        Product p = em.find(Product.class,id);
        p.setStatus(EnumProduct.FIRED);
        em.merge(p);
        trans.commit();}catch (Exception e){e.printStackTrace();}
    }
    public Optional<Product> findById(long id){
            Product p =em.find(Product.class,id);
            return Optional.ofNullable(p);
    }
    public List<Product> findAll(){
        Query query = em.createQuery("select p from Product p ");
        return query.getResultList();
    }
}
