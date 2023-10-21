package xyz.jzab.abapiBackend.model.dto.userInterfaceInfo;

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
public class UserInterfaceInfoQueryRequest extends PageRequest implements Serializable {
    /**
     * 主鍵
     */
    private Long id;

    /**
     * 调用用户ID
     */
    private Long userId;

    /**
     * 接口ID
     */
    private Long interfaceInfoId;

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