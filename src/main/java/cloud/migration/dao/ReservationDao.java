package cloud.migration.dao;

import java.util.List;

import cloud.migration.model.Reservation;

public interface ReservationDao {
	public void add(Reservation reservation);
	public void edit(Reservation reservation);
	public void delete(int reservationId);
	public Reservation getReservation(int reservationId);
	public List getAllReservation();
}
