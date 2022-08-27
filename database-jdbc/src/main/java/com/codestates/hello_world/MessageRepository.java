package com.codestates.hello_world;

import org.springframework.data.repository.CrudRepository;

/**
 * 데이터 액세스 계층에서 데이터베이스와 연동을 담당하는 인터페이스
 * CrudRepository 는 CRUD를 지원하는 Spring interface 이다.
 * <Message, Long> 제네릭 타입을 정해줌으로써 Entity 클래스에 담긴 데이터를 데이터베이스 테이블에 생성 또는 수정하거나,
 * 데이터베이스에서 조회한 데이터를 Entity 클래스로 변환할 수 있다.
 * Long 은 Entity 클래스 멤버 변수 중에 @Id 멤버 변수의 데이터 타입이다.
 */
public interface MessageRepository extends CrudRepository<Message, Long> {
}
