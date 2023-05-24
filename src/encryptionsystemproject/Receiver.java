/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encryptionsystemproject;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author mac
 */
/**
 * Section A49 Name: ID: Jana Kurdi 1906167 Jamelah hadi 1910165 Renad Ghaleb
 * 1908460 Noor Babahr 1912922
 */
public class Receiver {

    PrivateKey privateKey;
    PublicKey publicKey;
    KeyPair myPair;

    //PublicKey publicKey;
    Key key;
    Cipher cipherText;
    byte[] encryptedBytes;
    private byte[] message;

    public void generateKey() throws Exception {
        //Generate the Key for RSA algorithm
        KeyPairGenerator keygenerator = KeyPairGenerator.getInstance("RSA");
        myPair = keygenerator.generateKeyPair();
        //get public & private key
        privateKey = myPair.getPrivate();
        publicKey = myPair.getPublic();
    }

    public void setEncryptkey(byte[] encryptedBytes) {
        this.encryptedBytes = encryptedBytes;
    }

    public void DecryptKey() throws Exception {
        Cipher cipherkey = Cipher.getInstance("RSA");
        //start decrypte the key using bob private key
        cipherkey.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] Decryptkey = cipherkey.doFinal(encryptedBytes);

        key = new SecretKeySpec(Decryptkey, 0, Decryptkey.length, "AES");
    }

    public void DecryptMessage(IvParameterSpec IV) throws Exception {
        DecryptKey();
        //initialize the cipher object, set mode to decrypt, key ,and Initial vector.
        Cipher ciphermsg = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        ciphermsg.init(Cipher.DECRYPT_MODE, key, IV);
        byte[] Decryptmessage = ciphermsg.doFinal(message);

        System.out.println("The Decryption message is : " + new String(Decryptmessage));

        
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setMessage(byte[] message) {
        this.message = message;
    }
}
