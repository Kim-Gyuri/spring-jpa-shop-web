package hello.springshop.repository;

import hello.springshop.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderSearch {

    private String memberName; //회원이름 , 파라미터에 있으면 검색 조건이 된다.
    private OrderStatus orderStatus; //주문 상태:ORDER CANCEL
}
