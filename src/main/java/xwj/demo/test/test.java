package xwj.demo.test;

import com.xiaoleilu.hutool.util.ObjectUtil;
import xwj.demo.entity.Cat;

public class test {
    public static void main(String[] args) {
        Cat cat = new Cat("test",1);
        Cat cat1 = ObjectUtil.cloneByStream(cat);
        System.out.println(cat1);
    }
}
