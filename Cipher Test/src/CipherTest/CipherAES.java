package CipherTest;

import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class CipherAES {
	public static void main(String args[]) {
	
		try {
			KeyGenerator kg = KeyGenerator.getInstance("AES"); // 대칭키 생성
			Key key = kg.generateKey();
			Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding"); // 암.복호화 수행을 위한 Cipher 객체 생성
			c.init(Cipher.ENCRYPT_MODE, key); // 암호화를 위한 Cipher 객체 초기화
			byte input[] = "Plain Text".getBytes();
			// 암호화 처리
			byte encrypted[] = c.doFinal(input);
			byte iv[] = c.getIV();
			
			// 복호화를 위한 Cipher 객체 초기화
			IvParameterSpec dps = new IvParameterSpec(iv);
			c.init(Cipher.DECRYPT_MODE, key, dps);
			// 복호화 처리
			byte output[] = c.doFinal(encrypted);
			
			System.out.println("평문 : "+new String(input));
			System.out.println("암호문 : "+new String(encrypted));
			System.out.println("복호화 결과 : "+new String(output));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
