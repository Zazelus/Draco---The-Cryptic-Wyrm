package com.draco.ciphers;

public class CaesarCipher implements Cipher {

	private static String alphabet = "abcdefghijklmnopqrstuvwxyz";

	private static String message;
	private static String key;

	private static String cipherText = "";
	private static String plainText = "";

	public CaesarCipher(String message, String key) {
		CaesarCipher.message = message;
		CaesarCipher.key = key;
	}

	@Override
	public void encrypt() {
		for (int i = 0; i < message.length(); i++) {
			char value = ' ';

			if (message.charAt(i) == ' ') {
				cipherText += value;
			}

			else {
				char ch = message.charAt(i);
				boolean isUpperCase = Character.isUpperCase(ch);

				int map = alphabet.indexOf(Character.toLowerCase(ch));
				int shiftValue = (Integer.parseInt(key) + map) % 26;

				if (isUpperCase) {
					value = Character.toUpperCase(alphabet.charAt(shiftValue));
				}
				else {
					value = alphabet.charAt(shiftValue);
				}

				cipherText += value;
			}
		}
	}

	@Override
	public void decrypt() {
		for (int i = 0; i < message.length(); i++) {
			char value = ' ';

			if (message.charAt(i) == ' ') {
				plainText += value;
			}

			else {
				char ch = message.charAt(i);
				boolean isUpperCase = Character.isUpperCase(ch);

				int map = alphabet.indexOf(Character.toLowerCase(ch));
				int shiftValue = (map - Integer.parseInt(key)) % 26;

				if (shiftValue < 0) {
					shiftValue = alphabet.length() + shiftValue;
				}

				if (isUpperCase) {
					value = Character.toUpperCase(alphabet.charAt(shiftValue));
				}
				else {
					value = alphabet.charAt(shiftValue);
				}

				plainText += value;
			}
		}
	}

	@Override
	public String getKey() {
		return key;
	}

	@Override
	public String getCipherText() {
		return cipherText;
	}

	@Override
	public void setCipherText(String cipherText) {
		CaesarCipher.cipherText = cipherText;
	}

	@Override
	public String getPlainText() {
		return plainText;
	}

	@Override
	public void setPlainText(String plainText) {
		CaesarCipher.plainText = plainText;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
