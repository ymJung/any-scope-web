package com.metalbird.anyscopeweb.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 수집플랫폼 전송용 저장 모델
     * 식별값, 메뉴ID, 결제금액
 */
@Getter
@Setter
@Entity
@Table(name="ORDER_HISTORY")
@NoArgsConstructor
public class OrderHistoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long orderHistoryId;
    @Column
    private Long userId;
    @Column
    private Long menuId;
    @Column
    private BigDecimal price;
    @Column
    private LocalDateTime createDt;

    public OrderHistoryEntity(Long userId, Long menuId, BigDecimal price, LocalDateTime createDt) {
        setUserId(userId);
        setMenuId(menuId);
        setPrice(price);
        setCreateDt(createDt);
    }
}
