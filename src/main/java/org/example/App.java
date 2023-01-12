package org.example;

import org.example.entities.Equipo;
import org.example.entities.Piloto;
import org.example.repositories.PilotoRepositoryImpl;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PilotoRepositoryImpl pilotos = new PilotoRepositoryImpl();

        Equipo e1 = new Equipo("Aston Martin", "Mercedes");

        Piloto p1 = new Piloto("Fernando Alonso", LocalDate.of(1981, 7, 29), e1);
        Piloto p2 = new Piloto("Lance Stroll", LocalDate.of(1998, 10, 29), e1);
        Piloto p3 = new Piloto("Felipe Drugovich", LocalDate.of(1000, 5, 23), e1);

        System.out.println("\nAntes de insertar ------ ");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        pilotos.create(p1);
        pilotos.create(p2);
        pilotos.create(p3);
        System.out.println("\nCreamos piltotos ------");
        pilotos.readAll().forEach(System.out::println);

        Optional<Piloto> pilotoCopia = pilotos.read(p3.getId());

        System.out.println("\nLeer por id ------ ");
        if (pilotoCopia.isPresent())
            System.out.println(pilotoCopia);
        else
            System.out.println("El id del piloto no existe");

        System.out.println("\nLeer por id que no existe------ ");
        Optional<Piloto> pilotoNoExiste = pilotos.read(4);
        if (pilotoNoExiste.isPresent())
            System.out.println(pilotoNoExiste);
        else
            System.out.println("El id del piloto no existe");

        System.out.println("\nTras actualizar, lectura ------ ");
        p3.setFechaNacimiento(LocalDate.of(2000, 5, 23));
        pilotos.update(p3);
        System.out.println(p3);

        // Borrado del piloto p3
        pilotos.delete(p3);

        // Ver todos
        System.out.println("\nBorrado y lectura ------ ");
        pilotos.readAll().forEach(System.out::println);

        pilotos.close();
    }
}
