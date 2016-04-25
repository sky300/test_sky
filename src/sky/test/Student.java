package sky.test;

/**
 * @author skyow
 *实现clone方法可重写equals方法
 */
public class Student implements Cloneable{
	private int id;
	private String name;
	private int age;
	private String sex;
	private String addr;//住址
	private int birthday;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		//根据字段逻辑判断，尽举例两个
		Student other = (Student)obj;
		if(name == null){
			if(other.name != null){
				return false;
			}
		}else if(!name.equals(other.name)){
				return false;
		}
		if(addr == null){
			if(other.addr != null){
				return false;
			}
		}else if(!addr.equals(other.addr)){
			return false;
		}
		return true;
	}
}
