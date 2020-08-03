package base;

import base.permission.Permission;
import org.junit.Test;


public class PermissionTest extends Permission {

    public static void main(String[] args) {
        // if is not a subclass, only public function and variable can be used
        Permission obj = new Permission();
        obj.publicFunc();
        System.out.println("this is a public value:" + obj.publicValue);

        // if is a subclass, public and protected function and variable can ba used
        PermissionTest permissionTest = new PermissionTest();
        permissionTest.publicFunc();
        permissionTest.protectedFunc();
        System.out.println("this is a public value:" + permissionTest.publicValue);
        System.out.println("this is a protected value:" + permissionTest.protectedValue);
    }

    @Test
    public void test() {
        String str = "aaaddccsccadeeea";
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            sb.append(ch);
            if (i < len - 1 && ch == str.charAt(i + 1)) {
                int j = i;
                int cnt = 0;
                while (j < len && str.charAt(j++) == ch) {
                    cnt++;
                }
                sb.append(cnt);
                i = j - 2;
            }
        }
        System.out.println(sb.toString());
    }
}
