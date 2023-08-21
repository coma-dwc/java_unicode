package java_UTF8;

//UTF-16バイト列の出力
//数値を16進数で出力するにはInteger.toHexStringを使用
//byte型(符号あり8bit)をそのままint型に変換すると0x80以上の数値は負数と判定されてしまうので
//0xFFとの&を取ることで符号なし整数とする
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
		String str = "Hello 世界と𩸽!";
		System.out.println(str);
		System.out.println("UTF-16");
		printBytes(str.getBytes("UTF-16"));
	}
}