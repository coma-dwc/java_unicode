package java_BOM;

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
	
	//ビッグエンディアンとリトルエンディアン
	//reverseEndian関数ではループを1文字飛ばしで回している(for分の変化式がi+=2となっている)
	//そしてインデックス位置のバイトと次の位置のバイトを入れ替えている
//	private static void reverseEndian(byte[] data) {
//		for(int i=0; i<data.length; i+=2) {
//			byte b1 = data[i];
//			byte b2 = data[i + 1];
//			data[i] = b2;
//			data[i + 1] = b1;
//		}
//	}
	
	
	//UTF-8とBOM
	//BOM付きのUTF-8を作成
	//UTF-8でのBOMは、0xEF 0xBB 0xBFの3バイト
	private static byte[] addUTF8BOM(byte[] data) {
		byte[] result = new byte[data.length + 3];
		result[0] = (byte)0xEF;
		result[1] = (byte)0xBB;
		result[2] = (byte)0xBF;
		System.arraycopy(data, 0, result, 3, data.length);
		return result;
	}
	
	//文字列のUTF-16とUTF-8のバイト列を表示
	public static void main(String[] args) throws Exception {
//		String str = "Hello 世界と𩸽!";
//		System.out.println(str);
//		System.out.println("UTF-16");
//		printBytes(str.getBytes("UTF-16"));
//		System.out.println("UTF-8");
//		printBytes(str.getBytes("UTF-8"));
		
//		String str = "Hello 世界と𩸽!";
//		System.out.println(str);
//		byte[] data = str.getBytes("UTF-16");
//		System.out.println("UTF-16 BE");
//		printBytes(data);
//		reverseEndian(data);
//		System.out.println("UTF-16 LE");
//		printBytes(data);
//		System.out.println(new String(data, "UTF-16"));
		
		
		//UTF-16BEとUTF-16LE
		
		String str = "Hello 世界と𩸽!";
		System.out.println(str);
		System.out.println("UTF-8");
		byte[] data = str.getBytes("UTF-8");
		printBytes(data);
		System.out.println("UTF-8 with BOM");
		byte[] dataWithBom = addUTF8BOM(data);
		printBytes(dataWithBom);
		String str2 = new String(dataWithBom, "UTF-8");
		System.out.println(str2);
	}
	//JavaではString#getBytesする際のエンコーディング名としてUTF-16BEまたはUTF-16LEを指定することで
	//エンディアンを明示することが出来る(この場合はBOMはつかない)
}