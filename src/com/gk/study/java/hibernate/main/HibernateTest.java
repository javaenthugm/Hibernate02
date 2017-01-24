package com.gk.study.java.hibernate.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gk.study.java.hibernate.interceptors.UserInterceptor;
import com.gk.study.java.hibernate.model.UserDetails_Vehicle_OneToOneMapping;
import com.gk.study.java.hibernate.model.Vehicle;

public class HibernateTest {
	
	public static void main(String args[]){
		
		hqlTesting();
		
	}
	
	public static void hqlTesting(){
		Session session = null;
		try {
			
			session = HibernateHelper.getSession();
			session.beginTransaction();
			String sql = "from Vehicle";
			Query query = session.createQuery(sql);
			query.setComment("My HQL: "+sql);
			
			List<Vehicle> vehicle = query.list();
			
			for(Vehicle v:vehicle)
				System.out.println(v.getVehicleId()+","+v.getVehicleName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateHelper.getSession().getSessionFactory().close();
		}
		
		
	}
	
	public static void testingHQL(){

		/**
		 * One to One Mapping (User - Vehicle
		 * */
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		//Session session = sessionFactory.openSession();
		Session session = sessionFactory.withOptions().interceptor(new UserInterceptor()).openSession();
		
		try {
		
			
			
			UserDetails_Vehicle_OneToOneMapping user = new UserDetails_Vehicle_OneToOneMapping();
			user.setUserName("User-6");
			
			Vehicle vehicle1  = new Vehicle();
			vehicle1.setVehicleName("Bus");
			
			Vehicle vehicle2  = new Vehicle();
			vehicle2.setVehicleName("Tractor");
			
			user.getVehicle().add(vehicle1);
			user.getVehicle().add(vehicle2);
			
			vehicle1.setUser(user);
			vehicle2.setUser(user);
			
			session.beginTransaction();
			
			session.save(user);
			session.save(vehicle1);
			session.save(vehicle2);
			session.getTransaction().commit();
			
			
			/*UserDetails_Vehicle_OneToOneMapping user = (UserDetails_Vehicle_OneToOneMapping)session.get(UserDetails_Vehicle_OneToOneMapping.class, 1);
			System.out.println(user.getUserName());
			System.out.println(user.getVehicle().size());*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();		
			sessionFactory.close();
		}
		
		
		
		/*UserDetails_ProxyObjectsAndEagerAndLazyFetchTypes user = new UserDetails_ProxyObjectsAndEagerAndLazyFetchTypes();
	    user.setUserName("User 1");
	    
		Address add1= new Address();
		add1.setStreet("Street Name1");
		add1.setCity("City Name1");
		add1.setState("State Name1");
		add1.setPincode("PinCode Name1");
		
		Address add2= new Address();
		add2.setStreet("Street Name2");
		add2.setCity("City Name2");
		add2.setState("State Name2");
		add2.setPincode("PinCode Name2");
		
		user.getListOfAddress().add(add1);
		user.getListOfAddress().add(add2);
	    
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		session  = sessionFactory.openSession();
		user = (UserDetails_ProxyObjectsAndEagerAndLazyFetchTypes)session.get(UserDetails_ProxyObjectsAndEagerAndLazyFetchTypes.class, 1);
		System.out.println(user.getUserName());
		System.out.println(user.getListOfAddress().size());
		
		
		sessionFactory.close();*/
	
	}

}
