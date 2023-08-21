package emoji;

public class Main {
	public static void printBytes(byte[] data) {
		for(int i=0; i<data.length; i++) {
			String hex = Integer.toHexString(data[i] & 0xFF).toUpperCase();
			if(hex.length() == 1) {
				hex = "0" + hex;
			}
			System.out.print(hex + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		String str = "✊✋ 🍔🍙"; //✊✋はBMPの範囲で、🍔🍙はサロゲートペア
		System.out.println(str);
		System.out.println("UTF-16");
		printBytes(str.getBytes("UTF-16"));
		System.out.println("UTF-8");
		printBytes(str.getBytes("UTF-8"));
	}
}