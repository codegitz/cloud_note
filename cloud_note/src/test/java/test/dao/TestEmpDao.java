package test.dao;

import org.junit.Before;
import org.junit.Test;

import io.codegitz.cloud_note.dao.EmpDao;
import io.codegitz.cloud_note.entity.Emp;
import test.TestBase;

public class TestEmpDao extends TestBase{

	private EmpDao empDao;
	@Before
	public void init(){
		empDao=this.getContext().getBean("empDao",EmpDao.class);
	}
	
	@Test
	public void test(){
		Emp emp=new Emp();
		emp.setAge(22);
		emp.setName("ergou");
		empDao.save(emp);
		System.out.println(emp.getId());
		System.out.println(emp);
	}
}
