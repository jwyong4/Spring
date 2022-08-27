package com.codestates.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;


@RestController
@RequestMapping("/v1/members")
@Validated
public class MemberController {
    private final MemberService memberService;

    public MemberController() {
        this.memberService = new MemberService(); // (1) Service 클래스를 이용하도록 객체 생성 후 메서드 호출
    }

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberDto) {
        // (2) 전달받은 DTO 클래스 정보를 MemberService의 updateMember() 메서드의 파라미터로 전달하기 위해 MemberPostDto 클래스의 정보를 Member 클래스에 넣음
        Member member = new Member();
        member.setEmail(memberDto.getEmail());
        member.setName(memberDto.getName());
        member.setPhone(memberDto.getPhone());
        // (3) 회원 정보 등록을 위해 MemberService 클래스의 creatMember() 메서드를 호출한다.
        Member response = memberService.createMember(member);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive long memberId,
                                      @Valid @RequestBody MemberPatchDto memberPatchDto) {
        memberPatchDto.setMemberId(memberId);
        // (4) 전달 받은 DTO 클래스 정보를 MemberService의 createMember() 메서드의 파라미터로 전달하기 위해 MemberPatchDto 클래스 정보를 Member 클래스에 넣음
        Member member = new Member();
        member.setMemberId(memberPatchDto.getMemberId());
        member.setName(memberPatchDto.getName());
        member.setPhone(memberPatchDto.getPhone());
        // (5) 회원 정보 수정을 위해 MemberService 클래스의 updateMember() 메서드를 호출한다.
        Member response = memberService.updateMember(member);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId) {
        // (6) 한명의 회원 정보 조회를 위해 MemberService 클래스의 findMember() 메서드를 호출한다. memberId를 파라미터로 넘겨줌
        Member response = memberService.findMember(memberId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers() {
        // (7) 모든 회원 정보를 조회하기 위해 MemberService 클래스의 findMember() 메서드를 호출한다.
        List<Member> response = memberService.findMembers();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive long memberId) {
        System.out.println("# deleted memberId");
        // (8) 한 명의 회원 정보를 삭제하기 위해 MemberService 클래스의 deleteMember() 메서드를 호출한다. memberId를 파라미터로 넘겨줌
        memberService.deleteMember(memberId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
