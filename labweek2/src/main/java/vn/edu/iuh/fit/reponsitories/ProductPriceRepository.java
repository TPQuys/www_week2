package vn.edu.iuh.fit.reponsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import vn.edu.iuh.fit.models.ProductPrice;


import java.util.List;
import java.util.Optional;

public class ProductPriceRepository {
    private EntityManager em;
    private EntityTransaction trans;

    public ProductPriceRepository(){
        em = Persistence.createEntityManagerFactory("labweek2").createEntityManager();
        trans = em.getTransaction();
    }
    public void insertProductP(ProductPrice p){
        try {
            trans.begin();
            em.persist(p);
            trans.commit();
        }catch(Exception e){e.printStackTrace();}
    }
    public void deleteProductP(long id){
        try
        { trans.begin();
            ProductPrice p = em.find(ProductPrice.class,id);
            em.remove(p);
            trans.commit();}catch (Exception e){e.printStackTrace();}
    }
    public Optional<ProductPrice> findById(long id){
        ProductPrice p =em.find(ProductPrice.class,id);
        return Optional.ofNullable(p);
    }
    public List<ProductPrice> findAll(){
        Query query = em.createQuery("select p from ProductPrice p ");
        return query.getResultList();
    }
}
