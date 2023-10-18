package xyz.jzab.abapiBackend.common;

import java.io.Serializable;
import lombok.Data;

/**
 * ID请求
 *
 * @author JZAB
 * @from http://www.jzab.xyz/
 */
@Data
public class IdRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}