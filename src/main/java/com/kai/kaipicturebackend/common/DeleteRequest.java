package com.kai.kaipicturebackend.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用删除请求 —— 只传一个 id。
 *
 * 第 4 期任务：
 * 1. 理解为什么删除单独做一个请求类（而不是用 update 请求）
 * 2. 思考：删除接口是 GET 还是 POST？为什么删除不用 GET？
 */
@Data
public class DeleteRequest implements Serializable {

    /**
     * 要删除的数据 id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}
