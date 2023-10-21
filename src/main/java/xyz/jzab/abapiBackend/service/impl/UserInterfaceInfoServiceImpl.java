package xyz.jzab.abapiBackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import xyz.jzab.abapiBackend.model.entity.UserInterfaceInfo;
import xyz.jzab.abapiBackend.service.UserInterfaceInfoService;
import xyz.jzab.abapiBackend.mapper.UserInterfaceInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author 86131
* @description 针对表【user_interface_info(用户接口调用关系)】的数据库操作Service实现
* @createDate 2023-10-19 15:43:33
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService{

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {

    }
}




