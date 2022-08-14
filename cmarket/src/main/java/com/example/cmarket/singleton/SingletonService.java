package com.example.cmarket.singleton;

public class SingletonService {

    // 1. static 영역에 객체를 1개만 생성한다.
    private static final SingletonService instance = new SingletonService();

    // 2. 객체 인스턴스가 필요하면 public static 메서드를 통해서만 조회할 수 있도록 한다.
    public static SingletonService getInstance() {
        return instance;
    }

    //
    private SingletonService() {
    }
}
