package xyz.jzab.abapiBackend.model.dto.userInterfaceInfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 编辑请求
 *
 * @author JZAB
 * @from http://www.jzab.xyz/
 */
@Data
public class UserInterfaceInfoEditRequest implements Serializable {
    /**
     * 主鍵
     */
    private Long id;

    /**
     * 总调用次数
     */
    private Integer totalNum;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;

    /**
     * 0-正常,1-禁用
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}