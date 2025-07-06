package com.learning;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Dell");
        l1.setModel("Latitude");
        l1.setRam(8);



        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("HP");
        l2.setModel("Pavilion");
        l2.setRam(16);

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("Dell");
        l3.setModel("Inspiron");
        l3.setRam(8);


        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Mukesh");
        a1.setTech("WordPress");
        a1.setLaptops(Arrays.asList(l1, l2, l3));

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.learning.Alien.class)
                .addAnnotatedClass(com.learning.Laptop.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(l1);
        session.persist(l2);
        session.persist(l3);
        session.persist(a1);



        transaction.commit();



        //System.out.println(a1);

        //System.out.println(alian);

//        List<Alien> aliens = session.createQuery("from Alien").list();
//        System.out.println(aliens);
        session.close();

        Session session1 = sf.openSession();
        Alien alian = session1.get(Alien.class,101);
        //System.out.println(alian);

        session1.close();
        sf.close();





    }
}