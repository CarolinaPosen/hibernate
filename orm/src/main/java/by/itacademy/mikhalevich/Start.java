package by.itacademy.mikhalevich;


import by.itacademy.mikhalevich.model.Passenger;
import by.itacademy.mikhalevich.singleton.EntityManagerHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Start {
    public static void main(String[] args) {

/*        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        EntityManager em = sf.createEntityManager();*/

        EntityManager em = EntityManagerHelper.getInstance().getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Passenger passenger = em.find(Passenger.class, 1);

        System.out.println(passenger);




/*        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        Passenger passenger = session.find(Passenger.class, 1);

        System.out.println(passenger);

        transaction.commit();
        session.close();*/

    }
}
