package com.psiphiglobal.cryptography;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public final class KeyGenerator
{
    public static Map<String, byte[]> generateKeys() throws NoSuchAlgorithmException
    {
        KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        Map<String, byte[]> keys = new HashMap<>();
        keys.put("public_key", new X509EncodedKeySpec(publicKey.getEncoded()).getEncoded());
        keys.put("private_key", new PKCS8EncodedKeySpec(privateKey.getEncoded()).getEncoded());
        return keys;
    }

    private KeyGenerator()
    {
    }
}
