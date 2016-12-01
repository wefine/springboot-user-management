package org.wefine.ums.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Table(name = "sys_authorities")
@Entity
public class SysAuthorities implements GrantedAuthority {

    private String id;
    private String authorityName;
    private String authorityDesc;
    private String authorityCode;
    private boolean isEnabled;
    private Date createDate;
    private String createUserId;
    private boolean sys;
    private Collection<SysRoles> authority_roles;
    private Collection<SysResources> authority_resources;

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

    @Column(name = "authority_name")
    @Basic
    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    @Column(name = "authority_desc")
    @Basic
    public String getAuthorityDesc() {
        return authorityDesc;
    }

    public void setAuthorityDesc(String authorityDesc) {
        this.authorityDesc = authorityDesc;
    }

    @Column(name = "authority_code", unique = true)
    @Basic
    public String getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityCode(String authorityCode) {
        this.authorityCode = authorityCode;
    }

    @Column(name = "is_enabled")
    @Basic
    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @Column(name = "create_date")
    @Basic
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name = "create_user_id")
    @Basic
    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    @Column(name = "is_sys")
    @Basic
    public boolean isSys() {
        return sys;
    }

    public void setSys(boolean sys) {
        this.sys = sys;
    }

    @ManyToMany(mappedBy = "role_authorities", cascade = {CascadeType.MERGE,
            CascadeType.PERSIST})
    public Collection<SysRoles> getAuthority_roles() {
        return authority_roles;
    }

    public void setAuthority_roles(Collection<SysRoles> authority_roles) {
        this.authority_roles = authority_roles;
    }

    @JoinTable(name = "sys_authorities_resources", joinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "resource_id", referencedColumnName = "id", nullable = false))
    @ManyToMany(cascade = CascadeType.MERGE)
    public Collection<SysResources> getAuthority_resources() {
        return authority_resources;
    }

    public void setAuthority_resources(
            Collection<SysResources> authority_resources) {
        this.authority_resources = authority_resources;
    }

    @Override
    @Transient
    public String getAuthority() {
        return this.authorityCode; // To change body of implemented methods use
        // File | Settings | File Templates.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        SysAuthorities that = (SysAuthorities) o;

        if (isEnabled != that.isEnabled)
            return false;
        if (sys != that.sys)
            return false;
        if (authorityCode != null ? !authorityCode.equals(that.authorityCode)
                : that.authorityCode != null)
            return false;
        if (authorityDesc != null ? !authorityDesc.equals(that.authorityDesc)
                : that.authorityDesc != null)
            return false;
        if (authorityName != null ? !authorityName.equals(that.authorityName)
                : that.authorityName != null)
            return false;
        if (authority_resources != null ? !authority_resources
                .equals(that.authority_resources)
                : that.authority_resources != null)
            return false;
        if (createDate != null ? !createDate.equals(that.createDate)
                : that.createDate != null)
            return false;
        if (createUserId != null ? !createUserId.equals(that.createUserId)
                : that.createUserId != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result
                + (authorityName != null ? authorityName.hashCode() : 0);
        result = 31 * result
                + (authorityDesc != null ? authorityDesc.hashCode() : 0);
        result = 31 * result
                + (authorityCode != null ? authorityCode.hashCode() : 0);
        result = 31 * result + (isEnabled ? 1 : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result
                + (createUserId != null ? createUserId.hashCode() : 0);
        result = 31 * result + (sys ? 1 : 0);
        result = 31
                * result
                + (authority_resources != null ? authority_resources.hashCode()
                : 0);
        return result;
    }

}
