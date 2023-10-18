package xyz.jzab.abapiBackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import xyz.jzab.abapiBackend.model.dto.interfaceInfo.InterfaceInfoQueryRequest;
import xyz.jzab.abapiBackend.model.dto.post.PostQueryRequest;
import xyz.jzab.abapiBackend.model.entity.InterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import xyz.jzab.abapiBackend.model.entity.Post;
import xyz.jzab.abapiBackend.model.vo.InterfaceInfoVO;
import xyz.jzab.abapiBackend.model.vo.PostVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author 86131
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-10-07 21:45:23
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    /**
     * 校验字段信息
     * @param interfaceInfo
     * @param add
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

    QueryWrapper<InterfaceInfo> getQueryWrapper(InterfaceInfoQueryRequest interfaceInfoQueryRequest);

    /**
     * 获取接口信息封装
     *
     * @param interfaceInfo
     * @param request
     * @return
     */
    InterfaceInfoVO getInterfaceInfoVO(InterfaceInfo interfaceInfo, HttpServletRequest request);

    /**
     * 获取分页的接口信息
     *
     * @param interfaceInfoPage
     * @param request
     * @return
     */
    public Page<InterfaceInfoVO> getInterfaceInfoVOPage(Page<InterfaceInfo> interfaceInfoPage, HttpServletRequest request);
}
