/*
 * This file is generated by jOOQ.
 */
package ua.worktimekeeper.model.dayoff.tables.pojos;


import java.io.Serializable;
import java.sql.Date;

import javax.annotation.processing.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Holidays implements Serializable {

    private static final long serialVersionUID = -1816660664;

    private final Long   hId;
    private final Date   hDate;
    private final String hName;
    private final String hDescription;

    public Holidays(Holidays value) {
        this.hId = value.hId;
        this.hDate = value.hDate;
        this.hName = value.hName;
        this.hDescription = value.hDescription;
    }

    public Holidays(
        Long   hId,
        Date   hDate,
        String hName,
        String hDescription
    ) {
        this.hId = hId;
        this.hDate = hDate;
        this.hName = hName;
        this.hDescription = hDescription;
    }

    public Long getHId() {
        return this.hId;
    }

    public Date getHDate() {
        return this.hDate;
    }

    public String getHName() {
        return this.hName;
    }

    public String getHDescription() {
        return this.hDescription;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Holidays (");

        sb.append(hId);
        sb.append(", ").append(hDate);
        sb.append(", ").append(hName);
        sb.append(", ").append(hDescription);

        sb.append(")");
        return sb.toString();
    }
}