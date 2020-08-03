package base._enum;

public enum MyEnum {
    UNDO(1), INIT(2), RUNNING(3), STOP(4), END(5);
    private final int code;

    // 默认private
    MyEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
