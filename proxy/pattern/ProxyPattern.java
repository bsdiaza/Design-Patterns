/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy.pattern;

public class ProxyPattern {
	
   public static void main(String[] args) {
      Image image = new ProxyImage("test_image.jpg");
      image.display(); 
      System.out.println("");
      image.display(); 	
   }
}

