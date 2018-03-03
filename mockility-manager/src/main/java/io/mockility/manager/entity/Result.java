package io.mockility.manager.entity;

/**
 * Don't worry be happy
 * Created by liangwei on 3/1/18
 */

public class Result<T> {
    private T data;

    public Result(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
