package com.template.utils;

import java.util.HashMap;

public class HashCodeUtils {

    public static int additiveHash(String key) {
        int n = key.length();

        int hash = n;

        for (int i = 0; i < n; i++)

            hash += key.charAt(i);

        return hash ^ (hash >> 10) ^ (hash >> 20);

    }

    public static int rotatingHash(String key) {
        int n = key.length();

        int hash = n;

        for (int i = 0; i < n; i++)

            hash = (hash << 4) ^ (hash >> 28) ^ key.charAt(i);

        return (hash & 0x7FFFFFFF);

    }

    /**
     * @param key
     * @param prime 31 131 1313 13131 131313 etc..
     * @return
     */

    public static int BKDRHash(String key, int prime) {
        int hash = 0;

        int n = key.length();

        for (int i = 0; i < n; ++i)

            hash = prime * hash + key.charAt(i);

        return (hash & 0x7FFFFFFF);

    }

    public static int FNVHash(String key) {
        final int p = 16777619;

        int hash = (int) 2166136261L;

        int n = key.length();

        for (int i = 0; i < n; i++)

            hash = (hash ^ key.charAt(i)) * p;

        hash += hash << 13;

        hash ^= hash >> 7;

        hash += hash << 3;

        hash ^= hash >> 17;

        hash += hash << 5;

        return (hash & 0x7FFFFFFF);

    }

    public static int RSHash(String key) {
        int b = 378551;

        int a = 63689;

        int hash = 0;

        int n = key.length();

        for (int i = 0; i < n; i++) {
            hash = hash * a + key.charAt(i);

            a = a * b;

        }

        return (hash & 0x7FFFFFFF);

    }

    public static int JSHash(String key) {
        int hash = 1315423911;

        int n = key.length();

        for (int i = 0; i < n; i++) {
            hash ^= ((hash << 5) + key.charAt(i) + (hash >> 2));

        }

        return (hash & 0x7FFFFFFF);

    }

// P. J. Weinberger Hash Function

    public static int PJWHash(String key) {
        int BitsInUnignedInt = 32;

        int ThreeQuarters = 24;

        int OneEighth = 4;

        int HighBits = (0xFFFFFFFF) << (BitsInUnignedInt - OneEighth);

        int hash = 0;

        int test = 0;

        int n = key.length();

        for (int i = 0; i < n; i++) {
            hash = (hash << OneEighth) + key.charAt(i);

            if ((test = hash & HighBits) != 0) {
                hash = ((hash ^ (test >> ThreeQuarters)) & (~HighBits));

            }

        }

        return (hash & 0x7FFFFFFF);

    }

    public static int ELFhash(String key) {
        int h = 0;

        int n = key.length();

        for (int i = 0; i < n; i++) {
            h = (h << 4) + key.charAt(i);

            long g = h & 0Xf0000000L;

            if (g != 0) {
                h ^= g >> 24;

                h &= ~g;

            }

        }

        return (h & 0x7FFFFFFF);

    }

// SDBM Hash Function

    public static int SDBMHash(String key) {
        int hash = 0;

        int n = key.length();

        for (int i = 0; i < n; i++) {
            hash = key.charAt(i) + (hash << 6) + (hash << 16) - hash;

        }

        return (hash & 0x7FFFFFFF);

    }

// DJB Hash Function

    public static int DJBHash(String key) {
        int hash = 5381;

        int n = key.length();

        for (int i = 0; i < n; i++) {
            hash += (hash << 5) + key.charAt(i);

        }

        return (hash & 0x7FFFFFFF);

    }

// AP Hash Function

    public static int APHash(String key) {
        int hash = 0;

        int n = key.length();

        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                hash ^= ((hash << 7) ^ key.charAt(i) ^ (hash >> 3));

            } else {
                hash ^= (~((hash << 11) ^ key.charAt(i) ^ (hash >> 5)));

            }

        }

        return (hash & 0x7FFFFFFF);

    }

    public static HashMap<Integer, Integer> getThreeHash(String IP) {
        return new HashMap<Integer, Integer>() {{
            put(1, DJBHash(IP));
            put(2, FNVHash(IP));
            put(3, APHash(IP));
        }};
    }

}
