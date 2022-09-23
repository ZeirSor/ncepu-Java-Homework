package pkg2_pkg2_Undergraduate_Management_Program;

import java.util.Objects;

public class Undergraduate {
	private String name;
	private int age;
	private Gender gender;

	public enum Gender {
		MAN, WOMEN;

		public static void changeGender(Undergraduate stu) {
			if (stu.gender.equals(MAN))
				stu.setGender(WOMEN);
			else
				stu.setGender(MAN);
		}

		public static Gender valueOf(int ordinal) {
			if (ordinal < 0 || ordinal >= values().length) {
				throw new IndexOutOfBoundsException("Invalid ordinal");
			}
			return values()[ordinal];
		}
	}

	private String id;

	// Count the number of Undergraduates that have been created
	private static int count;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Undergraduate that = (Undergraduate) o;
		return age == that.age && Objects.equals(name, that.name) && gender == that.gender
				&& Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age, gender, id);
	}

	public Undergraduate() {
		count++;
	}

	public Undergraduate(String name, int age, Gender gender, String id, int count) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.id = id;
		this.count = count;
		count++;
	}

	/**
	 * 获取
	 * 
	 * @return count
	 */
	public static int getCount() {
		return count;
	}

	/**
	 * 设置
	 * 
	 * @param count
	 */
	public static void setCount(int count) {
		Undergraduate.count = count;
	}

	/**
	 * 获取
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取
	 * 
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * 设置
	 * 
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * 获取
	 * 
	 * @return gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * 设置
	 * 
	 * @param gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * 获取
	 * 
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String toString() {
		return "Undergraduate{name = " + name + ", age = " + age + ", " + "gender = " + gender + ", id = " + id + "}";
	}
}
