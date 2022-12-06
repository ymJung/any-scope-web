package com.metalbird.anyscopeweb.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnyUtilsTest {

    @Test
    void sortComparator() {
        List<A> list = Arrays.asList(new A(2, "name2"), new A(1, "name1"), new A(2, "name1"));
        list.sort(AnyUtils.sortComparator("getRank", AnyUtils.SortDirection.ASC, A.class)
                .thenComparing(AnyUtils.sortComparator("getName", AnyUtils.SortDirection.DESC, A.class)));
        System.out.println(list);
        Assertions.assertEquals(list.get(0).rank , 1);

    }



    class A {
        int rank;
        String name;

        public A(int rank, String name) {
            this.rank = rank;
            this.name = name;
        }

        public int getRank() {
            return rank;
        }

        public String getName() {
            return name;
        }
    }
}