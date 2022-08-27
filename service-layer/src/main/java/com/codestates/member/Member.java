package com.codestates.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // lombok 라이브러리의 애너테이션으로, getter/setter 메서드를 일일이 작성해주지 않아도 됨
@Setter
@NoArgsConstructor // 파라미터가 없는 기본 생성자를 자동으로 생성해줌
@AllArgsConstructor // 현재 Member 클래스에 추가된 모든 멤버 변수를 파라미터로 갖는 Member 생성자를 자동으로 생성해줌
public class Member {
    private long memberId;
    private String email;
    private String name;
    private String phone;
}
