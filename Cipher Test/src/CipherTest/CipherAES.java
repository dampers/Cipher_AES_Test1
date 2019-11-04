package CipherTest;

import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class CipherAES {
	public static void main(String args[]) {
	
		try {
			KeyGenerator kg = KeyGenerator.getInstance("AES"); // ��ĪŰ ����
			Key key = kg.generateKey();
			Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding"); // ��.��ȣȭ ������ ���� Cipher ��ü ����
			c.init(Cipher.ENCRYPT_MODE, key); // ��ȣȭ�� ���� Cipher ��ü �ʱ�ȭ
			byte input[] = "Plain Text".getBytes();
			// ��ȣȭ ó��
			byte encrypted[] = c.doFinal(input);
			byte iv[] = c.getIV();
			
			// ��ȣȭ�� ���� Cipher ��ü �ʱ�ȭ
			IvParameterSpec dps = new IvParameterSpec(iv);
			c.init(Cipher.DECRYPT_MODE, key, dps);
			// ��ȣȭ ó��
			byte output[] = c.doFinal(encrypted);
			
			System.out.println("�� : "+new String(input));
			System.out.println("��ȣ�� : "+new String(encrypted));
			System.out.println("��ȣȭ ��� : "+new String(output));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
