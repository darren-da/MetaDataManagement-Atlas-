package com.limp.framework.core.bean;


public enum EncryptedType {
    /**
     *
     */
    MD5("MD5"),
    /**
     *
     */
    SHA_1("SHA-1"),
    /**
     *
     */
    AES("AES");

    private String value;

    private EncryptedType(String en) {
        this.value = en;
    }

    @Override
    public String toString() {
        return this.value;
    }
}