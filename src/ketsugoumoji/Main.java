package ketsugoumoji;

import java.text.Normalizer;
import java.text.Normalizer.Form;

public class Main {
	private static void printBytes(byte[] data) {
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
		String single = new String(new int[] {0x304c}, 0, 1); //単一文字「が」
		String combine = new String(new int[] {0x304B, 0x3099}, 0, 2); //「か」+ 濁点
		
//		System.out.println("単一文字: " + single);
//		System.out.println("Length = " + single.length());
//		printBytes(single.getBytes("UTF-16"));
//		System.out.println("結合文字: " + combine);
//		System.out.println("Length = " + combine.length());
//		printBytes(combine.getBytes("UTF-16"));
//		System.out.println("Equals = " + single.equals(combine));
		
		
		//Normalizer
		//単一文字と結合文字を正規化する為のクラス
		//Noemalizerには以下の4つのFormがある
		//Normalizer.Form.NFC
		//Normalizer.Form.NFD
		//Normalizer.Form.NFKC
		//Normalizer.Form.NFKD
		
		//NFC->結合文字が単一文字に変換可能であれば変換する
		//NFD->単一文字が結合文字に変換可能であれば変換する
		System.out.println("単一文字: " + single);
		printBytes(single.getBytes("UTF-16"));
		printBytes(Normalizer.normalize(single,  Form.NFC).getBytes("UTF-16"));
		printBytes(Normalizer.normalize(single,  Form.NFD).getBytes("UTF-16"));
		
		System.out.println("結合文字: " + combine);
		printBytes(combine.getBytes("UTF-16"));
		printBytes(Normalizer.normalize(combine,  Form.NFC).getBytes("UTF-16")); //NFC
		printBytes(Normalizer.normalize(combine,  Form.NFD).getBytes("UTF-16")); //NFD
	}
}