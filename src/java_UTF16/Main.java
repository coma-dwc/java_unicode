package java_UTF16;

public class Main {
	public static void main(String[] args) {
		//Stringとchar
		//Javaで文字列を表すデータ型：String
		//String型で表される文字列の各位置文字はchar型のデータ
		
		//String文字列を一文字ずつ改行区切りで出力するプログラムを完成
		String str = "Hello 世界!";
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			System.out.println(c);
		}
	}
}