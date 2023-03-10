package com.metalbird.anyscopeweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "MENU")
@Getter
@Setter
public class MenuEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long menuId;
    @Column
    private String name;
    @Column
    private BigDecimal price;

    @Transient
    private Long orderCnt;

    public static MenuEntity of(String menuName, BigDecimal price) {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setPrice(price);
        menuEntity.setName(menuName);
        return menuEntity;
    }

}
