/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encryptionsystemproject;

import java.security.Key;
import java.security.PublicKey;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;

/**
 *
 * @author mac
 */
/**
 * Section A49 Name: ID: Jana Kurdi 1906167 Jamelah hadi 1910165 Renad Ghaleb
 * 1908460 Noor Babahr 1912922
 */
public class Sender {

    //PublicKey publicKey;
    byte[] EncryptedByte;
    Key key;
    PublicKey publicKey;
    Cipher cipherText;
    byte[] encryptedTextBytes;

    public void EncrypteKey() throws Exception {
        //Generate the Key for AES algorithm
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        key = generator.generateKey();

        /* Create the cipher */
        Cipher c = Cipher.getInstance("RSA");

        //nitialize the cipher for encryption
        c.init(Cipher.ENCRYPT_MODE, publicKey);

        /*Encrypt the text*/
        EncryptedByte  =c.doFinal(key.getEncoded());

    }

    public byte[] EncryptMessage(String plainText, IvParameterSpec IV) throws Exception {
        //convert the message to array of bytes
        byte[] plainTextByte = plainText.getBytes();
        EncrypteKey();

        // create cipher object by using CBC mode and AES algorithm
        cipherText = Cipher.getInstance("AES/CBC/PKCS5PADDING");

        // encrypt the message using CBC mode and AES algorithm: 
        //initialize the cipher object, set mode to encrypt, key ,and Initial vector.
        cipherText.init(Cipher.ENCRYPT_MODE, key, IV);

        encryptedTextBytes = cipherText.doFinal(plainTextByte);
        //convert the array to string 
        String encryptedText = Base64.getEncoder().encodeToString(encryptedTextBytes);

        System.out.println("The Encrypted meesage is : " + encryptedText);

        return encryptedTextBytes;
    }

   public void setPK_receiver(PublicKey receiver) {
        this.publicKey = receiver;
    }
    
    public byte[] getEncryptedKey() {
        return EncryptedByte;
    }

}
