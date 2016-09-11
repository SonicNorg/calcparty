package ru.hbsolutions.partyplanner.entity;

import javax.persistence.*;

@Entity
@Table(name = "FOOD")
public class Food {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "UNIT")
    @Enumerated(EnumType.STRING)
    private Unit unit;

    @Column(name = "COEFFICIENT")
    private Float coefficient;

    @Column(name = "SORT")
    private Integer sort;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Float coefficient) {
        this.coefficient = coefficient;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unit=" + unit +
                ", coefficient=" + coefficient +
                ", sort=" + sort +
                '}';
    }
}
