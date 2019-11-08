/*
 * This file is generated by jOOQ.
 */
package ua.worktimekeeper.model.dayoff.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import ua.worktimekeeper.model.dayoff.Indexes;
import ua.worktimekeeper.model.dayoff.Keys;
import ua.worktimekeeper.model.dayoff.Public;
import ua.worktimekeeper.model.dayoff.tables.records.UserManagerMappingRecord;


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
public class UserManagerMapping extends TableImpl<UserManagerMappingRecord> {

    private static final long serialVersionUID = -2000428437;

    /**
     * The reference instance of <code>public.user_manager_mapping</code>
     */
    public static final UserManagerMapping USER_MANAGER_MAPPING = new UserManagerMapping();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserManagerMappingRecord> getRecordType() {
        return UserManagerMappingRecord.class;
    }

    /**
     * The column <code>public.user_manager_mapping.um_manager_id</code>.
     */
    public final TableField<UserManagerMappingRecord, Long> UM_MANAGER_ID = createField(DSL.name("um_manager_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.user_manager_mapping.um_user_id</code>.
     */
    public final TableField<UserManagerMappingRecord, Long> UM_USER_ID = createField(DSL.name("um_user_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>public.user_manager_mapping</code> table reference
     */
    public UserManagerMapping() {
        this(DSL.name("user_manager_mapping"), null);
    }

    /**
     * Create an aliased <code>public.user_manager_mapping</code> table reference
     */
    public UserManagerMapping(String alias) {
        this(DSL.name(alias), USER_MANAGER_MAPPING);
    }

    /**
     * Create an aliased <code>public.user_manager_mapping</code> table reference
     */
    public UserManagerMapping(Name alias) {
        this(alias, USER_MANAGER_MAPPING);
    }

    private UserManagerMapping(Name alias, Table<UserManagerMappingRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserManagerMapping(Name alias, Table<UserManagerMappingRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> UserManagerMapping(Table<O> child, ForeignKey<O, UserManagerMappingRecord> key) {
        super(child, key, USER_MANAGER_MAPPING);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.USER_MANAGER_MAPPING_PK);
    }

    @Override
    public UniqueKey<UserManagerMappingRecord> getPrimaryKey() {
        return Keys.USER_MANAGER_MAPPING_PK;
    }

    @Override
    public List<UniqueKey<UserManagerMappingRecord>> getKeys() {
        return Arrays.<UniqueKey<UserManagerMappingRecord>>asList(Keys.USER_MANAGER_MAPPING_PK);
    }

    @Override
    public List<ForeignKey<UserManagerMappingRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UserManagerMappingRecord, ?>>asList(Keys.USER_MANAGER_MAPPING__UM_MANAGER_MAPPING_FK, Keys.USER_MANAGER_MAPPING__UM_USER_MAPPING_FK);
    }

    public UserDetails userManagerMapping_UmManagerMappingFk() {
        return new UserDetails(this, Keys.USER_MANAGER_MAPPING__UM_MANAGER_MAPPING_FK);
    }

    public UserDetails userManagerMapping_UmUserMappingFk() {
        return new UserDetails(this, Keys.USER_MANAGER_MAPPING__UM_USER_MAPPING_FK);
    }

    @Override
    public UserManagerMapping as(String alias) {
        return new UserManagerMapping(DSL.name(alias), this);
    }

    @Override
    public UserManagerMapping as(Name alias) {
        return new UserManagerMapping(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserManagerMapping rename(String name) {
        return new UserManagerMapping(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserManagerMapping rename(Name name) {
        return new UserManagerMapping(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, Long> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}