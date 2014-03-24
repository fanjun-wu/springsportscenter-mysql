package cloud.migration.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cloud.migration.dao.SubscriberDao;
import cloud.migration.model.Subscriber;

@Repository
public class SubscriberDaoImp implements SubscriberDao{
	@Autowired
	private SessionFactory session;
	@Override
	public void add(Subscriber subscriber) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(subscriber);
	}

	@Override
	public void edit(Subscriber subscriber) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(subscriber);
	}

	@Override
	public void delete(int subscriberId) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getSubscriber(subscriberId));
	}

	@Override
	public Subscriber getSubscriber(int subscriberId) {
		// TODO Auto-generated method stub
		
		return (Subscriber)session.getCurrentSession().get(Subscriber.class, subscriberId);
	}

	@Override
	public List getAllSubscriber() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Subscriber").list();
	}

	
	@Override
	public Set getReservationsBySubscriber(int id) {
		// TODO Auto-generated method stub
		
		Subscriber subs=(Subscriber)session.getCurrentSession().get(Subscriber.class, id);
		
		return subs.getReservation();
		
		
	}
	
	
	
	
	
	
}
