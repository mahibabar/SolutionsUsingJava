package hashtable.hashcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

public class HashSetDepth
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Employee e1=new Employee(101,"aaaa",10000);
		Employee e2=new Employee(101,"aaaa",10000);
		Employee e3=new Employee(101,"aaaa",10000);
		
		//System.out.println(e1.hashCode());
		//System.out.println(e2.hashCode());
		//System.out.println(e3.hashCode());
		
		HashSet<Employee> ht=new HashSet<>();
		ht.add(e1);
		ht.add(e2);
		ht.add(e3);
		ht.add(null);
		ht.add(null);
		System.out.println(ht.toString());
		
		
		Map<String, Integer> map = new HashMap<>();
		map.put(null, 1);
		map.put(null, 2);
		map.put(null, null);
		map.put(null, 3);

		System.out.println(map.get(null));
		
		
		Hashtable<String, Integer> htble = new Hashtable<>();
		//htble.put("abc", null);
		
		String str = "abc";
		String str1 = "acb";
		int result = str1.compareTo(str);
		System.out.println(result);
		
	}
	
	
}
class Employee
{
	String emp_name;
	int emp_sal;
	@Override
	public int hashCode() {
		System.out.println("--calling hashcode------");
		int result = this.emp_id *7;
		return result;
	}
	@Override
	public boolean equals(Object obj) 
	{
		System.out.println("-----equals method call----");
		Employee other = (Employee) obj;
		if(other.getEmp_id() == this.getEmp_id()) {
			return true;
		}
		return false;
	}
	public Employee(int emp_id,String emp_name, int emp_sal) {
		super();
		this.emp_name = emp_name;
		this.emp_sal = emp_sal;
		this.emp_id = emp_id;
	}
	int emp_id;
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public int getEmp_sal() {
		return emp_sal;
	}
	public void setEmp_sal(int emp_sal) {
		this.emp_sal = emp_sal;
	}
	@Override
	public String toString() {
		return "Employee [emp_name=" + emp_name + ", emp_sal=" + emp_sal + ", emp_id=" + emp_id + "]";
	}
	
}