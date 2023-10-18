package xyz.jzab.abapiBackend.model.enums;

public enum InterfaceInfoStatusEnum {
    ONLINE("上线",1),
    OFFLINE("下线", 0);

    private String name;
    private final Integer code;

    private InterfaceInfoStatusEnum(String name, Integer code){
        this.name = name;
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}