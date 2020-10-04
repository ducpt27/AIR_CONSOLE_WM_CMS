package com.airconsole.wm_cms.model.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Page {
    private int id;
    private String name;
    private String url;
    private String icon;
    private int parentId;
    private Byte menuIndex;
    private Collection<GroupPageRole> groupPageRolesById;
    private Collection<PageRole> pageRolesById;

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
    public String getName() {
        return name;
    }

    public void setName(String name) {
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
        Page page = (Page) o;
        return id == page.id &&
                parentId == page.parentId &&
                Objects.equals(name, page.name) &&
                Objects.equals(url, page.url) &&
                Objects.equals(icon, page.icon) &&
                Objects.equals(menuIndex, page.menuIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, url, icon, parentId, menuIndex);
    }

    @OneToMany(mappedBy = "pageByPageId")
    public Collection<GroupPageRole> getGroupPageRolesById() {
        return groupPageRolesById;
    }

    public void setGroupPageRolesById(Collection<GroupPageRole> groupPageRolesById) {
        this.groupPageRolesById = groupPageRolesById;
    }

    @OneToMany(mappedBy = "pageByPageId")
    public Collection<PageRole> getPageRolesById() {
        return pageRolesById;
    }

    public void setPageRolesById(Collection<PageRole> pageRolesById) {
        this.pageRolesById = pageRolesById;
    }
}
