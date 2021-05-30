package com.csp.design_patterns.singleton;

/**
 * @author csp
 * @description: TODO
 * @date 2019/10/8 22:20
 */
public enum SingletonEnum {
    INSTANCE;
    private String objName;

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public static void main(String[] args) {
        SingletonEnum firstSingleton = SingletonEnum.INSTANCE;
        firstSingleton.setObjName("firstName");
        System.out.println(firstSingleton.getObjName());
        SingletonEnum secondSingleton = SingletonEnum.INSTANCE;
        secondSingleton.setObjName("secondName");
        System.out.println(firstSingleton.getObjName());
        System.out.println(secondSingleton.getObjName());
        System.out.println(firstSingleton==secondSingleton);
    }
}
