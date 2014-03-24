package cloud.migration.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cloud.migration.dao.TimeIntervalDao;
import cloud.migration.model.TimeInterval;
import cloud.migration.service.TimeIntervalService;
@Service
@Transactional
public class TimeIntervalServiceImpl implements TimeIntervalService {

	@Autowired
	private TimeIntervalDao timeIntervalDao;
	
	@CacheEvict("allTimeInteravls")
	@Override
	public void saveTimeInterval(TimeInterval timeInterval) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		timeIntervalDao.add(timeInterval);
	}
	
	@CacheEvict("allTimeInteravls")
	@Override
	public void editTimeInterval(TimeInterval timeInterval) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		timeIntervalDao.edit(timeInterval);
	}

	@CacheEvict("singleTimeInterval")
	@Override
	public void deleteTimeInterval(int timeIntervalId) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		timeIntervalDao.delete(timeIntervalId);
	}

	@Cacheable("singleTimeInterval")
	@Override
	public TimeInterval getTimeInterval(int timeIntervalId) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		return timeIntervalDao.getTimeInterval(timeIntervalId);
	}
	
	@Cacheable("allTimeInteravls")
	@Override
	public List getTimeIntervals() {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		return timeIntervalDao.getAllTimeInterval();
	}
	
	
	
	@Cacheable("singleTimeInterval")
	@Override
	public List getTimeIntervalByDate(Date date) {
		// TODO Auto-generated method stub

		return timeIntervalDao.getTimeIntervalByDate(date);		
	}
	
	@Cacheable("allTimeInteravls")
	@Override
	public void saveTimeSet(Set<TimeInterval> tals) {
		// TODO Auto-generated method stub
		timeIntervalDao.addTimeSet(tals);
	}
}
