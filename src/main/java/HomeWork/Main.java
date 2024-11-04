package HomeWork;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Objects;

public class Main {
	public static void main(String[] args) throws Exception {
		User user = new User();
		user.setAge(20);
		System.out.println(user.getAge());

		Field field = User.class.getDeclaredField("age");
		field.setAccessible(true);
		field.set(user, 150);
		System.out.println(user.getAge());
		System.out.println(field.get(user));
	}
}
