package com.airconsole.wm_cms.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "page", schema = "ai_la_trieu_phu", catalog = "")
public class PageEntity {
    private int id;
    private String name;
    private String url;
    private String icon;
    private int parentId;
    private Byte menuIndex;

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
        PageEntity that = (PageEntity) o;
        return id == that.id &&
                parentId == that.parentId &&
                Objects.equals(name, that.name) &&
                Objects.equals(url, that.url) &&
                Objects.equals(icon, that.icon) &&
                Objects.equals(menuIndex, that.menuIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, url, icon, parentId, menuIndex);
    }
}
