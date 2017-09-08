import org.hibernate.HibernateException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import ru.manytomany.model.Event;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.manytomany.model.Role;
import ru.manytomany.model.User;
import ru.manytomany.model.Userevent;
import ru.manytomany.model.Usertime;


import javax.persistence.metamodel.EntityType;

import java.sql.Date;
import java.sql.Time;
import java.util.*;

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
//            Role role = new Role();
//            role.setRole("ROLE_ADMIN");
//            User user = new User();
//            user.setName("admin");
//            user.setPassword("admin");
//            Set<Role> roles = new HashSet<>();
//            roles.add(role);
//            Set<User> users = new HashSet<>();
//            users.add(user);
//            role.setUsers(users);
//            user.setRoles(roles);
//           session.persist(role);
//           session.persist(user);
            Query query = session.createQuery("from User where name= :username");
            System.out.println(query);
            query.setParameter("username", "admin");
            User user = (User) query.uniqueResult();
//            Set<GrantedAuthority> authorities = new HashSet<>();
            for (Role role: user.getRoles()){
//                authorities.add(new SimpleGrantedAuthority(role.getRole()));
                System.out.println(role.getRole());
            }
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}