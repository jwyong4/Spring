package com.codestates.hello_world;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/** Message Entity 클래스는 데이터베이스의 테이블 명에 해당한다.
 * @Id 가 지정된 멤버 변수는 해당 Entity 의 고유 식별자 역할을 하고,
 * 이 식별자는 데이터베이스의 primary key 로 지정된 컬럼에 해당된다.
 */
@Getter
@Setter
public class Message {
    @Id
    private long messageId;
    private String message;
}
