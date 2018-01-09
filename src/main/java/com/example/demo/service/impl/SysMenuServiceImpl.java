package com.example.demo.service.impl;

import com.example.demo.dao.SysMenuDao;
import com.example.demo.entity.SysMenuEntity;
import com.example.demo.service.SysMenuService;
import com.example.demo.service.SysUserService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by panbingcan on 2018/1/9.
 */
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuDao sysMenuDao;
    @Autowired
    private SysUserService sysUserService;

    @Override
    public Set<String> getUserPermissions(long userId) {
        List<String> permsListl;
        //系統管理員 擁有最高權限
        if (userId == 1) {
            List<SysMenuEntity> menuList = queryList(new HashMap<>());
            permsListl = new ArrayList<>(menuList.size());
            for (SysMenuEntity menu : menuList)
                permsListl.add(menu.getPerms());
        } else
            permsListl = sysUserService.queryAllPerms(userId);
        //用戶權限列表
        Set<String> permsSet = new HashSet<>();
        for (String perms : permsListl) {
            if (StringUtils.isBlank(perms))
                continue;
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

    @Override
    public List<SysMenuEntity> queryList(Map<String, Object> map) {
        return sysMenuDao.queryList(map);
    }
}
