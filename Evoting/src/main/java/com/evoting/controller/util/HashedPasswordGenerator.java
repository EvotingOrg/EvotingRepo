package com.evoting.controller.util;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import java.text.MessageFormat;

/**
 * Use this class to change the password stored in the databae from one that is
 * visible as plain text (a security threat) to one that is "hashed". Hashing is
 * a one-way encryption system. Hashes can be generated but cannot be reverse
 * engineered, which is why they are called one-way hashes. Use this class to
 * generate a hashed password, based on the original plain text version, using
 * SHA-256, which is a superior hashing algorithm. Then copy the output from the
 * console and use it to replace what you have in your database.
 *
 * @author jlombardo
 */
public class HashedPasswordGenerator {

    public static String generateHash(String password) {
        // This is one way of generating a SHA-256 hash. I uses classes/methods
        // from the Google Guava project. See the Maven pom.xml file which
        // I've modified to include the Guava libraries. See the imports
        // above which show what is being used.
        String hash = Hashing.sha256().hashString(password, Charsets.UTF_8).toString();

        //String output = MessageFormat.format("{0} hashed to: {1}", password, hash);

        System.out.println(output);
        return hash;
    }

    /*public static void main(String[] args) {
        // you can generate as many as you need ... modify to suite...
        //store this generated value in your database password value.
        generateHash("rajesh");//973d7f9efc06ba81112bceb8205309ff0f49c303c28914a1dcf143d86a1b15b4
        generateHash("ashok");//19404ce9e897c60dde098e25d85dece4f4a6f36b4cc58d805f582d9cea14e6eb
        generateHash("hem");//d4a0ffcc990b5a1341cc261f330efe9b38ecf5af644bfda4ac2b17fbaaf999e6
        generateHash("admin");//8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918
        generateHash("user");//04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb
    }*/
}
