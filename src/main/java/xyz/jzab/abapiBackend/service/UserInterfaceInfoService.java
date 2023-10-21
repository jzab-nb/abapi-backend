package xyz.jzab.abapiBackend.service;

import xyz.jzab.abapiBackend.model.entity.InterfaceInfo;
import xyz.jzab.abapiBackend.model.entity.UserInterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86131
* @description 针对表【user_interface_info(用户接口调用关系)】的数据库操作Service
* @createDate 2023-10-19 15:43:33
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);
}
