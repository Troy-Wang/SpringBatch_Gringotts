package com.troywang.biz.model;

/**
 * Created by troywang on 2018/5/15.
 */
public class JobContextModel {

    private String foo;

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    @Override
    public String toString() {
        return "JobContextModel{" +
                "foo='" + foo + '\'' +
                '}';
    }
}
