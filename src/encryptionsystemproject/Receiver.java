/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encryptionsystemproject;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

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
    public void generateKey() throws Exception{
        //Generate the Key for RSA algorithm
        KeyPairGenerator keygenerator = KeyPairGenerator.getInstance("RSA");
        myPair = keygenerator.generateKeyPair();
        //get public & private key
        privateKey=myPair.getPrivate();
        publicKey=myPair.getPublic();
    } 
    
    
     public PublicKey getPublicKey() {
        return publicKey;
    }
}
