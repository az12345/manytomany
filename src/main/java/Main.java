import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.manytomany.model.Event;
import ru.manytomany.model.Userevent;
import ru.manytomany.model.Usertime;


import javax.persistence.metamodel.EntityType;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Сизиф on 02.07.2017.
 */
public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            session.beginTransaction();
            Userevent userevent = (Userevent) session.load(Userevent.class, new Integer(6));
            Usertime usertime = (Usertime) session.load(Usertime.class, new Integer(6));

            List<Userevent> userevents = usertime.getUserevents();
            List<Usertime> usertimes = userevent.getUsertimes();

            userevents.add(userevent);
            usertimes.add(usertime);

            usertime.setUserevents(userevents);
            userevent.setUsertimes(usertimes);

            session.save(userevent);
            session.save(usertime);
            Usertime usertimeUpdate= new Usertime();
            usertimeUpdate.setId(usertime.getId());
            usertimeUpdate.setDate(usertime.getDate());
            usertimeUpdate.setUserevents(usertime.getUserevents());
            session.update(usertimeUpdate);


            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}