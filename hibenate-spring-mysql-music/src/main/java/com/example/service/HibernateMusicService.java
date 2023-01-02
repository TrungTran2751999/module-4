package com.example.service;

import com.example.model.Music;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class HibernateMusicService implements MusicService {

    @Override
    public List<Music> findAllMusic() {
        String queryStr = "SELECT m FROM Music AS m";
        TypedQuery<Music> query = EntityService.entityManager.createQuery(queryStr,Music.class);
        return query.getResultList();
    }

    @Override
    public Music findMusicById(long id) {
        String queryStr = "SELECT m FROM Music AS m WHERE m.id=:id";
        TypedQuery<Music> query = EntityService.entityManager.createQuery(queryStr,Music.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void createMusic(Music music) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = EntityService.sessionFactory.openSession();
            transaction = session.beginTransaction();
                session.save(music);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public void update(Music music, long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = EntityService.sessionFactory.openSession();
            transaction = session.beginTransaction();
                Music oldMusic = findMusicById(id);
                oldMusic.setName(music.getName());
                oldMusic.setCategory(music.getCategory());
                oldMusic.setArtist(music.getArtist());
                oldMusic.setPath(music.getPath());
                session.update(oldMusic);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public void deleteMusic(long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = EntityService.sessionFactory.openSession();
            transaction = session.beginTransaction();
                session.delete(findMusicById(id));
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

}
