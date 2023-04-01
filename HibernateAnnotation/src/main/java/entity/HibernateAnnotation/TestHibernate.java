package entity.HibernateAnnotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class TestHibernate {
	
	public static void main(String[] args) {
		
		//1. Create Configuration Object
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		/*
		 * StandardServiceRegistry ssr = new
		 * StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		 * Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		 */
		
		//2. Create Session Factory Object
		SessionFactory sessionFactory = config.buildSessionFactory();
		//SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();
		
		//3. Open the Session
		Session session = sessionFactory.openSession();
		
		//4. Begin the Transaction
		session.beginTransaction();
		
		
		//5. Create Object of Class to save
		
		StudentVO obj = new StudentVO();
		//obj.setRollno(58);
		obj.setFname("Gajanan");
		obj.setAge(30);
		obj.setMobNo("7758094241");
		
		
		//6. Save the object into DB
		
		Integer val= (Integer)session.save(obj);
		
		//7. Commit the transaction
		session.getTransaction().commit();
		
		//8. Close the session
		sessionFactory.close();
		session.close();
		
		System.out.println("Saved Student Roll no is - "+val);
		
	}

}
