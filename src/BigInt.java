public class BigInt {
	String num;

	public BigInt(String num) {
		this.num = num;
	}
	public String getNum() {
		return this.num;
	}
	public BigInt add(BigInt num) {
		StringBuilder s1 = new StringBuilder(this.num);
		StringBuilder s2 = new StringBuilder(num.num);
		StringBuilder res = new StringBuilder();
		s1 = s1.reverse();
		s2 = s2.reverse();
		int carry = 0;
		int i = 0;
		int j = 0;
		while(i < s1.length() || j < s2.length()){
			int x1 = i < s1.length() ? (int)(s1.charAt(i) - '0') : 0;
			int x2 = j < s2.length() ? (int)(s2.charAt(j) - '0') : 0;
			int sum = x1 + x2 + carry;
			res.append(sum % 10);
			carry = sum / 10;
			i++;
			j++;
		}
		if(carry != 0){
			res.append(1);
		}
		res = res.reverse();
		return new BigInt(res.toString());
	}

	/*public BigInt minus(BigInt num) {
		StringBuilder s1 = new StringBuilder(this.num);
		StringBuilder s2 = new StringBuilder(num.num);
		if(this.isPositive() && !num.isPositive()){
			s2 = new StringBuilder(s2.substring(1));
			s1 = s1.re
		}
	}
	public boolean isPositive(){
		return this.num.charAt(0) == '-';
	}*/
	public static void main(String args[]) {
		BigInt num1 = new BigInt("123");
		BigInt num2 = new BigInt("59");
		System.out.println(num1.add(num2).getNum());
		BigInt num3 = new BigInt("7");
		BigInt num4 = new BigInt("2");
		System.out.println(num4.add(num3).getNum());
	}
}
