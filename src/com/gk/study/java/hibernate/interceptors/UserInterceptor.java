package com.gk.study.java.hibernate.interceptors;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.CallbackException;
import org.hibernate.EntityMode;
import org.hibernate.Interceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

import com.gk.study.java.hibernate.model.UserDetails_Vehicle_OneToOneMapping;
import com.gk.study.java.hibernate.model.Vehicle;

public class UserInterceptor implements Interceptor {
	
	public UserInterceptor() {

	}
	
	private ThreadLocal<UserDetails_Vehicle_OneToOneMapping> stored = new  ThreadLocal<>();

	@Override
	public void afterTransactionBegin(Transaction txn) {
		stored.set(new UserDetails_Vehicle_OneToOneMapping());
	}

	@Override
	public void afterTransactionCompletion(Transaction txn) {
		System.out.println("afterTransactionCompletion............");
		if(txn.wasCommitted()){
			System.out.println("Tx Committed..........");
			UserDetails_Vehicle_OneToOneMapping user = stored.get();
			System.out.println("Interceptor.....");
			System.out.println("User Name:"+user.getUserName());
			System.out.println("User Id:"+user.getUserId());
			
			for(Vehicle v: user.getVehicle()){
				System.out.println("Vehicle Id:"+v.getVehicleId());
				System.out.println("Vehicle Name:" + v.getVehicleName());
			}
		}
		
	}

	@Override
	public void beforeTransactionCompletion(Transaction txn) {
		/*System.out.println("afterTransactionBegin............");
		if(txn.wasCommitted()){
			System.out.println("Tx Committed..........");
			UserDetails_Vehicle_OneToOneMapping user = stored.get();
			System.out.println("Interceptor.....");
			System.out.println("User Name:"+user.getUserName());
			System.out.println("User Id:"+user.getUserId());
			
			for(Vehicle v: user.getVehicle()){
				System.out.println("Vehicle Id:"+v.getVehicleId());
				System.out.println("Vehicle Name:" + v.getVehicleName());
			}
		}*/
		
	}

	@Override
	public int[] findDirty(Object arg0, Serializable arg1, Object[] arg2,
			Object[] arg3, String[] arg4, Type[] arg5) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getEntity(String arg0, Serializable arg1)
			throws CallbackException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEntityName(Object arg0) throws CallbackException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object instantiate(String arg0, EntityMode arg1, Serializable arg2)
			throws CallbackException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isTransient(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCollectionRecreate(Object arg0, Serializable arg1)
			throws CallbackException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCollectionRemove(Object arg0, Serializable arg1)
			throws CallbackException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCollectionUpdate(Object arg0, Serializable arg1)
			throws CallbackException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete(Object arg0, Serializable arg1, Object[] arg2,
			String[] arg3, Type[] arg4) throws CallbackException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onFlushDirty(Object arg0, Serializable arg1, Object[] arg2,
			Object[] arg3, String[] arg4, Type[] arg5) throws CallbackException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onLoad(Object arg0, Serializable arg1, Object[] arg2,
			String[] arg3, Type[] arg4) throws CallbackException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String onPrepareStatement(String str) {
		System.out.println(str);
		return str;
	}

	@Override
	public boolean onSave(Object arg0, Serializable arg1, Object[] arg2,
			String[] arg3, Type[] arg4) throws CallbackException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void postFlush(Iterator arg0) throws CallbackException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preFlush(Iterator arg0) throws CallbackException {
		// TODO Auto-generated method stub
		
	}
	

}
