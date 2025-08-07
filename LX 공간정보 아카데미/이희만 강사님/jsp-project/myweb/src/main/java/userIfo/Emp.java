package userIfo;

public class Emp {
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	int employee_id;
	String first_name;
	String last_name;
	String email;
	String mobile;
	String hire_date;
	String jobid;
	double salary;
	double commission_pd;
	int manager_id;
	int department_id;
	@Override
	
	public String toString() {
		return "Emp [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", mobile=" + mobile + ", hire_date=" + hire_date + ", jobid=" + jobid
				+ ", salary=" + salary + ", commission_pd=" + commission_pd + ", manager_id=" + manager_id
				+ ", department_id=" + department_id + "]";
	}
	
}
