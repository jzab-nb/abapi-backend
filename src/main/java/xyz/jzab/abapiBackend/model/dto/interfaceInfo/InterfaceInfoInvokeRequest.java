package xyz.jzab.abapiBackend.model.dto.interfaceInfo;

import lombok.Data;

/**
* @author  JZAB
*/
@Data
public class InterfaceInfoInvokeRequest {
    /**
     * 主鍵
     */
    private Long id;

    /**
     * 请求参数
     */
    private String userRequestParam;
}
