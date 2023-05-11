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

/**
 *
 * @author mac
 */

  /** Section A49
  Name:                    ID:
  * Jana Kurdi             1906167
  * Jamelah hadi           1910165
  * Renad Ghaleb           1908460
  * Noor Babahr            1912922
     */
public class Receiver {
    PrivateKey privateKey;
    PublicKey publicKey;
    KeyPair myPair;
    
    
        //PublicKey publicKey;
    byte[] EncryptedByte;
    Key key;
    Cipher cipherText;
    byte[] encryptedTextBytes;
    public void generateKey() throws Exception{
        //Generate the Key for RSA algorithm
        KeyPairGenerator keygenerator = KeyPairGenerator.getInstance("RSA");
        myPair = keygenerator.generateKeyPair();
        //get public & private key
        privateKey=myPair.getPrivate();
        publicKey=myPair.getPublic();
    } 
          
        
        public void setBobPK(Cipher cipherText) {
       
        this.cipherText = cipherText;
    }
    
               public void setkey(Key key) {
       
        this.key = key;
    }
               
                    public void setkey(byte[] encryptedTextBytes) {
       
        this.encryptedTextBytes = encryptedTextBytes;
    }   
    
        public byte[] DecryptMessage(IvParameterSpec IV) throws Exception {

        //initialize the cipher object, set mode to decrypt, key ,and Initial vector.
        cipherText.init(Cipher.DECRYPT_MODE, key, IV);

        byte[] decryptedTextBytes = cipherText.doFinal(encryptedTextBytes);

        System.out.println("The Decryption message is : " + new String(decryptedTextBytes));

        return encryptedTextBytes;
    }
        
       
     public PublicKey getPublicKey() {
        return publicKey;
    }
}