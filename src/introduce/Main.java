package introduce;

//public class Main {
//	public static void main(String[] args) {
		//1バイト=8ビット 1ビット:0か1の状態を表現 1バイトでは何種類の状態を表現できるか
		//2の8乗を計算
		//Javaでべき乗を計算 Math.powを使用
//		System.out.println(Math.pow(2, 8));
		
		
		//2バイト(16ビット)
		//2の16乗を計算
//		System.out.println(Math.pow(2, 16));
//	}
//}


//2進数と16進数
//0から255までの数字を16進数と2進数で出力するプログラムを完成
public class Main {
	public static void main(String[] args) {
		for(int i=0; i<256; i++) {
			System.out.println(
				String.format("%3s", Integer.toString(i)) +
				": " +
				String.format("%2s", Integer.toHexString(i)).replace(" ", "0").toUpperCase() +
				": " +
				String.format("%8s", Integer.toBinaryString(i)).replace(" ", "0")
			);
		}
	}
}

//数値を16進数の文字列に変換するにはInteger.toHexStringを使用する
//数値を2進数の文字列に変換するにはInteger.toBinaryStringを使用する
//ここでは前に0を埋めるためにString.formatを使用して前に空白文字を追加しそれを0に置換している
//16進数での7F以下の数値を2進数で表した場合先頭ビット(8ビット目)は常に0であることが分かる