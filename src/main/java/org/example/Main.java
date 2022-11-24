package org.example;

import model.Cart;
import model.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import services.CartService;
import services.ItemService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry registry =

                new StandardServiceRegistryBuilder()

                        .configure()

                        .build();

        SessionFactory Factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = Factory.openSession();

        Set<Cart> cartSet = new HashSet<>();

        //Setting item object
        Item item = new Item();
        item.setPrice(14);
        item.setDescription("juice");
        item.setCarts(cartSet);
        ItemService itemService = new ItemService(session);

        //ListOfItems and SetOfCart
        List<Item> itemList = new ArrayList<>();
        itemList.add(item);
        itemService.insert(item);
//        itemService.selectAll();



//        CartService cartService = new CartService(session);
        //Setting cart object
//        Cart cart = new Cart();
//        cart.setTotal(50);
//        cart.setItems(itemList);
//        cartService.insert(cart);

    }

}