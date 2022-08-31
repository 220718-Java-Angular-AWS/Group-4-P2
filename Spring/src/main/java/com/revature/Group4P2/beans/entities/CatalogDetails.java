package com.revature.Group4P2.beans.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "catalog_details")
public class CatalogDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalog_details_id")
    private Integer catalogDetailsId; // the groups

    @Column(name="catalog_details_group")
    private String catalogDetailsGroup;

    // foreign key references passed
    // has a one to many reference
    @OneToMany(mappedBy = "catalogDetails",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Catalog> catalogList;

    // constructors
    public CatalogDetails() {
    }

    public CatalogDetails(Integer catalogDetailsId, String catalogDetailsGroup) {
        this.catalogDetailsId = catalogDetailsId;
        this.catalogDetailsGroup = catalogDetailsGroup;
    }

    public CatalogDetails( String catalogDetailsGroup) {
        this.catalogDetailsGroup = catalogDetailsGroup;
    }

    // getters and setters


    public Integer getCatalogDetailsId() {
        return catalogDetailsId;
    }

    public void setCatalogDetailsId(Integer catalogDetailsId) {
        this.catalogDetailsId = catalogDetailsId;
    }

    public String getCatalogDetailsGroup() {
        return catalogDetailsGroup;
    }

    public void setCatalogDetailsGroup(String catalogDetailsGroup) {
        this.catalogDetailsGroup = catalogDetailsGroup;
    }

    public List<Catalog> getCatalogList() {
        return catalogList;
    }

    public void setCatalogList(List<Catalog> catalogList) {
        this.catalogList = catalogList;
    }

    @Override
    public String toString() {
        return "CatalogDetails{" +
                "catalogDetailsId=" + catalogDetailsId +
                ", catalogDetailsGroup='" + catalogDetailsGroup + '\'' +
                ", catalogList=" + catalogList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogDetails that = (CatalogDetails) o;
        return Objects.equals(catalogDetailsId, that.catalogDetailsId) && Objects.equals(catalogDetailsGroup, that.catalogDetailsGroup) && Objects.equals(catalogList, that.catalogList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalogDetailsId, catalogDetailsGroup, catalogList);
    }


}
