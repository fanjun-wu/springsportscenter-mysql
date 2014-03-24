package cloud.migration.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cloud.migration.dao.CapabilityDao;
import cloud.migration.model.Capability;
import cloud.migration.service.CapabilityService;
@Service
@Transactional
public class CapabilityServiceImpl  implements CapabilityService{

	
	@Autowired
	private CapabilityDao capabilityDao;
	
	@CacheEvict("allCapabilities")
	@Override
	public void saveCapability(Capability capability) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		capabilityDao.add(capability);
	}
	
	@CacheEvict("allCapabilities")
	@Override
	public void editCapability(Capability capability) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		capabilityDao.edit(capability);
	}

	@CacheEvict("singleCapability")
	@Override
	public void deleteCapability(int capabilityId) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		capabilityDao.delete(capabilityId);
	}

	@Cacheable("singleCapability")
	@Override
	public Capability getCapability(int capabilityId) {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		return capabilityDao.getCapability(capabilityId);
	}
	
	@Cacheable("allCapabilities")
	@Override
	public List getCapabilities() {
		// TODO Auto-generated method stub
		System.out.println(new Timestamp(new java.util.Date().getTime()));
		return capabilityDao.getAllCapability();
	}
}
