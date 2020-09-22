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
		String lowerMessage = message.toLowerCase();

		for (int i = 0; i < lowerMessage.length(); i++) {
			int map = alphabet.indexOf(lowerMessage.charAt(i));
			int shiftValue = (Integer.parseInt(key) + map) % 26;

			char value = alphabet.charAt(shiftValue);

			cipherText += value;
		}
	}

	@Override
	public void decrypt() {
		String lowerCipherText = message.toLowerCase();

		for (int i = 0; i < lowerCipherText.length(); i++) {
			int map = alphabet.indexOf(lowerCipherText.charAt(i));
			int shiftValue = (map - Integer.parseInt(key)) % 26;

			if (shiftValue < 0) {
				shiftValue = alphabet.length() + shiftValue;
			}

			char value = alphabet.charAt(shiftValue);

			plainText += value;
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
