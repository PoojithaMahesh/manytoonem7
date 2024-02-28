package manytoonem7.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytoonem7.dto.Company;
import manytoonem7.dto.Employee;

public class EMployeeDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	public void saveEmployee(int companyId,Employee employee) {
		EntityManager entityManager=getEntityManager();
		Company dbCompany=entityManager.find(Company.class, companyId);
		if(dbCompany!=null) {
//			that co,mpany is present so i can join to that company
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			
			entityManager.persist(employee);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry Company Id is not present");
		}
	}
	
	
	public void updateEMployee(int employeeId,Employee employee) {
		EntityManager entityManager=getEntityManager();
		Employee dbEmployee=entityManager.find(Employee.class, employeeId);
		if(dbEmployee!=null) {
//			that id is present
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			
			employee.setId(employeeId);
			employee.setCompany(dbEmployee.getCompany());
			entityManager.merge(employee);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	
	public void findEMployee(int employeeId) {
		EntityManager entityManager=getEntityManager();
		Employee dbEmployee=entityManager.find(Employee.class, employeeId);
		if(dbEmployee!=null) {
//			that id is present
			System.out.println(dbEmployee);
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	
	public void deleteEMployee(int employeeId) {
		EntityManager entityManager=getEntityManager();
		Employee dbEmployee=entityManager.find(Employee.class, employeeId);
		if(dbEmployee!=null) {
//			that id is present
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();

			entityManager.remove(dbEmployee);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
