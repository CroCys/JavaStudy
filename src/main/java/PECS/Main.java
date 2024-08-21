package PECS;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void method() {
		List<ReallyBaseClass> reallyBaseClassList = new ArrayList<>();
		List<BaseClass> baseClassList = new ArrayList<>();
		List<NotBaseClass> notBaseClassList = new ArrayList<>();
		List<NotBaseClassChildren> notBaseClassChildrenList = new ArrayList<>();

		getSuper(notBaseClassList);
		getSuper(baseClassList);
		getSuper(reallyBaseClassList);

		getExtends(baseClassList);
		getExtends(notBaseClassList);
		getExtends(notBaseClassChildrenList);
	}

	public static void getSuper(List<? super NotBaseClass> list) {
		System.out.println("Hello");
	}

	public static void getExtends(List<? extends BaseClass> list) {
		System.out.println("Bye");
	}
}
