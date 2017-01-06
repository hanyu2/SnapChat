
public class DecimalAdd {
	public static String add(String a, String b) {
		int index1 = a.indexOf('.');
		int index2 = b.indexOf('.');
		int aleft = a.length() - 1 - index1;
		int bleft = b.length() - 1 - index2;
		if (bleft > aleft) {
			return add(b, a);
		}

		int astart = a.length() - 1;
		int bstart = a.length() - 1 + index2 - index1;

		StringBuilder sb = new StringBuilder();
		int carry = 0;
		while (astart >= 0 || (bstart >= 0 && bstart < b.length()) || carry != 0) {
			if (astart == index1 && bstart == index2) {
				sb.append('.');
			} else {

				if (astart >= 0) {
					carry += a.charAt(astart) - '0';
				}
				if (bstart >= 0 && bstart < b.length()) {
					carry += b.charAt(bstart) - '0';
				}
				sb.append(carry % 10);
				carry /= 10;
			}
			astart--;
			bstart--;
		}
		return sb.reverse().toString();
	}
	public static void main(String[] args) {
		System.out.println(add("19.34677", "8212.9"));
	}
}
