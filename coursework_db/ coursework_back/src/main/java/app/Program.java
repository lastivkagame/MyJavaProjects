package app;

import models.*;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Producer prod = new Producer("ProducerCompany", "Canada");

        session.beginTransaction();
        session.save(prod);
        session.getTransaction().commit();

        ImageGallary img1 = new ImageGallary("img1.png");
        ImageGallary img2 = new ImageGallary("img2.png");

        session.beginTransaction();
        session.save(img1);
        session.save(img2);
        session.getTransaction().commit();

        List<ImageGallary> gal = new ArrayList<>();
        gal.add(img1);
        gal.add(img2);

        Product product = new Product("Product", Double.valueOf(120), "$", "Descrip", 4.8, prod, gal);


        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();


        List<Product> prods = new ArrayList<>();
        prods.add(product);

        Basket basket = new Basket(prods);
        Order order = new Order(prods);

        session.beginTransaction();
        session.save(basket);
        session.save(order);
        session.getTransaction().commit();

        List<Order> orders = new ArrayList<>();
        orders.add(order);

        CustomerAccount customerAccount = new CustomerAccount("SomeOne QQQ", "something", "123456", basket, orders);

        session.beginTransaction();
        session.save(customerAccount);
        session.getTransaction().commit();

        session.close();
    }
}
