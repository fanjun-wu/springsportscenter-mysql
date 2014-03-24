package cloud.migration.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cloud.migration.dao.SubscriberDao;
import cloud.migration.model.Subscriber;
import cloud.migration.service.SubscriberService;
@Service
@Transactional
public class SubscriberServiceImpl implements SubscriberService {

	@Autowired
	private SubscriberDao subscriberDao;
	
	@CacheEvict("allSubscribers")
	@Override
	public void saveSubscriber(Subscriber subscriber) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		subscriberDao.add(subscriber);
	}
	@CacheEvict("allSubscribers")
	@Override
	public void editSubscriber(Subscriber subscriber) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		subscriberDao.edit(subscriber);
	}

	@CacheEvict("singleSubscriber")
	@Override
	public void deleteSubscriber(int subscriberId) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		subscriberDao.delete(subscriberId);
	}

	@Cacheable("singleSubscriber")
	@Override
	public Subscriber getSubscriber(int subscriberId) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		return subscriberDao.getSubscriber(subscriberId);
	}
	@Cacheable("allSubscribers")
	@Override
	public List getSubscribers() {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		return subscriberDao.getAllSubscriber();
	}
	@Cacheable("singleSubscriber")
	@Override
	public Set getReservationsBySubscriber(int id) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		return subscriberDao.getReservationsBySubscriber(id);
	}

}
