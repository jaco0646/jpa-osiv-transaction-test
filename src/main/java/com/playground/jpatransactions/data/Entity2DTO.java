package com.playground.jpatransactions.data;

public interface Entity2DTO {

    interface Get {
        int getId();
        boolean getB1();
        Boolean getB2();
    }

    interface GetIs {
        int getId();
        boolean getIsB1();
        Boolean getIsB2();
    }

    interface IsGet {
        int getId();

        boolean isB1();
        Boolean isB2();

        boolean getB1();
        Boolean getB2();
    }
}
