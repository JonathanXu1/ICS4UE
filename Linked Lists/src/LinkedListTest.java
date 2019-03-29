import java.util.ArrayList;
import java.util.Random;

public class LinkedListTest {
	public static void main(String[] args) {
		SimpleLinkedList<String> sll = new SimpleLinkedList<String>();
		ArrayList<String> verif = new ArrayList<String>();
		Random r = new Random();
		int action, val;
		for (int i = 0; i < 1000; i++) {
			action = r.nextInt(6);

			switch (action) {
			case 0:
				val = r.nextInt(Integer.MAX_VALUE);
				sll.add(Integer.toString(val));
				verif.add(Integer.toString(val));
				if (!asrt(sll, verif)) {
					System.out.println("Error In add");
					return;
				}
				break;
			case 1:
				if (verif.size() == 0) {
					i--;
					break;
				}
				val = r.nextInt(verif.size());
				if (!sll.get(val).equals(verif.get(val))) {
					System.out.println("Error in get");
					return;
				}
				break;
			case 2:
				if (verif.size() == 0) {
					i--;
					break;
				}
				val = Integer.parseInt(verif.get(r.nextInt(verif.size())));
				if (verif.indexOf(Integer.valueOf(val) + "") != sll.indexOf(Integer.valueOf(val) + "")) {
					System.out.println("Error in indexOf");
					return;
				}
				break;
			case 3:
				if (verif.size() == 0) {
					i--;
					break;
				}
				val = r.nextInt(verif.size());
				verif.remove(val);
				sll.remove(val);
				if (!asrt(sll, verif)) {
					System.out.println("Error in remove");
					return;
				}
				break;
			case 5:
				if (verif.size() != sll.size()) {
					System.out.println("Error in size");
					return;
				}
				break;
			}
		}

	}

	public static boolean asrt(SimpleLinkedList<String> sll, ArrayList<String> verif) {
		boolean right = true;
		try {
			for (int i = 0; i < verif.size(); i++) {
				String al = verif.get(i);
				String ll = sll.get(i);
				if (!al.equals(ll)) {
					right = false;
					break;
				}
			}
		} catch (Exception e) {
			right = false;
		}
		return right;
	}
}