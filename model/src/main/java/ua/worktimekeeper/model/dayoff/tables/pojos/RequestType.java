/*
 * This file is generated by jOOQ.
 */
package ua.worktimekeeper.model.dayoff.tables.pojos;


import java.io.Serializable;

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
public class RequestType implements Serializable {

    private static final long serialVersionUID = 873783857;

    private final Long   rtId;
    private final String rtType;
    private final String rtDescription;

    public RequestType(RequestType value) {
        this.rtId = value.rtId;
        this.rtType = value.rtType;
        this.rtDescription = value.rtDescription;
    }

    public RequestType(
        Long   rtId,
        String rtType,
        String rtDescription
    ) {
        this.rtId = rtId;
        this.rtType = rtType;
        this.rtDescription = rtDescription;
    }

    public Long getRtId() {
        return this.rtId;
    }

    public String getRtType() {
        return this.rtType;
    }

    public String getRtDescription() {
        return this.rtDescription;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("RequestType (");

        sb.append(rtId);
        sb.append(", ").append(rtType);
        sb.append(", ").append(rtDescription);

        sb.append(")");
        return sb.toString();
    }
}
