package java_UTF16;

public class Main {
	public static void main(String[] args) {
		//Stringとchar
		//Javaで文字列を表すデータ型：String
		//String型で表される文字列の各位置文字はchar型のデータ
		
		//String文字列を一文字ずつ改行区切りで出力するプログラムを完成
//		String str = "Hello 世界!";
		//65536文字以上の文字が表現できるか確認(𩸽)
		String str = "Hello 世界と𩸽!";
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			//コードポイントを表示
			//char型のデータを[文字] [16進数] [10進数] のようにスペース区切りで表示
			//16進数は4桁で0埋めして表示
			int n = (int)c;
			String s = new Character(c).toString();
			String s10 = Integer.toString(n);
			String s16 = String.format("%4s", Integer.toHexString(n)).replace(" ", "0").toUpperCase();
//			System.out.println(c);
			System.out.println(String.format("%s %s %s",  s, s16, s10));
		}
	}
}