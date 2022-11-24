package model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double price;
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name="cart_to_items",
        joinColumns={@JoinColumn(name="item_id")},
        inverseJoinColumns={@JoinColumn(name="cart_id")}
    )
    private Set<Cart> carts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }
}
