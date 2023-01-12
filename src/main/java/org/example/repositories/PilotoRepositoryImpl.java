package org.example.repositories;

import org.example.entities.Piloto;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class PilotoRepositoryImpl implements Repository<Piloto>{
    private SessionFactory sf = HibernateUtil.getSessionFactory();
    private Session s = sf.openSession();
    @Override
    public Piloto create(Piloto piloto) {
        s.getTransaction().begin();
        s.persist(piloto);
        s.getTransaction().commit();
        return piloto;
    }

    @Override
    public Optional<Piloto> read(int id) {
        s.getTransaction().begin();
        Piloto piloto = s.get(Piloto.class, id);
        s.getTransaction().commit();
        return Optional.ofNullable(piloto);
    }

    @Override
    public List<Piloto> readAll() {
        s.getTransaction().begin();
        List<Piloto> pilotos = s.createSelectionQuery("from Piloto ", Piloto.class).list();
        s.getTransaction().commit();
        return pilotos;
    }

    @Override
    public Piloto update(Piloto piloto) {
        s.getTransaction().begin();
        s.merge(piloto);
        s.getTransaction().commit();
        return piloto;
    }

    @Override
    public void delete(Piloto piloto) {
        s.getTransaction().begin();
        s.remove(piloto);
        s.getTransaction().commit();
    }
    public void close() {
        s.close();
        sf.close();
    }
}
