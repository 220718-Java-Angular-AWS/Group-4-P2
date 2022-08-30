package com.entities;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

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
    @OneToMany(mappedBy = "catalogDetails")
    private List<Catalog> catalogList;

    // constructors
    public CatalogDetails() {
    }

    public CatalogDetails(Integer catalogDetailsId, String catalogDetailsGroup, List<Catalog> catalogList) {
        this.catalogDetailsId = catalogDetailsId;
        this.catalogDetailsGroup = catalogDetailsGroup;
        this.catalogList = catalogList;
    }
    public CatalogDetails( String catalogDetailsGroup, List<Catalog> catalogList) {
        this.catalogDetailsGroup = catalogDetailsGroup;
        this.catalogList = catalogList;
    }

    public CatalogDetails( String catalogDetailsGroup) {
        this.catalogDetailsGroup = catalogDetailsGroup;
        this.catalogList = new LinkedList<>();
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
}
