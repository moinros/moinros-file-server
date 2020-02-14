package com.moinros.project.result.vo;

/**
 * 注释:
 *
 * @Author moinros
 * @Date 2020/2/14 22:36
 * @Verison 1.0
 */
public class WebResult<C, T> extends WebReply<C> {

    private T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
