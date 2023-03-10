package com.metalbird.anyscopeweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="POINT")
@Getter
@Setter
public class PointEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long pointId;
    @Column(unique = true)
    private Long userId;
    @Column
    private BigDecimal point;

    public static PointEntity of(Long userId) {
        PointEntity pointEntity = new PointEntity();
        pointEntity.setUserId(userId);
        pointEntity.setPoint(BigDecimal.ZERO);
        return pointEntity;
    }
}
