package com.StaffManagement.StaffManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.StaffManagement.StaffManagement.Entity.Staff;
import com.StaffManagement.StaffManagement.Service.Staffservice;

@RestController
public class StaffController {
	
	@Autowired
	Staffservice Sr;

	@GetMapping("/Showstaffrecord")
	public List<Staff> getstaffrecord() {
		return Sr.getstaffrecord();
	}

	@PostMapping("/Insertstaff")
	public boolean insertstaff(@RequestBody Staff staff) {
		boolean inserted = Sr.insertstaff(staff);
		return inserted;
	}

	@PutMapping("/updatestaff")
	public boolean updatestaff(@RequestBody Staff update) {
		boolean updated = Sr.updatestaff(update);
		return updated;
	}

	@GetMapping("/getstaff3")
	public List<Staff> getindividualstaff() {
		List<Staff> l1 = Sr.getindividualstaff();
		return l1;
	}

	@GetMapping("/getsalary20k")
	public List<Staff> getstaff20ksal() {
		List<Staff> l1 = Sr.getstaff20ksal();
		return l1;
	}

	@GetMapping("/Experience10-20")
	public List<Staff> getstaffexp1020() {
		List<Staff> l1 = Sr.getstaffexp1020();
		return l1;

	}

	@GetMapping("/MaxSalary")
	public List<Staff> getstaffmaxsal() {
		List<Staff> l1= Sr.getstaffmaxsal();
		return l1;

	}

	@GetMapping("/Trainer")
	public List<Staff> getstafftrainer() {
		List<Staff> l1 = Sr.getstafftrainer();
		return l1;
	}

	@GetMapping("/Showstaffexcepttrainer")
	public List<Staff> staffexcepttrainer() {
		List<Staff> l1= Sr.staffexcepttrainer();
		return l1;
	}
	
	@GetMapping("/MinimumExp")
	public String getstaffwithMinexp() {
		return Sr.getstaffwithMinexp();
	}
	
	@DeleteMapping("Deletestaff/{id}")
	public boolean deletestaff(@PathVariable int id) {
		boolean deleted= Sr.deletestaff(id);
		return deleted;
	}
	
	@GetMapping("/Showid/{staffid}")
	public Staff getanyid(@PathVariable int staffid) {
		return Sr.getanyid(staffid);
	}

}
