package org.wefine.ums.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@Table(name = "sys_menus")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
public class SysMenus implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String iconStyle;
    private String code;
    private Integer menuIndex;
    private int deep;
    private String roleId;
    private boolean sys;
    private String url;
    private SysMenus parent;
    private Collection<SysMenus> children;
    private SysResources rescources;

    @Column(name = "id")
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "name")
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "icon_style")
    @Basic
    public String getIconStyle() {
        return iconStyle;
    }

    public void setIconStyle(String iconStyle) {
        this.iconStyle = iconStyle;
    }

    @Column(name = "code")
    @Basic
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "menu_index")
    @Basic
    public Integer getMenuIndex() {
        return menuIndex;
    }

    public void setMenuIndex(Integer menuIndex) {
        this.menuIndex = menuIndex;
    }

    @Column(name = "deep")
    @Basic
    public int getDeep() {
        return deep;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }

    @Column(name = "role_id")
    @Basic
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Column(name = "sys")
    @Basic
    public boolean isSys() {
        return sys;
    }

    public void setSys(boolean sys) {
        this.sys = sys;
    }

    @Column(name = "url")
    @Basic
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysMenus mSysMenus = (SysMenus) o;

        if (deep != mSysMenus.deep) return false;
        if (menuIndex != mSysMenus.menuIndex) return false;
        if (sys != mSysMenus.sys) return false;
        if (code != null ? !code.equals(mSysMenus.code) : mSysMenus.code != null) return false;
        if (iconStyle != null ? !iconStyle.equals(mSysMenus.iconStyle) : mSysMenus.iconStyle != null) return false;
        if (id != null ? !id.equals(mSysMenus.id) : mSysMenus.id != null) return false;
        if (name != null ? !name.equals(mSysMenus.name) : mSysMenus.name != null) return false;
        if (roleId != null ? !roleId.equals(mSysMenus.roleId) : mSysMenus.roleId != null) return false;
        if (url != null ? !url.equals(mSysMenus.url) : mSysMenus.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (iconStyle != null ? iconStyle.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + menuIndex;
        result = 31 * result + deep;
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        result = 31 * result + (sys ? 1 : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    @JsonIgnore
    public SysMenus getParent() {
        return parent;
    }

    public void setParent(SysMenus parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    public Collection<SysMenus> getChildren() {
        return children;
    }

    public void setChildren(Collection<SysMenus> children) {
        this.children = children;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_id")
    public SysResources getRescources() {
        return rescources;
    }

    public void setRescources(SysResources rescources) {
        this.rescources = rescources;
    }


}
