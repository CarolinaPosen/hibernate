package by.itacademy.mikhalevich;


import by.itacademy.mikhalevich.model.*;
import by.itacademy.mikhalevich.singleton.EntityManagerHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Optional;

public class Start {
    public static void main(String[] args) {

/*        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        EntityManager em = sf.createEntityManager();*/

        EntityManager em = EntityManagerHelper.getInstance().getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();


//                em.createQuery("from Trip ", Trip.class).getResultList().forEach(Start::printWithPrefix);
//        Post newYearPost = Post.builder()
//                .name("Happy New Year")
//                .tags(new HashSet<>())
//                .build();
//
//        Post christmasPost = Post.builder()
//                .name("Marry Christmas")
//                .tags(new HashSet<>())
//                .build();
//
//        Tag holiday = Tag.builder()
//                .name("Holiday")
//                .posts(new HashSet<>())
//                .build();
//
//        Tag favorite = Tag.builder()
//                .name("Favorite")
//                .posts(new HashSet<>())
//                .build();
//
//        newYearPost.addTag(holiday);
//        newYearPost.addTag(favorite);
//
//        christmasPost.addTag(holiday);
//
//        em.persist(newYearPost);
//        em.persist(christmasPost);

        // remove one of post
//        Trip trip = em.find(Trip.class, 3);
//        // -----BEGIN to remove one tag
//        Optional<Bill> billToRemove = trip.getBills().stream().filter(bill -> bill.getId() == 13).findAny();
//
//        billToRemove.ifPresent(bill -> {
//            trip.removeBill(bill);
//            em.merge(trip);
//        });
        // -----END to remove one tag

        // -----BEGIN to remove one post completely
//        trip.getBills().clear();
//        em.merge(trip);
//        em.remove(trip);
        // -----END to remove one post completely

//        One-To-One PrimaryKeyJoinColumn

//        em.createQuery("from Passenger ", Passenger.class).getResultList().forEach(Start::printWithPrefix);

        Credentials credentials;
        Passenger passenger = Passenger.builder()

                .name("Cristian Bale")
                .credentials(credentials = Credentials.builder()
                        .login("Cristian")
                        .password("asd123")
                        .build())
                .build();
        credentials.setPassenger(passenger);
        em.persist(passenger);

//        ManyToMany Bill - Service

//        Bill bill = em.find(Bill.class, 3);
//        System.out.println(bill);

//        ManyToMany Trip - Bill

//        Trip passenger = em.find(Trip.class, 1);
//        System.out.println(passenger);


//        One-To-Many Passenger - Bills
//        Passenger passenger = em.find(Passenger.class, 1);
//        System.out.println(passenger);

//        One-To-Many
//        Company passenger = em.find(Company.class, 1);
//        System.out.println(passenger);

//        Trip passenger = em.find(Trip.class, 1);
//        System.out.println(passenger);

//        One-To-One
//        Company passenger = em.find(Company.class, 1);
//        System.out.println(passenger);


        tx.commit();
        em.close();


/*        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        Passenger passenger = session.find(Passenger.class, 1);

        System.out.println(passenger);

        transaction.commit();
        session.close();*/

    }

    private static void printWithPrefix(Object obj) {
        System.out.println("!!!" + obj);
    }

}
