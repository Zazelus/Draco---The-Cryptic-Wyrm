package com.draco.ciphers;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class BealeCipher implements Cipher {

	private static String message;
	private static String key;

	private Reader messIn; // System.in for message
	private Reader keyIn;  // keyFile for key file

	private static String cipherText = "";
	private static String plainText = "";
	private String cryptText = "";

	public BealeCipher(String message, String key) {
		BealeCipher.message = message;
		BealeCipher.key = key;

		messIn = new StringReader(message);
        keyIn = new StringReader(key);
	}

	@Override
	public void encrypt() {
		translate(1);
		plainText = cryptText;
	}

	@Override
	public void decrypt() {
		translate(-1);
		cipherText = cryptText;
	}

   // translate: read keyFile and input, translate
   private void translate(int direction) {
      char c, key_c;
      while ((byte)(c = getNextChar(messIn)) != -1) {
         if (Character.isLowerCase(c)) {
            // fetch lowercase letter from key file
            while (!Character.isLowerCase(key_c = getNextChar(keyIn)))
               ;
            cryptText += rotate(c, ((direction*(key_c - 'a')) + 26)%26);
         }
      }
   }

   // getNextChar: fetches next char.  Also opens input file
   public char getNextChar(Reader in) {
      char ch = ' '; // = ' ' to keep compiler happy
      try {
         ch = (char)in.read();
      } catch (IOException e) {
         System.out.println("Exception reading character");
      }
      return ch;
   }

   // rotate: translate using rotation -- simpler version
   //  This just uses arithmetic on char types,
   public char rotate(char c, int key) {
      int res = ((c - 'a') + key + 26)%26 + 'a';
      return (char)res;
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
		BealeCipher.cipherText = cipherText;
	}

	@Override
	public String getPlainText() {
		return plainText;
	}

	@Override
	public void setPlainText(String plainText) {
		BealeCipher.plainText = plainText;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
