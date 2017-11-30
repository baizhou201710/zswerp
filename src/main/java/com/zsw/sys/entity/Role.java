package com.zsw.sys.entity;

import com.zsw.base.BaseEntity;
import com.zsw.util.Empty;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @Author baizhou201710@gmail.com
 * @Description
 * @Date 2017/11/13 16:04
 */

public class Role extends BaseEntity {
    private String name;
    private String code;
    private String description;
    private Set<Permission> permissions;//一个角色对应多个权限


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getPermissionsName() {
        List<String> list = new ArrayList<String>();
        for (Iterator<Permission> it = permissions.iterator(); it.hasNext(); ) {
            list.add(it.next().getName());
        }

        return list;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", permissions=" + permissions +
                "} " + super.toString();
    }
}
