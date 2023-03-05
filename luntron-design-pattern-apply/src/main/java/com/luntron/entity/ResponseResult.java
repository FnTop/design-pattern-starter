package com.luntron.entity;

import lombok.Data;

@Data
public class ResponseResult {
    private String data;
    private String code;
    private String msg;

    public static void main(String[] args) {
        System.out.println(0b111 & 0b001);
        System.out.println(0b111 & 0b010);
        System.out.println(0b111 ^ 0b001);
        System.out.println(0b001);
        System.out.println(2 << 62);
    }
}
