package cloud.migration.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cloud.migration.dao.TimeIntervalDao;
import cloud.migration.model.TimeInterval;

@Repository
public class TimeIntervalDaoImp implements TimeIntervalDao{

	
	@Autowired
	private SessionFactory session;
	@Override
	public void add(TimeInterval timeInterval) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(timeInterval);
	}

	@Override
	public void edit(TimeInterval timeInterval) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(timeInterval);
	}

	@Override
	public void delete(int timeIntervalId) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getTimeInterval(timeIntervalId));
	}

	@Override
	public TimeInterval getTimeInterval(int timeIntervalId) {
		// TODO Auto-generated method stub
		
		return (TimeInterval)session.getCurrentSession().get(TimeInterval.class, timeIntervalId);
	}

	@Override
	public List getAllTimeInterval() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from TimeInterval").list();
	}

	@Override
	public List getTimeIntervalByDate(Date date) {
		// TODO Auto-generated method stub
		
		String s_query = "FROM TimeInterval as p WHERE p.date = :date";
		Query query;
		query=session.getCurrentSession().createQuery(s_query).setDate("date", date);
		
		return query.list();
		
		/*
		Criteria criteria = session.getCurrentSession().createCriteria(TimeInterval.class)
			    .add(Restrictions.eq("date", date));
		return  criteria.list();
//		return session.getCurrentSession().
		*/
		
	}

	@Override
	public void addTimeSet(Set<TimeInterval> tals) {
		// TODO Auto-generated method stub
		
		for(TimeInterval tal:tals)
			session.getCurrentSession().save(tal);
		
	}

}
