package com.tools;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.tools
 * @author dengchao
 * @date 2018/4/20
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author dengchao
 * @EnumName SexEnum
 * @Description 枚举描述
 * @date 2018/4/20
 */
public enum SexEnum {
    WOMAN((byte) 0, "女"), MAN((byte) 1, "男");

    /**
     * sex 性别
     */
    private String sex;

    /**
     * sexIndex 性别值
     */
    private Byte sexIndex;

    //封装
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Byte getSexIndex() {
        return sexIndex;
    }

    public void setSexIndex(Byte sexIndex) {
        this.sexIndex = sexIndex;
    }
    //构造方法


    SexEnum(Byte sexIndex, String sex) {
        this.sex = sex;
        this.sexIndex = sexIndex;
    }

    SexEnum() {

    }

    /**
     * @Title: findSexByIndex
     * @Description: 查询 sex 通过 对应sex 值
     * @author dengchao
     * @date 2018/4/20
     * @throw YnCorpSysException
     * @param: bytes sex值
     */

    public static String findSexByIndex(Byte bytes) {
        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.getSexIndex() == bytes) {
                return sexEnum.getSex();
            }
        }
        return null;
    }
}