package cloud.migration.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cloud.migration.dao.CourtDao;
import cloud.migration.model.Court;
import cloud.migration.service.CourtService;

@Service
@Transactional
public class CourtServiceImpl implements CourtService{

	@Autowired
	private CourtDao courtDao;
	
	@CacheEvict("allCourts")
	@Override
	public void saveCourt(Court court) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		courtDao.add(court);
	}
	@CacheEvict("allCourts")
	@Override
	public void editCourt(Court court) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		courtDao.edit(court);
	}

	@CacheEvict("singleCourt")
	@Override
	public void deleteCourt(int courtId) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		courtDao.delete(courtId);
	}

	@Cacheable("singleCourt")
	@Override
	public Court getCourt(int courtId) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		return courtDao.getCourt(courtId);
	}
	
	@Cacheable("allCourts")
	@Override
	public List getCourts() {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		return courtDao.getAllCourt();
	}
	
	@Cacheable("singleCourt")
	@Override
	public Court getCourtByName(String name) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		return courtDao.getCourtByName(name);
	}

	
}
