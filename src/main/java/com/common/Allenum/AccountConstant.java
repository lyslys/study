package com.common.Allenum;

public class AccountConstant {

    public enum MonthAccountStatusEnum {

        NOT_OPEN((byte) 0, "未开通"),
        UNPAID((byte) 1, "未欠款"),
        REPAYMENT((byte) 2, "待还款"),
        FROZEN((byte) 3, "已冻结"),
        DEFERRED((byte) 4, "已延期")
        ;

        MonthAccountStatusEnum(Byte type, String text) {
            this.value = type;
            this.text = text;
        }

        private Byte value;
        private String text;

        public Byte getValue() {
            return value;
        }

        public String getText() {
            return text;
        }

        public static MonthAccountStatusEnum getEnum(Byte type) {
            MonthAccountStatusEnum e = MonthAccountStatusEnum.NOT_OPEN;
            if (type != null) {
                for (MonthAccountStatusEnum o : MonthAccountStatusEnum.values()) {
                    if (o.getValue().equals(type)) {
                        e = o;
                        return e;
                    }
                }
            }
            return e;
        }
    }

    public static void main(String[] args) {
        System.out.println(AccountConstant.MonthAccountStatusEnum.getEnum((byte)1).getText());
    }

}
