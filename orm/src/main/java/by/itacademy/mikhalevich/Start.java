package by.itacademy.mikhalevich;
import com.itacademy.mikhalevich.dto.PassengerDto;
import by.itacademy.mikhalevich.model.*;
import by.itacademy.mikhalevich.singleton.EntityManagerHelper;
import com.itacademy.mikhalevich.dto.ResultDto;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Start {

    public static final int COUNT_OF_TRIPS = 5;

    public static void main(String[] args) {

//        fillDb();

        EntityManager em = EntityManagerHelper.getInstance().getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        List<Passenger> passengers;

        //select left outer explicit join with dto
        TypedQuery<Trip> query = em.createQuery(
                "select t from Trip t join fetch t.bills", Trip.class);
        query.getResultList().forEach(Start::printWithPrefix1);


        //select left outer explicit join with dto
//        TypedQuery<ResultDto> query = em.createQuery(
//                "select new com.itacademy.mikhalevich.dto.ResultDto(c.name, t.plane, t.townFrom, t.townTo) from Trip t join t.company c", ResultDto.class);
//        query.getResultList().forEach(Start::printWithPrefix1);

        //select left outer explicit join
//        TypedQuery<Company> query = em.createQuery("select c from Trip t join t.company c", Company.class);
//        query.getResultList().forEach(Start::printWithPrefix1);

        //select left outer implicit join
//        TypedQuery<Company> query = em.createQuery("select distinct t.company from Trip t", Company.class);
//        query.getResultList().forEach(Start::printWithPrefix1);

        //Named Query select several fields with filtering by param
//        TypedQuery<PassengerDto> query = em.createNamedQuery("byName", PassengerDto.class);
//        query.setParameter("name", "Jim Cooper");
//        query.getResultList().forEach(Start::printWithPrefix1);

        //select several fields with filtering by param
//        TypedQuery<String> query = em.createQuery("select c.name from Company c where c.ident.serial = :name", String.class);
//        query.setParameter("name", "SIN");
//        query.getResultList().forEach(Start::printWithPrefix1);

//        TypedQuery<Company> query = em.createQuery("select t.company from Trip t where t.company.name like 'S%'", Company.class );
//        query.getResultList().forEach(Start::printWithPrefix1);

        //select several fields to dto
//        TypedQuery<Company> query = em.createQuery("select t.company from Trip t", Company.class);
//        query.getResultList().forEach(Start::printWithPrefix1);

//        //select several fields untyped
//        Query query = em.createQuery("select t.plane, t.company from Trip t");
//        query.getResultList().stream().flatMap(a -> Arrays.stream((Object[]) a)).forEach(Start::printWithPrefix1);


        //select field
//        TypedQuery<String> query = em.createQuery("select c.login from Credentials c", String.class);
//        query.getResultList().forEach(Start::printWithPrefix1);

//        select
//         TypedQuery<Passenger> query = em.createQuery("select p from Passenger p", Passenger.class);
//         query.getResultList().forEach(Start::printWithPrefix1);

//         from
//        TypedQuery<Passenger> query = em.createQuery("from Passenger ", Passenger.class);
//        printWithPrefix(query);

        tx.commit();
        em.close();


//        ReturnTrip toHome = ReturnTrip.builder()
//
//                .transferTimeIn(Date.from(LocalDate.of(2000, 10, 3).atStartOfDay(ZoneId.systemDefault()).toInstant()))
//                .transferTimeOut(Date.from(LocalDate.of(2000, 10, 5).atStartOfDay(ZoneId.systemDefault()).toInstant()))
//                .build();


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

//        Credentials credentials;
//        Passenger passenger = Passenger.builder()
//
//                .name("Cristian Bale")
//                .credentials(credentials = Credentials.builder()
//                        .login("Cristian")
//                        .password("asd123")
//                        .build())
//                .build();
//        credentials.setPassenger(passenger);
//        em.persist(passenger);

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


/*        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        Passenger passenger = session.find(Passenger.class, 1);

        System.out.println(passenger);

        transaction.commit();
        session.close();*/

    }

    private static void fillDb(){

        List<String> fName = Arrays.asList("Jim", "Fred", "Baz", "Bing");
        List<String> lName = Arrays.asList("Duck", "Swan", "Cooper", "Bing");
        List<String> serviceNameList = Arrays.asList("Reservation", "Insurance", "Nnutrition", "Baggage");
        List<String> airlinesList = Arrays.asList("Turkish Airlines", "Singapore Airlines", "American Airlines", "Lufthansa");
        List<String> citiesList = Arrays.asList("Moscow", "Warsaw", "Paris", "Frankfurt", "Osaka", "New York");
        List<String> planeList = Arrays.asList("Boeing", "TU-154", "IL-86", "TU-134", "Airbus A220", "Fokker F28");

        for (int i = 0; i < COUNT_OF_TRIPS; i++) {

            EntityManager em = EntityManagerHelper.getInstance().getEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            Collections.shuffle(fName);
            Collections.shuffle(lName);
            Collections.shuffle(serviceNameList);
            Collections.shuffle(airlinesList);
            Collections.shuffle(citiesList);
            Collections.shuffle(planeList);

            String passengerFirstName = fName.stream().findAny().get();
            String passengerLastName = lName.stream().findAny().get();
            String passengerName = passengerFirstName + " " + passengerLastName;
            String passengerLogin = passengerFirstName + "@gmail.com";
            String passengerPassword = passengerLastName + "123";
            String airlines = airlinesList.stream().findAny().get();

            Credential credentials;
            Passenger passenger = Passenger.builder()
                    .name(passengerName)
                    .credentials(credentials = Credential.builder()
                            .login(passengerLogin)
                            .password(passengerPassword)
                            .build())
                    .build();
            credentials.setPassenger(passenger);

            Service reservation = Service.builder()
                    .name(String.valueOf(serviceNameList.stream().findAny().get()))
                    .price((int) (Math.random() * 10))
                    .build();

            Service insurance = Service.builder()
                    .name(String.valueOf(serviceNameList.stream().findAny().get()))
                    .price((int) (Math.random() * 10))
                    .build();

            Set<Service> services = new HashSet<>(List.of(insurance, reservation));

            Bill bill = Bill.builder()
                    .passenger(passenger)
                    .services(services)
                    .trips(new HashSet<>())
                    .build();

            Company company;
            Ident baw;
            Trip trip;

            if(i%2==0){


                 trip = TransferTrip.builder()
                        .company(company = Company.builder()
                                .name(airlines)
                                .ident(baw = Ident.builder()
                                        .serial(airlines.substring(0, 3).toUpperCase())
                                        .build())
                                .build())
                        .bills(new HashSet<>())
                        .townFrom(citiesList.stream().findAny().get())
                        .townTo(citiesList.stream().findAny().get())
                        .transferTown(citiesList.stream().findAny().get())
                        .plane(planeList.stream().findAny().get())
                        .timeIn(Date.from(LocalDate.of(2000, 10, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                        .timeOut(Date.from(LocalDate.of(2000, 10, 10).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                        .transferTimeIn(Date.from(LocalDate.of(2000, 10, 3).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                        .transferTimeOut(Date.from(LocalDate.of(2000, 10, 5).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                        .build();
                trip.addBill(bill);

            } else {

                trip = ReturnTrip.builder()
                        .company(company = Company.builder()
                                .name(airlines)
                                .ident(baw = Ident.builder()
                                        .serial(airlines.substring(0, 3).toUpperCase())
                                        .build())
                                .build())
                        .bills(new HashSet<>())
                        .townFrom(citiesList.stream().findFirst().get())
                        .townTo(citiesList.stream().skip(1).findAny().get())
                        .returnTimeIn(Date.from(LocalDate.of(2000, 10, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                        .returnTimeOut(Date.from(LocalDate.of(2000, 10, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                        .plane(planeList.stream().findAny().get())
                        .timeIn(Date.from(LocalDate.of(2000, 10, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                        .timeOut(Date.from(LocalDate.of(2000, 10, 10).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                        .build();
                trip.addBill(bill);
            }

            em.persist(passenger);
            em.persist(trip);
            tx.commit();
            em.close();

        }

    }

    private static void printWithPrefix1(Object obj) {
        System.out.println("!!!" + obj);
    }

    private static void printWithPrefix(TypedQuery query) {

        List l =query.getResultList();
        System.out.println("Total Number Of Records : "+l.size());
        Iterator it = l.iterator();

        while(it.hasNext())
        {
//            Object o = (Object)it.next();
//            Passenger p = (Passenger) o;
//            System.out.println("Passenger id : "+p.getId());
//            System.out.println("Passenger Name : "+p.getName());
//            System.out.println("Passenger Login : "+p.getCredentials());
//            System.out.println("Count of bills : "+p.getBills().size());
            System.out.println("----------------------");
        }
    }

}
