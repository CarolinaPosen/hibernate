package by.itacademy.mikhalevich.singleton;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

//Lazy Singletone Holder Instance
//Java гаранитирует, что когда будет создан объект внутреннего класса
//Все поля внешнего класса будут проинициализированы

public class EntityManagerHelper {

    private final SessionFactory factory;

    private EntityManagerHelper() {
        //Невозможно использовать параметр конструктора
        Configuration cfg = new Configuration().configure();
        factory = cfg.buildSessionFactory();
    }

    private static class EntityManagerHelperHolder{
        //Private поле доступно для обрамляющего класса
        //Объект HOLDER_INSTANCE инициализирован лениво (LAZY)
        private static final EntityManagerHelper HOLDER_INSTANCE = new EntityManagerHelper();
    }

    public static EntityManagerHelper getInstance(){
        return EntityManagerHelperHolder.HOLDER_INSTANCE;
    }

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

}
