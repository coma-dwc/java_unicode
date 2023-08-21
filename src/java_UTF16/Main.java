package java_UTF16;

//public class Main {
//	public static void main(String[] args) {
		//Stringとchar
		//Javaで文字列を表すデータ型：String
		//String型で表される文字列の各位置文字はchar型のデータ
		
		//String文字列を一文字ずつ改行区切りで出力するプログラムを完成
//		String str = "Hello 世界!";
		//65536文字以上の文字が表現できるか確認(𩸽)
//		String str = "Hello 世界と𩸽!";
//		for(int i=0; i<str.length(); i++) {
//			char c = str.charAt(i);
			//コードポイントを表示
			//char型のデータを[文字] [16進数] [10進数] のようにスペース区切りで表示
			//16進数は4桁で0埋めして表示
//			int n = (int)c;
//			String s = new Character(c).toString();
//			String s10 = Integer.toString(n);
//			String s16 = String.format("%4s", Integer.toHexString(n)).replace(" ", "0").toUpperCase();
////			System.out.println(c);
//			System.out.println(String.format("%s %s %s",  s, s16, s10));
//		}
//	}
//}


//サロゲートペア
public class Main {
	public static void main(String[] args) {
		String str = "Hello 世界と𩸽!";
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			int n = str.codePointAt(i);
			String s = new Character(c).toString();
			if(n > 0xFFFF) {
				//サロゲートペアでは2つで一文字なのでコードポイントからString化する
				//また次の文字はローサロゲートとして処理済みなのでインデックスを1つずらす
				int[] codePoints = {n};
				s = new String(codePoints, 0, codePoints.length);
				i++;
			}
			String s10 = Integer.toString(n);
			String s16 = String.format("%4s", Integer.toHexString(n)).replace(" ", "0").toUpperCase();
			System.out.println(String.format("%s %s %s",  s, s16, s10));
		}
	}
}

//コードポイントの取得にString#codePointAtメソッドを使用


//0xD800 - 0xDBFF:ハイサロゲートペア
//0xDC00 - 0xDFFF:ローサロゲートペア
//ハイサロゲートペア、ローサロゲートペアはそれぞれ1024文字分の範囲があるので、
//サロゲートペアだけでも100万文字以上の文字が表現できる
//(65536 - 2048) + (1024 x 1024) = 1112064
//約110万文字が現在のUnicodeで表現できる文字数の限界値


//コードポイントが0xFFFF以下の文字はchar(=16bit)1つを使って表現
//コードポイントが0x10000以上の文字はサロゲートペアを使ってchar 2つをを使って表現
//このような方式をUTF-16と言う