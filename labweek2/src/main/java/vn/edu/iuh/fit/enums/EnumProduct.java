package vn.edu.iuh.fit.enums;

public enum EnumProduct {
    ACTIVE(1), NOACTIVE(0), FIRED(-1);

    private int status;
    EnumProduct(int status) {
        this.status = status;
    }
}
