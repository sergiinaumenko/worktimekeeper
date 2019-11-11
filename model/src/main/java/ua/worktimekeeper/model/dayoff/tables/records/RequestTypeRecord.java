/*
 * This file is generated by jOOQ.
 */
package ua.worktimekeeper.model.dayoff.tables.records;


import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;

import ua.worktimekeeper.model.dayoff.tables.RequestType;


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
public class RequestTypeRecord extends UpdatableRecordImpl<RequestTypeRecord> implements Record3<Long, String, String> {

    private static final long serialVersionUID = 1664970514;

    /**
     * Setter for <code>public.request_type.rt_id</code>.
     */
    public RequestTypeRecord setRtId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.request_type.rt_id</code>.
     */
    public Long getRtId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.request_type.rt_type</code>.
     */
    public RequestTypeRecord setRtType(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.request_type.rt_type</code>.
     */
    public String getRtType() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.request_type.rt_description</code>.
     */
    public RequestTypeRecord setRtDescription(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.request_type.rt_description</code>.
     */
    public String getRtDescription() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Long, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return RequestType.REQUEST_TYPE.RT_ID;
    }

    @Override
    public Field<String> field2() {
        return RequestType.REQUEST_TYPE.RT_TYPE;
    }

    @Override
    public Field<String> field3() {
        return RequestType.REQUEST_TYPE.RT_DESCRIPTION;
    }

    @Override
    public Long component1() {
        return getRtId();
    }

    @Override
    public String component2() {
        return getRtType();
    }

    @Override
    public String component3() {
        return getRtDescription();
    }

    @Override
    public Long value1() {
        return getRtId();
    }

    @Override
    public String value2() {
        return getRtType();
    }

    @Override
    public String value3() {
        return getRtDescription();
    }

    @Override
    public RequestTypeRecord value1(Long value) {
        setRtId(value);
        return this;
    }

    @Override
    public RequestTypeRecord value2(String value) {
        setRtType(value);
        return this;
    }

    @Override
    public RequestTypeRecord value3(String value) {
        setRtDescription(value);
        return this;
    }

    @Override
    public RequestTypeRecord values(Long value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RequestTypeRecord
     */
    public RequestTypeRecord() {
        super(RequestType.REQUEST_TYPE);
    }

    /**
     * Create a detached, initialised RequestTypeRecord
     */
    public RequestTypeRecord(Long rtId, String rtType, String rtDescription) {
        super(RequestType.REQUEST_TYPE);

        set(0, rtId);
        set(1, rtType);
        set(2, rtDescription);
    }
}
