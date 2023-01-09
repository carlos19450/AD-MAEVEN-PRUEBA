package org.example;

import org.example.entities.Piloto;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        Piloto p1 = new Piloto("Fernando Alonso", LocalDate.of(1981, 7, 29));
        Piloto p2 = new Piloto("Lance Stroll", LocalDate.of(1998, 10, 29));
        Piloto p3 = new Piloto("Felipe Drugovich", LocalDate.of(1000, 5, 23));

        System.out.println("\nAntes de insertar ------ ");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        Transaction tx = sesion.beginTransaction();
        sesion.persist(p1);
        sesion.persist(p2);
        sesion.persist(p3);
        tx.commit();

        System.out.println("\nTras insertar ------ ");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        tx = sesion.beginTransaction();
        Piloto p1copia = sesion.get(Piloto.class,p1.getId());
        tx.commit();
        System.out.println("\nLeer id 1 ------ ");
        System.out.println(p1copia);

        // Ver todos (createQuery --> createSelectionQuery
        System.out.println("\nVer todos ------ ");
        sesion.createSelectionQuery("from Piloto ").getResultList().forEach(System.out::println);

        sesion.close();
        HibernateUtil.getSessionFactory().close();
    }
}
