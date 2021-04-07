// Created by Simon Wex (simon@zeepmobile.com) on 2008-07-12
// Copyright (c) 2008. All rights reserved.
// Released under MIT License

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class TestHMacSHA {
  public static final String SECRET_ACCESS_KEY = "a9003e4e3f3530dbfa104083ca897ccbb06517d8";

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      String canonicalString = "userid=2&projectid=2&activityid=11&logtime=1243926110&mytime=1243926136&crc32=0x8d200fd8";
      System.out.println("encode String="+canonicalString);
      System.out.println("key="+SECRET_ACCESS_KEY);
      
      Mac mac = Mac.getInstance("HmacSHA1");
      byte[] keyBytes = SECRET_ACCESS_KEY.getBytes("UTF8");
      SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA1");
      mac.init(signingKey);
      
      byte[] signBytes = mac.doFinal(canonicalString.getBytes("UTF8"));
      System.out.println("result=");
      for (int i = 0; i < signBytes.length; i ++) {
          System.out.printf("%02x", signBytes[i]);
      }
      //Digest --> 5da2d061f16a8274b719824f77277a707448d41d
      //String b64Mac = Base64.encode(signBytes);
      //System.out.println("result="+b64Mac);
    }
    catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    catch (InvalidKeyException e) {
      e.printStackTrace();
    }
  }
}