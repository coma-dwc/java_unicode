package java_UTF8;

import java.io.ByteArrayOutputStream;

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
	
//	public static void main(String[] args) throws Exception {
//		String str = "Hello 世界と𩸽!";
//		System.out.println(str);
//		System.out.println("UTF-16");
//		printBytes(str.getBytes("UTF-16"));
//		//UTF-8バイト列の出力
//		System.out.println("UTF-8");
//		printBytes(str.getBytes("UTF-8"));
//	}
	
	//US-ASCII
	
//	public static void main(String[] args) throws Exception {
//		String[] strs = {
//				" !\"#$%&'()*+,-./",
//				"0123456789:;<=>?",
//				"@ABCDEFGHIJKLMKO",
//				"PQRSTUYWXYZ[\\]^_",
//				"abcdefghijklmno",
//				"pqrstuvwxyz{|}~"
//		};
//		for(int i=0; i<strs.length; i++) {
//			System.out.println(strs[i]);
//			printBytes(strs[i].getBytes("UTF-8"));
//		}
//	}
	
	
	//コードポイントからUTF-8への変換
	private static byte[] toUTF8(String str) {
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		for(int i=0; i<str.length(); i++) {
			int codePoint = str.codePointAt(i);
			//サロゲートペアの場合はインデックスを進める
			if(codePoint > 0xFFFF) {
				i++;
			}
			if(codePoint <= 0x7F) {
				//1バイトとなる文字
				buf.write((byte)codePoint);
			} else if(codePoint <= 0x7FF) {
				//2バイトとなる文字
				byte b1 = (byte)((codePoint >> 6) & 0b00011111 | 0b11000000);
				byte b2 = (byte)(codePoint & 0b00111111 | 0b10000000);
				buf.write(b1);
				buf.write(b2);
			} else if (codePoint <= 0xFFFF) {
				//3バイトとなる文字
				byte b1 = (byte)((codePoint >> 12) & 0b00001111 | 0b11100000);
				byte b2 = (byte)((codePoint >> 6) & 0b00111111 | 0b10000000);;
				byte b3 = (byte)(codePoint & 0b00111111 | 0b10000000);;
				buf.write(b1);
				buf.write(b2);
				buf.write(b3);
			} else if (codePoint <= 0x1FFFFF) {
				//4バイトとなる文字
				byte b1 = (byte)((codePoint >> 18) & 0b00000111 | 0b11110000);
				byte b2 = (byte)((codePoint >> 12) & 0b00111111 | 0b10000000);
				byte b3 = (byte)((codePoint >> 6) & 0b00111111 | 0b10000000);
				byte b4 = (byte)(codePoint & 0b00111111 | 0b10000000 );
				buf.write(b1);
				buf.write(b2);
				buf.write(b3);
				buf.write(b4);
			}
		}
		return buf.toByteArray();
	}
	
	public static void main(String[] args) throws Exception {
		String str = "Hello 世界と𩸽!";
		System.out.println(str);
		printBytes(str.getBytes("UTF-8"));
		printBytes(toUTF8(str));
	}
}

//文字のコードポイントを取得するにはcodePointAtメソッドを使用する