package cloud.migration.dao;

import java.util.List;

import cloud.migration.model.Court;

public interface CourtDao {

	public void add(Court court);
	public void edit(Court court);
	public void delete(int courtId);
	public Court getCourt(int courtId);
	public List getAllCourt();		
	public Court getCourtByName(String name);
	
	
}
