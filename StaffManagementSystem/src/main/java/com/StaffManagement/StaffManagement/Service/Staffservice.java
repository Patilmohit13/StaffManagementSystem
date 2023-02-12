package com.StaffManagement.StaffManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StaffManagement.StaffManagement.Dao.Staffdao;
import com.StaffManagement.StaffManagement.Entity.Staff;


@Service
public class Staffservice {

	@Autowired
	Staffdao sd;

	public List<Staff> getstaffrecord() {
		return sd.getstaffrecord();

	}

	public boolean insertstaff(Staff staff) {
		return sd.insertstaff(staff);

	}

	public boolean updatestaff(Staff update) {
		return sd.updatestaff(update);

	}

	public List<Staff> getindividualstaff() {
		List<Staff> l1 = sd.getindividualstaff();
		return l1;
	}

	public List<Staff> getstaff20ksal() {
		List<Staff> l1 = sd.getstaff20ksal();
		return l1;
	}

	public List<Staff> getstaffexp1020() {
		List<Staff> l1 = sd.getstaffexp1020();
		return l1;

	}

	public List<Staff> getstaffmaxsal() {
		List<Staff> l1=sd.getstaffmaxsal();
		return l1;
		
	}

	public List<Staff> getstafftrainer() {
		List<Staff> l1= sd.getstafftrainer();
		return l1;
	}

	public List<Staff> staffexcepttrainer() {
		List<Staff> l1= sd.staffexcepttrainer();
		return l1;
	}

	public String getstaffwithMinexp() {
		return sd.getstaffwithMinexp();
		
	}

	public boolean deletestaff(int id) {
		return sd.deletestaff(id);
		
		
	}

	public Staff getanyid(int staffid) {
		return sd.getanyid(staffid);
		
	}

}
