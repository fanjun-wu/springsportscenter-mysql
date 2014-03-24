package cloud.migration.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cloud.migration.dao.ReservationDao;
import cloud.migration.model.Reservation;
import cloud.migration.service.ReservationService;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationDao reservationDao;
	
	@CacheEvict("allReservations")
	@Override
	public void saveReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		reservationDao.add(reservation);
	}
	
	@CacheEvict("allReservations")
	@Override
	public void editReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		reservationDao.edit(reservation);
	}

	@CacheEvict("singleReservation")
	@Override
	public void deleteReservation(int reservationId) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		reservationDao.delete(reservationId);
	}

	@Cacheable("singleReservation")
	@Override
	public Reservation getReservation(int reservationId) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		return reservationDao.getReservation(reservationId);
	}
	@Cacheable("allReservations")
	@Override
	public List getReservations() {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		return reservationDao.getAllReservation();
	}
}
