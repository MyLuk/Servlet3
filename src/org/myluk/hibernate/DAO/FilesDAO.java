package org.myluk.hibernate.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.myluk.hibernate.entity.Files;

import java.util.List;

public class FilesDAO {
    SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Files.class)
                                .buildSessionFactory();

    public void addFileDtails(Files file) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(file);
        session.getTransaction().commit();
        System.out.println(file.getFilename()+ " Got added");
    }

    public List<Files> listFiles(){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Files> files = session.createQuery("from files ").list();
//        session.getTransaction().commit();
        return files;
    }
}
