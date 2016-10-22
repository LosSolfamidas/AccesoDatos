package Controlador;

import Modelo.*;
import java.awt.HeadlessException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author crone
 */

public class MetodosCoches {

    
    public static LinkedList LinkedCoches = new LinkedList();

    public static void cochesSELECT() {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        try {
            LinkedCoches.clear();
            Query query = session.createQuery("from Coches co order by co.codcoche");
            List<Coches> listaCoches = query.list();
            Iterator<Coches> iter = listaCoches.iterator();
            tx.commit();
            session.close();
            while (iter.hasNext()) {
                Coches coche = (Coches) iter.next();
                LinkedCoches.add(coche);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al Cargar");
        }
    }

    public static String generarId() {
        String newID;
        int num;
        if (LinkedCoches.isEmpty()) {
            newID = "0";
        } else {
            Coches aux = (Coches) LinkedCoches.getLast();
            newID = aux.getCodcoche();
            num = Integer.parseInt(newID);
            num = num + 1;
            newID = String.valueOf("0"+num);
        }
        return newID;
    }

    public static boolean cocheINSERT(Coches coche) throws Exception {
        try {
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session = sesion.openSession();
            Transaction tx = session.beginTransaction();

            session.save(coche);

            tx.commit();
            session.close();
            return true;
        } catch (HibernateException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Error al Insertar");
            return false;
        }
        
    }

    public static boolean cocheUPDATE(Coches coche) throws Exception {
        try {
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session = sesion.openSession();
            Transaction tx = session.beginTransaction();

            session.update(coche);

            tx.commit();
            session.close();
            return true;
        } catch (HibernateException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Error al Modificar");
            return false;
        }
        
    }

    public static boolean cocheDELETE(Coches coche) throws Exception {
        try {
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session = sesion.openSession();
            Transaction tx = session.beginTransaction();

            Coches delete = new Coches();
            for (Object compara : LinkedCoches) {
                delete = (Coches) compara;
                if (delete.getCodcoche().equalsIgnoreCase(coche.getCodcoche())) {
                    break;
                }
            }
            session.delete(delete);

            tx.commit();
            session.close();
            return true;
        } catch (HibernateException | HeadlessException ex) {
            return false;
        }
        
    }

    public static void cocheBUSCAR(String nombreCoche) throws Exception {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        try {
            LinkedCoches.clear();
            Query q = session.createQuery("from Coches where nombre like '%" + nombreCoche + "%'");
            List<Coches> listaReservas = q.list();
            Iterator<Coches> iter = listaReservas.iterator();
            tx.commit();
            session.close();
            while (iter.hasNext()) {
                Coches aux = (Coches) iter.next();
                LinkedCoches.add(aux);
            }
        } catch (HibernateException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Error al Buscar");
        }
    }
}