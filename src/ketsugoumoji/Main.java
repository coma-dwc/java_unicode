package ketsugoumoji;

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
		System.out.println("単一文字: " + single);
		System.out.println("Length = " + single.length());
		printBytes(single.getBytes("UTF-16"));
		System.out.println("結合文字: " + combine);
		System.out.println("Length = " + combine.length());
		printBytes(combine.getBytes("UTF-16"));
		System.out.println("Equals = " + single.equals(combine));
	}
}