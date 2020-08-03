package base.permission;

// public > protected > default > private

public class Permission {
    // default 访问权限
    public int publicValue = 1;
    protected int protectedValue = 1;
    int defaultValue = 1;

    //default 访问权限，能在本包所有类可使用
    void defaultFunc() {
        System.out.println("This is a default function");
    }

    // 包内包外所有都可使用
    public void publicFunc() {
        System.out.println("This is a public function");
    }

    // 包外的子类可使用, 非子类不可使用
    // 包内所有类都可使用
    protected void protectedFunc() {
        System.out.println("This is a protected function");
    }

    // 仅本类可使用
    private void privateFunc() {
        System.out.println("This is a private function");
    }
}
