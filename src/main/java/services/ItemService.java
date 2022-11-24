package services;

import model.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ItemService {

    Session session;
    Transaction transaction;

    public ItemService(Session session) {
        this.session = session;
        transaction = this.session.beginTransaction();
    }


    //SELECT ALL
    public void selectAll(){
        Query query = session.createQuery("from Item");
        List<Item> itemList = query.list();
        for(Item item: itemList){
            System.out.println("List of cart::"+item.getId()+","+item.getDescription()+ "," + item.getPrice()+ "," + item.getCarts());
        }
    }

    //INSERT
    public void insert(Item item){
        session.persist(item);
        transaction.commit();
    }

    //UPDATE
    public void update(){
        Query query = session.createQuery("update Item set description= :description where id= :id");
        query.setParameter("total", 15);
        query.setParameter("id", 1);
        int result = query.executeUpdate();
        System.out.println("item Update Status= " + result);
        transaction.commit();

    }

    //Delete
    public void delete(Item item){
        Query query = session.createQuery("delete from Item where description=:description");
        query.setParameter("description", item.getDescription());
        int result = query.executeUpdate();
        transaction.commit();
    }
}
