package com.canno.java18.io;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author Canno
 * @since 2018/7/2 11:00
 */
public class ByteArrayOSTest {

    @Test
    public void operatorTest(){
        System.out.println("3<<1=" + (3<<1));
        System.out.println("3>>1=" + (-3>>1));
        System.out.println("-3>>>1=" + (-3>>>1));
        System.out.println("-4>>>1=" + (-4>>>1));
        System.out.println();
    }

    public void byteArrayOSTest() throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        os.write("canno".getBytes());
        System.out.println(os.size());
    }
}
