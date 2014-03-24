package cloud.migration.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cloud.migration.dao.HallDao;
import cloud.migration.model.Hall;
import cloud.migration.service.HallService;

@Service
@Transactional
public class HallServiceImpl implements HallService {

	@Autowired
	private HallDao hallDao;
	
	@CacheEvict("allHalls")
	@Override
	public void saveHall(Hall hall) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		hallDao.add(hall);
	}
	@CacheEvict("allHalls")
	@Override
	public void editHall(Hall hall) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		hallDao.edit(hall);
	}

	@CacheEvict("singleHall")
	@Override
	public void deleteHall(int hallId) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		hallDao.delete(hallId);
	}

	@Cacheable("singleHall")
	@Override
	public Hall getHall(int hallId) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		return hallDao.getHall(hallId);
	}
	@Cacheable("allHalls")
	@Override
	public List getHalls() {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		return hallDao.getAllHall();
	}
	@Cacheable("singleHall")
	@Override
	public Hall getHallByName(String name) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		return hallDao.getHallByName(name);
	}

}
