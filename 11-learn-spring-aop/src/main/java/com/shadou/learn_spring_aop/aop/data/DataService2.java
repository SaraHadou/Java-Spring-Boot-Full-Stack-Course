package com.shadou.learn_spring_aop.aop.data;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class DataService2 {

    public int[] retrieveData() {

        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new int[] {100, 200 , 300, 400, 500};
    }
}
