package com.template.utils;

import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

@Component("bloomFilterUtils")
public class BloomFilterUtils {

    private static final int CAPACITY = 100000;

    private static final int bitSetSize = 3;

    private final List<BitSet> bitSetList = new ArrayList<>();

    {
        for (int i = 0; i < bitSetSize; i++) {
            bitSetList.add(new BitSet(1000));
        }
    }

    public void set(String IP) {

        int[] data = hash(IP);

        for (int i = 0; i < bitSetSize; i++) {
            bitSetList.get(i).set(data[i]);
        }
    }

    public boolean get(ServletRequest servletRequest) {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String IP = getIpAddr(request);

        int[] data = hash(IP);

        boolean exist = true;
        for (int i = 0; i < bitSetSize; i++) {
            exist = exist && bitSetList.get(i).get(data[i]);
        }
        if (!exist) set(IP);
        return exist;
    }

    public void clear(String IP) {

        int[] data = hash(IP);

        for (int i = 0; i < bitSetSize; i++) {
            bitSetList.get(i).clear(data[i]);
        }
    }

    public int[] hash(String IP) {

        int hash1 = HashCodeUtils.DJBHash(IP) % CAPACITY;
        int hash2 = HashCodeUtils.FNVHash(IP) % CAPACITY;
        int hash3 = HashCodeUtils.JSHash(IP) % CAPACITY;

        return new int[]{hash1, hash2, hash3};
    }

    public String getIpAddr(HttpServletRequest request) {

        String ip = request.getHeader("x-forwarded-for");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            ip = "127.0.0.1";
        }
        if (ip.split(",").length > 1) {
            ip = ip.split(",")[0];
        }
        return ip;
    }
}
