package com.airconsole.wm_cms.model.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "pages", schema = "ai_la_trieu_phu", catalog = "")
public class PagesEntity {
    private int id;
    private int name;
    private String url;
    private String icon;
    private int parentId;
    private Byte menuIndex;
    private Collection<GroupPageRoleEntity> groupPageRolesById;
    private Collection<PageRoleEntity> pageRolesById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "parent_id")
    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "menu_index")
    public Byte getMenuIndex() {
        return menuIndex;
    }

    public void setMenuIndex(Byte menuIndex) {
        this.menuIndex = menuIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagesEntity that = (PagesEntity) o;
        return id == that.id &&
                name == that.name &&
                parentId == that.parentId &&
                Objects.equals(url, that.url) &&
                Objects.equals(icon, that.icon) &&
                Objects.equals(menuIndex, that.menuIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, url, icon, parentId, menuIndex);
    }

    @OneToMany(mappedBy = "pagesByPageId")
    public Collection<GroupPageRoleEntity> getGroupPageRolesById() {
        return groupPageRolesById;
    }

    public void setGroupPageRolesById(Collection<GroupPageRoleEntity> groupPageRolesById) {
        this.groupPageRolesById = groupPageRolesById;
    }

    @OneToMany(mappedBy = "pagesByPageId")
    public Collection<PageRoleEntity> getPageRolesById() {
        return pageRolesById;
    }

    public void setPageRolesById(Collection<PageRoleEntity> pageRolesById) {
        this.pageRolesById = pageRolesById;
    }
}
