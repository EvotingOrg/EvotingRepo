/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.test;

import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author Rajesh Yadav <developerrajeshyadav@gmail.com>
 */
public class RandomPasswordGenerator {

    public static String getRandomPassword() {
        String randomPassword = RandomStringUtils.randomAlphanumeric(5);
        return randomPassword;
    }

    public static void main(String args[]) {

        System.out.println("random string is:" + getRandomPassword());
    }
}
