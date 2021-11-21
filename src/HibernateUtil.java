import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;


public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    public static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();

        configuration.addAnnotatedClass(Employees.class).addAnnotatedClass(DeletePanel.class).addAnnotatedClass(InsertPanel.class).addAnnotatedClass(ShowPanel.class).addAnnotatedClass(UpdatePanel.class);

        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                .build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    public static void close() {
        sessionFactory.close();
    }

//    "select e from Employees e where e.income between " + num1 " and " + num2;

    //    "insert into Employees values(" + id + ", '" +  name + "'" + ...")";

    public static void insertEmployee (Employees employees) throws SQLException {
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //

            String hql = "insert into Employees (id, name, age, address, income) values(" + employees.getId() +
                    ", '" +  employees.getName() + "'" +
                    ", " + employees.getAge() + ", '" + employees.getAddress() + "'" +
                    ", " + employees.getIncome() + ")";

            Query query = session.createQuery(hql);
            int num = query.executeUpdate();
            System.out.println(num);

            //
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }
    }

    public static List<Employees> readEmployees () throws SQLException {

        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        List<Employees> employeesList = Collections.emptyList();
        try {
            tx = session.beginTransaction();
            //
            String hql = "select e from Employees e";

            Query query = session.createQuery(hql);
            employeesList = query.list();

            for(Employees e : employeesList) {
                System.out.println(e);
            }

            //
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }
        return employeesList;
    }

    public static List<Employees> readEmployees1 (Employees employee1, Employees employee2) throws SQLException {

        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        List<Employees> employeesList = Collections.emptyList();
        try {
            tx = session.beginTransaction();
            //
            String hql = "select e from Employees e where e.income >= " + employee1.getIncome()
                    + " and e.income <= " + employee2.getIncome();

            Query query = session.createQuery(hql);
            employeesList = query.list();

            for(Employees e : employeesList) {
                System.out.println(e);
            }

            //
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }
        return employeesList;
    }

    public static void updateEmployees (Employees employees) throws SQLException {

        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //

            String hql = "update Employees e set" +  " e.age= " + employees.getAge() +
            ", e.address= '" + employees.getAddress() + "', e.income = " + employees.getIncome() + " where e.id = " + employees.getId();

            Query query = session.createQuery(hql);
            int num = query.executeUpdate();
            System.out.println(num);

            //
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }
    }

    public static void deleteEmployees (int id) throws SQLException {

        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //

            String hql = "delete from Employees e where e.id = " + id;

            Query query = session.createQuery(hql);
            int num = query.executeUpdate();
            System.out.println(num);

            //
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }
    }
}
