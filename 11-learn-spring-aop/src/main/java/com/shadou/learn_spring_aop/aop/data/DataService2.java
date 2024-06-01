package com.shadou.learn_spring_aop.aop.data;

import org.springframework.stereotype.Service;

@Service
public class DataService2 {

    public int[] retrieveData() {
        return new int[] {100, 200 , 300, 400, 500};
    }
}
