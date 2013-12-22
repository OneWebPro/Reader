package pl.onewebpro.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5 {

    private static Logger log = LoggerFactory.getLogger(MD5.class);

    public static String _(String string) {
        MessageDigest md = null;
        String md5String = "";
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] md5Digest = md.digest(string.getBytes());
            BigInteger md5Number = new BigInteger(1, md5Digest);
            md5String = md5Number.toString(16);
        } catch (NoSuchAlgorithmException ex) {
            log.error("MD5 error",ex);
        }

        return md5String;
    }
}
