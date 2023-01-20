package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private SessionFactory sessionFactory;
    private Session session;

    public UserDaoHibernateImpl () {
        this.sessionFactory = Util.getSessionFactory();
        this.session = sessionFactory.openSession();
    }
    @Override
    public void createUsersTable() {
        try {
            session.getTransaction().begin();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS Users2 (id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(30), lastName VARCHAR(45), age TINYINT);").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            session.getTransaction().begin();
            session.createSQLQuery("DROP TABLE IF EXISTS Users2;").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
