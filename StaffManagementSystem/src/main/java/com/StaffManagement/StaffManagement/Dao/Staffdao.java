package com.StaffManagement.StaffManagement.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.StaffManagement.StaffManagement.Entity.Staff;


@Repository
public class Staffdao {
	
	@Autowired
	SessionFactory sf;

	public List<Staff> getstaffrecord() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		List<Staff> l1 = criteria.list();
		session.close();
		return l1;

	}

	public boolean insertstaff(Staff staff) {
		Session session = sf.openSession();
		org.hibernate.Transaction tr = session.beginTransaction();
		session.save(staff);
		tr.commit();
		session.close();
		return true;

	}

	public boolean updatestaff(Staff update) {
		Session session = sf.openSession();
		org.hibernate.Transaction tr = session.beginTransaction();
		session.update(update);
		tr.commit();
		session.close();
		return true;

	}

	public List<Staff> getindividualstaff() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.eq("staffid", 3));
		List<Staff> l1 = criteria.list();
		session.close();
		return l1;

	}

	public List<Staff> getstaff20ksal() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.gt("salary", 20000));
		List<Staff> l1 = criteria.list();
		session.close();
		return l1;

	}

	public List<Staff> getstaffexp1020() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.between("experience", 10, 20));
		List<Staff> l1 = criteria.list();
		session.close();
		return l1;
	}

	public List<Staff> getstaffmaxsal() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.addOrder(Order.desc("salary"));
		criteria.setMaxResults(1);
		List<Staff> l1 = criteria.list();
		session.close();
		return l1;

	}

	public List<Staff> getstafftrainer() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.ilike("profile", "Trainer"));
		List<Staff> l1 = criteria.list();
		session.close();
		return l1;

	}

	public List<Staff> staffexcepttrainer() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.ne("profile", "Trainer"));
		List<Staff> l1 = criteria.list();
		session.close();
		return l1;

	}

	public String getstaffwithMinexp() {
		Session session =sf.openSession();
		Criteria criteria=session.createCriteria(Staff.class);
		criteria.addOrder(Order.asc("experience"));
		criteria.setMaxResults(1);
		List<Staff> l1=criteria.list();
		String Str=null;
		for (Staff staff : l1) {
			Str=staff.getName();
		}
		return Str;
	}

	public boolean deletestaff(int id) {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Staff.class);
		org.hibernate.Transaction tr=session.beginTransaction();
		session.delete(session.load(Staff.class, id));
		tr.commit();
		session.close();
		return true;
		
	}

	public Staff getanyid(int staffid) {
		Session session=sf.openSession();
		Staff staff= session.get(Staff.class, staffid);
		session.close();
		return staff;
	}
	

	
}
