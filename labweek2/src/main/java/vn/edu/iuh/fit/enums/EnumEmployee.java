package vn.edu.iuh.fit.enums;

public enum EnumEmployee {
    ACTIVE(1), NOACTIVE(0), FIRED(-1);

    private int status;
    EnumEmployee(int status) {
        this.status = status;
    }
}
