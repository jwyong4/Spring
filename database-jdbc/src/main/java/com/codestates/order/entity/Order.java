package com.codestates.order.entity;

import com.codestates.coffee.entity.CoffeeRef;
import com.codestates.member.entity.Member;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

// TODO V10
@Getter
@Setter
@Table("ORDERS") // 해당 애너테이션을 추가하지 않으면 클래스명과 테이블의 이름이 매핑된다.
public class Order {
    @Id // 해당 애너테이션을 붙여 식별자로 지정. ORDERS 테이블과 매핑
    private long orderId;

    /** Aggregate Root 간의 참조를 위한 클래스. 테이블 외래키처럼 memberId를 추가해서 참조하도록 한다. */
    private AggregateReference<Member, Long> memberId;

    /** 동일 Aggregate 내의 다른 Entity 객체가 Aggregate 객체를 참조하기 위한 Entity_ID로 외래키를 지정 */
    @MappedCollection(idColumn = "ORDER_ID")
    /** Aggregate Root 에서 동일 Aggregate Entity 객체를 참조하기 위한 변수 */
    private Set<CoffeeRef> orderCoffees = new LinkedHashSet<>();

    /** 주문 상태를 나타내는 멤버 변수. enum 타입이며, 기본 값은 ORDER_REQUEST 이다. */
    private OrderStatus orderStatus = OrderStatus.ORDER_REQUEST;

    /** 주문이 등록되는 시간 정보를 나타내는 멤버 변수. LocalDateTime 타입이다. */
    private LocalDateTime createdAt;

    public enum OrderStatus {
        ORDER_REQUEST(1, "주문 요청"),
        ORDER_CONFIRM(2, "주문 확정"),
        ORDER_COMPLETE(3, "주문 완료"),
        ORDER_CANCEL(4, "주문 취소");

        @Getter
        private int stepNumber;

        @Getter
        private String stepDescription;

        OrderStatus(int stepNumber, String stepDescription) {
            this.stepNumber = stepNumber;
            this.stepDescription = stepDescription;
        }
    }
}

