package cloud.migration.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cloud.migration.dao.ReservationDao;
import cloud.migration.model.Reservation;

@Repository
public class ReservationDaoImp implements ReservationDao{

	@Autowired
	private SessionFactory session;
	@Override
	public void add(Reservation reservation) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(reservation);
	}

	@Override
	public void edit(Reservation reservation) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(reservation);
	}

	@Override
	public void delete(int reservationId) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getReservation(reservationId));
	}

	@Override
	public Reservation getReservation(int reservationId) {
		// TODO Auto-generated method stub
		
		return (Reservation)session.getCurrentSession().get(Reservation.class, reservationId);
	}

	@Override
	public List getAllReservation() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Reservation").list();
	}

	
}
