package com.draco.ciphers;

public interface Cipher {

	public void encrypt();

	public void decrypt();

	public String getMessage();

	public String getKey();

	public String getCipherText();

	public void setCipherText(String cipherText);

	public String getPlainText();

	public void setPlainText(String plainText);

}
