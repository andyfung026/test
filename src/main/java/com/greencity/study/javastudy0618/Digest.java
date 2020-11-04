package com.greencity.study.javastudy0618;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;

public class Digest {
    public static void main(String[] args)throws IOException, GeneralSecurityException {
        String algName = args.length >= 2 ? args[1] : "SHA-1";
        MessageDigest alg = MessageDigest.getInstance(algName);
        byte[] input = Files.readAllBytes(Paths.get(args[0]));
        byte[] digest = alg.digest(input);
        String d = "";
        for (int i = 0; i < digest.length; i++) {
           int v= digest[i] & 0xFF;
           if(v<16) d += "0";
            d += Integer.toString(v, 16).toUpperCase() + " ";
        }
        System.out.println(d);
    }
}
