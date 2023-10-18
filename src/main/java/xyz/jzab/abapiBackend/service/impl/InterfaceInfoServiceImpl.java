package xyz.jzab.abapiBackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import xyz.jzab.abapiBackend.common.ErrorCode;
import xyz.jzab.abapiBackend.constant.CommonConstant;
import xyz.jzab.abapiBackend.exception.BusinessException;
import xyz.jzab.abapiBackend.mapper.InterfaceInfoMapper;
import xyz.jzab.abapiBackend.model.dto.interfaceInfo.InterfaceInfoQueryRequest;
import xyz.jzab.abapiBackend.model.entity.InterfaceInfo;
import xyz.jzab.abapiBackend.model.entity.User;
import xyz.jzab.abapiBackend.model.vo.InterfaceInfoVO;
import xyz.jzab.abapiBackend.model.vo.UserVO;
import xyz.jzab.abapiBackend.service.InterfaceInfoService;
import xyz.jzab.abapiBackend.service.UserService;
import xyz.jzab.abapiBackend.utils.SqlUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
* @author 86131
* @description 针对表【interface_info(接口信息)】的数据库操作Service实现
* @createDate 2023-10-07 21:45:23
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {

    @Resource
    private UserService userService;

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        // 参数为空抛出异常
        if(interfaceInfo == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String name = interfaceInfo.getName();
        String url = interfaceInfo.getUrl();
        if(add){
            if(StringUtils.isAnyBlank(name)){
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
            if(StringUtils.isAnyBlank(url)){
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if(StringUtils.isNotBlank(name) && name.length() > 50){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }
        if(StringUtils.isNotBlank(url) && name.length() > 512){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "url过长");
        }
    }

    @Override
    public QueryWrapper<InterfaceInfo> getQueryWrapper(InterfaceInfoQueryRequest interfaceInfoQueryRequest) {
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>(  );
        if(interfaceInfoQueryRequest == null){
            return queryWrapper;
        }
        String name = interfaceInfoQueryRequest.getName( );
        String description = interfaceInfoQueryRequest.getDescription( );
        String url = interfaceInfoQueryRequest.getUrl( );
        Long id = interfaceInfoQueryRequest.getId();
        Integer status = interfaceInfoQueryRequest.getStatus( );
        String method = interfaceInfoQueryRequest.getMethod( );
        Long userId = interfaceInfoQueryRequest.getUserId( );
        String sortField = interfaceInfoQueryRequest.getSortField( );
        String sortOrder = interfaceInfoQueryRequest.getSortOrder( );

        queryWrapper.like(StringUtils.isNotBlank(name),"name",name);
        queryWrapper.like(StringUtils.isNotBlank(description),"description", description);
        queryWrapper.like(StringUtils.isNotBlank(url),"url",url);
        queryWrapper.eq(ObjectUtils.isNotEmpty(id),"id",id);
        queryWrapper.eq(ObjectUtils.isNotEmpty(status), "status", status);
        queryWrapper.eq(StringUtils.isNotBlank(method), "method", method);
        queryWrapper.eq(ObjectUtils.isNotEmpty(userId),"userId", userId);
        queryWrapper.eq("isDelete", false);
        queryWrapper.orderBy(SqlUtils.validSortField(sortField),sortOrder.equals(CommonConstant.SORT_ORDER_ASC),
                sortField);
        return queryWrapper;
    }

    @Override
    public InterfaceInfoVO getInterfaceInfoVO(InterfaceInfo interfaceInfo, HttpServletRequest request) {
        InterfaceInfoVO interfaceInfoVO = InterfaceInfoVO.objToVo(interfaceInfo);
        Long userId = interfaceInfo.getUserId();
        User user = null;
        if(userId!=null && userId > 0){
            user = userService.getById(userId);
        }
        UserVO userVO = userService.getUserVO(user);
        interfaceInfoVO.setUser(userVO);
        return interfaceInfoVO;
    }

    @Override
    public Page<InterfaceInfoVO> getInterfaceInfoVOPage(Page<InterfaceInfo> interfaceInfoPage, HttpServletRequest request) {
        List<InterfaceInfo> interfaceInfoList = interfaceInfoPage.getRecords();
        Page<InterfaceInfoVO> interfaceInfoVOPage = new Page<>(interfaceInfoPage.getCurrent(), interfaceInfoPage.getSize(), interfaceInfoPage.getTotal());
        if(CollectionUtils.isEmpty(interfaceInfoList)){
            return interfaceInfoVOPage;
        }
        Set<Long> userIdSet = interfaceInfoList.stream().map(InterfaceInfo::getUserId).collect(Collectors.toSet());
        Map<Long, List<User>> userIdUserListMap = userService.listByIds(userIdSet).stream()
                .collect(Collectors.groupingBy(User::getId));

        List<InterfaceInfoVO> interfaceInfoVOList = interfaceInfoList.stream().map(interfaceInfo -> {
            InterfaceInfoVO interfaceInfoVO = InterfaceInfoVO.objToVo(interfaceInfo);
            Long userId = interfaceInfo.getUserId();
            User user = null;
            if(userIdUserListMap.containsKey(userId)){
                user = userIdUserListMap.get(userId).get(0);
            }
            interfaceInfoVO.setUser(userService.getUserVO(user));
            return interfaceInfoVO;
        }).collect(Collectors.toList());
        interfaceInfoVOPage.setRecords(interfaceInfoVOList);
        return interfaceInfoVOPage;
    }
}



