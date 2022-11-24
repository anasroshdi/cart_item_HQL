package services;

import model.Cart;
import model.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CartService {

    Session session;
    Transaction transaction;

    public CartService(Session session) {
        this.session = session;
        transaction = this.session.beginTransaction();
    }


    //SELECT ALL
    public void selectAll(){
        Query query = session.createQuery("from Cart");
        List<Cart> cartList = query.list();
        for(Cart cart: cartList){
            System.out.println("List of cart::"+cart.getId()+","+cart.getTotal()+ "," + cart.getItems());
        }
    }

    //INSERT
    public void insert(Cart cart){
        session.persist(cart);
        transaction.commit();
        session.close();
    }

    //UPDATE
    public void update(){
        Query query = session.createQuery("update Cart set total= :total where id= :id");
        query.setParameter("total", 15);
        query.setParameter("id", 1);
        int result = query.executeUpdate();
        System.out.println("Cart Update Status= " + result);
        transaction.commit();
    }

    //Delete
    public void delete(){
        Query query = session.createQuery("delete from Cart where id=:id");
        query.setParameter("id", 1);
        int result = query.executeUpdate();
        transaction.commit();
    }
}
