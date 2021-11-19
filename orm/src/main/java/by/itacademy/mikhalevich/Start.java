package by.itacademy.mikhalevich;

import by.itacademy.mikhalevich.model.*;
import by.itacademy.mikhalevich.singleton.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class Start {

    public static final int COUNT_OF_TRIPS = 6;
    public static final String TRUNCATE_DATABASES
            = "TRUNCATE trip, bill, bill_service, company, credential, ident, passenger, return_trip, service, transfer_trip";

    public static void main(String[] args) throws InterruptedException {

        fillDb();
//        clearDb();


        EntityManager em = EntityManagerHelper.getInstance().getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();


//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Passenger> query = cb.createQuery(Passenger.class);
//        Root<Passenger> passengerRoot = query.from(Passenger.class);
//        ParameterExpression<String> nameExpression = cb.parameter(String.class, "name");
//        query.select(passengerRoot).where(cb.like(passengerRoot.get("name"), nameExpression));
//        em.createQuery(query).setParameter("name", "J%").getResultList().forEach(Start::printWithPrefix);

//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<String> query = cb.createQuery(String.class);
//        Root<Credential> credentialRoot = query.from(Credential.class);
//        query.select(credentialRoot.get("login"));
//        em.createQuery(query).getResultList().forEach(Start::printWithPrefix);

//        Remove Query
//        Query query = em.createQuery("DELETE FROM Passenger p WHERE p.name like 'Baz%'");
//        printWithPrefix(query.executeUpdate());

//        Update query
//        Query query = em.createQuery("UPDATE Service s SET s.price = 500 WHERE s.price = 100");
//        printWithPrefix(query.executeUpdate());

        //select left outer explicit join with dto
//        TypedQuery<Trip> query = em.createQuery(
//                "select t from Trip t join fetch t.bills", Trip.class);
//        query.getResultList().forEach(Start::printWithPrefix);

        //select left outer explicit join with dto
//        TypedQuery<ResultDto> query = em.createQuery(
//                "select new com.itacademy.mikhalevich.dto.ResultDto(c.name, t.plane, t.townFrom, t.townTo) from Trip t join t.company c", ResultDto.class);
//        query.getResultList().forEach(Start::printWithPrefix);

//        TypedQuery<ReportTripDto> query = em.createQuery(
//                "select new com.itacademy.mikhalevich.dto.ReportTripDto(t.plane, t.townFrom, t.townTo) from Trip t join t.company c", ReportTripDto.class);
//       query.getResultList().forEach(Start::printWithPrefix);

        //select left outer explicit join
//        TypedQuery<Company> query = em.createQuery("select c from Trip t join t.company c", Company.class);
//        query.getResultList().forEach(Start::printWithPrefix);

        //select left outer implicit join
//        TypedQuery<Company> query = em.createQuery("select distinct t.company from Trip t order by t.company.name", Company.class);
//        query.getResultList().forEach(Start::printWithPrefix);

        //Named Query select several fields with filtering by param
//        TypedQuery<PassengerDto> query = em.createNamedQuery("byName", PassengerDto.class);
//        query.setParameter("name", "Jim Cooper");
//        query.getResultList().forEach(Start::printWithPrefix);

        //select several fields with filtering by param
//        TypedQuery<String> query = em.createQuery("select c.name from Company c where c.ident.serial = :name", String.class);
//        query.setParameter("name", "SIN");
//        query.getResultList().forEach(Start::printWithPrefix);

//        TypedQuery<Passenger> query = em.createQuery(
//                "SELECT p FROM Passenger p join fetch p.credentials c WHERE c.login = :login and c.password = :password", Passenger.class);
//        query.setParameter("login", "Jim@gmail.com");
//        query.setParameter("password", "Cooper123");
//        query.getResultList().forEach(Start::printWithPrefix);

//        TypedQuery<Company> query = em.createQuery("select t.company from Trip t where t.company.name like 'S%'", Company.class );
//        query.getResultList().forEach(Start::printWithPrefix);

        //select several fields to dto
//        TypedQuery<Company> query = em.createQuery("select t.company from Trip t", Company.class);
//        query.getResultList().forEach(Start::printWithPrefix);

//        //select several fields untyped
//        Query query = em.createQuery("select t.plane, t.company from Trip t");
//        query.getResultList().stream().flatMap(a -> Arrays.stream((Object[]) a)).forEach(Start::printWithPrefix);

//        Query query = em.createQuery("Select MAX(s.price) FROM Service s");
//        printWithPrefix(query.getSingleResult());

        //select field
//        TypedQuery<String> query = em.createQuery("select c.login from Credential c", String.class);
//        query.getResultList().forEach(Start::printWithPrefix);

//        select
//         TypedQuery<Passenger> query = em.createQuery("select p from Passenger p", Passenger.class);
//         query.getResultList().forEach(Start::printWithPrefix);

//         from
//        TypedQuery<Passenger> query = em.createQuery("from Passenger ", Passenger.class);
//        printWithPrefix(query);

//        Query query = em.createQuery("Select c FROM Company c WHERE c.name like :name ");
//        query.setParameter("name", "Sin%");
//        printWithPrefix(query.getSingleResult());

        tx.commit();
        em.close();

    }

    private static void addServices(){
        EntityManager em = EntityManagerHelper.getInstance().getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Service reservation = Service.builder()
                .name("Reservation")
                .price(10)
                .build();

        Service insurance = Service.builder()
                .name("Insurance")
                .price(50)
                .build();

        Service nutrition = Service.builder()
                .name("Nnutrition")
                .price(20)
                .build();

        Service baggage = Service.builder()
                .name("Baggage")
                .price(100)
                .build();

        em.persist(insurance);
        em.persist(reservation);
        em.persist(nutrition);
        em.persist(baggage);
        tx.commit();
        em.close();
    }

    private static void addCompanies(){
        EntityManager em = EntityManagerHelper.getInstance().getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Ident tur;
        Company turkish = Company.builder()
                .ident(tur = Ident.builder().serial("TUR").build())
                .name("Turkish Airlines")
                .build();
        em.persist(turkish);

        Ident sin;
        Company singapore = Company.builder()
                .ident(sin = Ident.builder().serial("SIN").build())
                .name("Singapore Airlines")
                .build();
        em.persist(singapore);

        Ident luf;
        Company lufthansa = Company.builder()
                .ident(luf = Ident.builder().serial("LUF").build())
                .name("Lufthansa")
                .build();
        em.persist(lufthansa);

        Ident aer;
        Company aeroflot = Company.builder()
                .ident(aer = Ident.builder().serial("AER").build())
                .name("Aeroflot")
                .build();
        em.persist(aeroflot);

        tx.commit();
        em.close();
    }

    private static void fillDb() throws InterruptedException {

        addServices();
        addCompanies();

        List<String> citiesList = Arrays.asList("Moscow", "Warsaw", "Paris", "Frankfurt", "Osaka", "New York");
        List<String> planeList = Arrays.asList("Boeing", "TU-154", "IL-86", "TU-134", "Airbus A220", "Fokker F28");

        for (int i = 1; i < COUNT_OF_TRIPS; i++) {

            EntityManager em = EntityManagerHelper.getInstance().getEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            Collections.shuffle(citiesList);
            Collections.shuffle(planeList);

            Bill bill1 = getBill(em);
            Bill bill2 = getBill(em);
            Bill bill3 = getBill(em);

            Passenger passenger1 = getPassenger();
            Passenger passenger2 = getPassenger();
            Passenger passenger3 = getPassenger();

            passenger1.addBill(bill1);
            passenger2.addBill(bill2);
            passenger3.addBill(bill3);

            Company company = getCompany(em);
            Trip trip;

            if (i % 2 == 0) {
                trip = TransferTrip.builder()
                        .company(company)
                        .bills(new HashSet<>())
                        .townFrom(citiesList.stream().findAny().get())
                        .townTo(citiesList.stream().findAny().get())
                        .transferTown(citiesList.stream().findAny().get())
                        .plane(planeList.stream().findAny().get())
                        .timeIn(Date.from(LocalDate.of(2000, (int) ((Math.random() * 11) + 1), (int) ((Math.random() * 27) + 1)).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                        .timeOut(Date.from(LocalDate.of(2000, (int) ((Math.random() * 11) + 1), (int) ((Math.random() * 27) + 1)).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                        .transferTimeIn(Date.from(LocalDate.of(2000, (int) ((Math.random() * 11) + 1), (int) ((Math.random() * 27) + 1)).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                        .transferTimeOut(Date.from(LocalDate.of(2000, (int) ((Math.random() * 11) + 1), (int) ((Math.random() * 27) + 1)).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                        .build();
            } else {
                trip = ReturnTrip.builder()
                        .company(company)
                        .plane(planeList.stream().findAny().get())
                        .bills(new HashSet<>())
                        .townFrom(citiesList.stream().findAny().get())
                        .townTo(citiesList.stream().findAny().get())
                        .timeIn(Date.from(LocalDate.of(2000, (int) ((Math.random() * 11) + 1), (int) ((Math.random() * 27) + 1)).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                        .timeOut(Date.from(LocalDate.of(2000, (int) ((Math.random() * 11) + 1), (int) ((Math.random() * 27) + 1)).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                        .returnTimeIn(Date.from(LocalDate.of(2000, (int) ((Math.random() * 11) + 1), (int) ((Math.random() * 27) + 1)).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                        .returnTimeOut(Date.from(LocalDate.of(2000, (int) ((Math.random() * 11) + 1), (int) ((Math.random() * 27) + 1)).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                        .build();
            }

            trip.addBill(bill1);
            trip.addBill(bill2);
            trip.addBill(bill3);

            company.addTrip(trip);

            em.persist(trip);
            tx.commit();
            em.close();

        }

    }

    private static Bill getBill(EntityManager em) {
        Bill bill = Bill.builder()
                .services(new HashSet<>())
                .passenger(new Passenger())
                .build();

        for (Service service: getServices(em)) {
            bill.addService(service);
        }
        return bill;
    }

    private static Passenger getPassenger() {

        List<String> fName = Arrays.asList("Jim", "Fred", "Baz", "Bing", "Cameron", "Carl", "Carlos", "Charles", "Christopher", "Cole", "Connor", "Caleb");
        List<String> lName = Arrays.asList("Duck", "Swan", "Cooper", "Bing", "Bargeman", "Campbell", "Duncan", "Edwards", "Gate", "Hancock", "Higgins");

        Collections.shuffle(fName);
        Collections.shuffle(lName);

        String passengerFirstName = fName.stream().findAny().get();
        String passengerLastName = lName.stream().findAny().get();
        String passengerName = passengerFirstName + " " + passengerLastName;
        String passengerLogin = passengerFirstName+ ((int) (Math.random()*5)) + "@gmail.com";
        String passengerPassword = passengerLastName + ((int) (Math.random()*5));

        Credential credential = Credential.builder()
                .login(passengerLogin)
                .password(passengerPassword)
                .build();

        Passenger passenger = Passenger.builder()
                .name(passengerName)
                .credentials(new Credential())
                .bills(new HashSet<>())
                .build();

        passenger.addCredentials(credential);

        return passenger;
    }

    private static Set<Service> getServices(EntityManager em) {
        TypedQuery<Service> serviceQuery = em.createQuery("from Service", Service.class);
        List<Service> services = serviceQuery.getResultList();
        return services.stream().skip((int) (Math.random() * 4)).collect(Collectors.toSet());
    }

    private static Company getCompany(EntityManager em) {

        Query countQuery = em.createNativeQuery("select count(*) from Company");
        Integer count = 4;

        Random random = new Random();
        int number = random.nextInt((int)count);

        Query selectQuery = em.createQuery("select c from Company c");
        selectQuery.setFirstResult(number);
        selectQuery.setMaxResults(1);
        return (Company) selectQuery.getSingleResult();
    }

    private static void clearDb() {
        EntityManager em = EntityManagerHelper.getInstance().getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        String sql = TRUNCATE_DATABASES;
        em.createNativeQuery(sql).executeUpdate();
        tx.commit();
        em.close();
    }

    private static void printWithPrefix(Object obj) {
        System.out.println("!!!" + obj.toString());
    }

}
