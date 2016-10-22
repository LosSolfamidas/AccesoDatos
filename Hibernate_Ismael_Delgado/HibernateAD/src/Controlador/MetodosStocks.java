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
public class MetodosStocks {

    public static  LinkedList LinkedStocks = new LinkedList();
    public static  LinkedList LinkedStocksId = new LinkedList();
    public static  LinkedList LinkedConcesionarios = new LinkedList();
    public static  LinkedList LinkedBuscar = new LinkedList();
    public static boolean buscar = false;
    

    public static void stockSELECT() {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        try {
            LinkedStocksId.clear();
            Query query = session.createQuery("from Stocks sk order by sk.id, sk.id.codcoche ");
            List<Stocks> listaStocks = query.list();
            Iterator<Stocks> iter = listaStocks.iterator();
            tx.commit();
            session.close();
            while (iter.hasNext()) {
                Stocks aux = (Stocks) iter.next();
                LinkedStocks.add(aux);
                StocksId aux2 = (StocksId) aux.getId();
                LinkedStocksId.add(aux2);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al Cargar Vista");
        }
    }

    public static void concesionariosSELECT() {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        try {
            LinkedConcesionarios.clear();
            //LinkedStocksId.clear();
            Query query = session.createQuery("from Concesionarios");
            List<Concesionarios> listaConcesionarios = query.list();
            Iterator<Concesionarios> iter = listaConcesionarios.iterator();
            tx.commit();
            session.close();
            while (iter.hasNext()) {
                Concesionarios aux = (Concesionarios) iter.next();
                LinkedConcesionarios.add(aux);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al Cargar Vista");
        }
    }

    public static boolean stockINSERT(Stocks stock) throws Exception {
        try {
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            session.save(stock);
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Ese coche ya existe en ese concesionario.\n Si lo desea puede actualizar su stock");
            return false;
        }
    }

    public static boolean stockUPDATE(Stocks stockUPDATE) throws Exception {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.createQuery("update Stocks stock "
                    + "set stock.id.stock = " + stockUPDATE.getId().getStock()
                    + "where stock.id.idCocesionario = " + stockUPDATE.getId().getIdCocesionario()
                    + "and stock.id.codcoche = " + stockUPDATE.getId().getCodcoche()).executeUpdate();
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Error al Modificar");
            return false;
        }
    }

    public static boolean stockDELETE(Stocks stockDELETE) throws Exception {
        try {
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();
            Session session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            
            Stocks delete = new Stocks();
            for (Object compara : LinkedStocks) {
                delete = (Stocks) compara;
                if (delete.getId().getCodcoche().equalsIgnoreCase(stockDELETE.getId().getCodcoche()) && delete.getId().getIdCocesionario().equalsIgnoreCase(stockDELETE.getId().getIdCocesionario())) {
                    break;
                }
            }
            session.delete(delete);
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Error al Borrar");
            return false;
        }
    }

    public static void stockBUSCAR_NomCon(String nombreCon) throws Exception {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        try {
            LinkedStocksId.clear();
            Query query = session.createQuery("from Stocks sk where sk.id.nombreConcesionario like '%" + nombreCon + "%'");
            List<Stocks> listaStocks = query.list();
            Iterator<Stocks> iterador = listaStocks.iterator();
            tx.commit();
            session.close();
            while (iterador.hasNext()) {
                Stocks aux = iterador.next();
                StocksId aux2 = aux.getId();
                
                    LinkedStocksId.add(aux2);
                
            }
        } catch (HibernateException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Error al Buscar");
        }
    }
     public static void stockBUSCAR_NomCoche(String nombreCoche) throws Exception {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        try {
            LinkedStocksId.clear();
            Query query = session.createQuery("from Stocks sk where sk.id.nombreCoche like '%" + nombreCoche + "%'");
            List<Stocks> listaStocks = query.list();
            Iterator<Stocks> iterador = listaStocks.iterator();
            tx.commit();
            session.close();
            while (iterador.hasNext()) {
                Stocks aux = iterador.next();
                StocksId aux2 = aux.getId();
                
                    LinkedStocksId.add(aux2);
                
            }
        } catch (HibernateException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Error al Buscar");
        }
    }
}

