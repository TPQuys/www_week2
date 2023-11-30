package vn.edu.iuh.fit.reponsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import vn.edu.iuh.fit.models.Order;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class OrderReponsitory {
    private EntityManager em;


    public OrderReponsitory(){
        em = Persistence
                .createEntityManagerFactory("labweek2")
                .createEntityManager();
    }

    public void insertOrder(Order o){
        em.persist(o);
    }

    public Order findById(long id) {
        return em.find(Order.class, id);
    }

    public void updateOrder(Order o, LocalDate date){
        o.setDate(date);
        em.merge(o);
    }

    public List<Order> getOrdersByDate(LocalDate d) {
        Query query = em.createQuery("select o from Order o where o.date =:d") ;
        query.setParameter("d", d);
        List<Order> results =  query.getResultList();

        return results;
    }
    public List<Order> OderByEmployee(LocalDate f, LocalDate t,long id){
        Query query = em.createQuery("select o from Order o where o.date >= :from and o.date  <= :to and o.id = :id");
        query.setParameter("from",f);
        query.setParameter("to",t);
        query.setParameter("id",id);

        return query.getResultList();
    }
}
