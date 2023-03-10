package com.metalbird.anyscopeweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="ORDER_INFO")
@Getter
@Setter
public class OrderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long orderId;
    @Column
    private Long menuId;
    @Column
    private Long userId;
    @Column
    private LocalDateTime orderTime;


    public static OrderEntity of(Long menuId, Long userId, LocalDateTime orderTime) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setMenuId(menuId);
        orderEntity.setOrderTime(orderTime);
        orderEntity.setUserId(userId);
        return orderEntity;
    }
}
