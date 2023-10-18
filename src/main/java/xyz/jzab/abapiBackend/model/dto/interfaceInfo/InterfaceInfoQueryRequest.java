package xyz.jzab.abapiBackend.model.dto.interfaceInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xyz.jzab.abapiBackend.common.PageRequest;

import java.io.Serializable;

/**
 * 查询请求
 *
 * @author JZAB
 * @from http://www.jzab.xyz/
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class InterfaceInfoQueryRequest extends PageRequest implements Serializable {
    /**
     * 主鍵
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 接口地址
     */
    private String url;

    /**
     * 请求参数
     */
    private String requestParam;

    /**
     * 请求头
     */
    private String requestHeader;

    /**
     * 响应头
     */
    private String responseHeader;

    /**
     * 接口状态 (0-关闭, 1-开启)
     */
    private Integer status;

    /**
     * 请求类型
     */
    private String method;

    /**
     * 创建人
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}