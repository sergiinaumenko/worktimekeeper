package ua.worktimekeeper.model.dayoff;

import org.apache.commons.lang3.time.DateUtils;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import ua.worktimekeeper.model.dayoff.tables.pojos.Holidays;
import ua.worktimekeeper.model.dayoff.tables.pojos.Request;
import ua.worktimekeeper.model.dayoff.tables.pojos.UserDetails;
import ua.worktimekeeper.model.dayoff.tables.pojos.UserGroups;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ua.worktimekeeper.model.dayoff.Sequences.HOLIDAYS_SEQ;
import static ua.worktimekeeper.model.dayoff.Sequences.REQUEST_SEQ;
import static ua.worktimekeeper.model.dayoff.Sequences.REQUEST_TYPE_SEQ;
import static ua.worktimekeeper.model.dayoff.Sequences.USER_DETAILS_SEQ;
import static ua.worktimekeeper.model.dayoff.Sequences.USER_GROUPS_SEQ;
import static ua.worktimekeeper.model.dayoff.Tables.REQUEST_TYPE;
import static ua.worktimekeeper.model.dayoff.Tables.USER_GROUPS;
import static ua.worktimekeeper.model.dayoff.tables.Holidays.HOLIDAYS;
import static ua.worktimekeeper.model.dayoff.tables.Request.REQUEST;
import static ua.worktimekeeper.model.dayoff.tables.UserDetails.USER_DETAILS;

@SpringBootTest
@ContextConfiguration(classes = DayOffModelTestConfiguration.class)
class DayOffModelTest {

    private static final String NAME = "User Name";
    private static final String EMAIL = "user_email@email.com";
    private static final String ROLE = "role";
    private static final String DESCRIPTION = "description";
    private static final String TYPE = "VACATION";
    private static final String STATUS = "NEW";
    private static final Date DATE = new Date(1573171200000L);
    private static final Timestamp START_TIMESTAMP = new Timestamp(1573203600000L);
    private static final Timestamp END_TIMESTAMP = new Timestamp(1573236000000L);
    private static final long DURATION = Duration.ofHours(8L).toSeconds();
    private static final String GROUP_NAME = "Group Name";

    @SuppressWarnings("unused")
    @Autowired
    private DSLContext dsl;

    @Test
    void userDetailsTest() {
        Long newId = dsl.nextval(USER_DETAILS_SEQ);
        dsl.insertInto(USER_DETAILS)
                .set(USER_DETAILS.USER_ID, newId)
                .set(USER_DETAILS.USER_NAME, NAME)
                .set(USER_DETAILS.USER_EMAIL, EMAIL)
                .set(USER_DETAILS.USER_ROLE, ROLE)
                .set(USER_DETAILS.USER_START_DATE, DATE)
                .set(USER_DETAILS.USER_WORKING_DAY_DURATION, DURATION)
                .execute();

        List<UserDetails> result = dsl.selectFrom(USER_DETAILS)
                .where(USER_DETAILS.USER_ID.eq(newId))
                .fetch()
                .into(UserDetails.class);

        assertEquals(1, result.size());
        UserDetails userDetails = result.get(0);
        assertEquals(NAME, userDetails.getUserName());
        assertEquals(EMAIL, userDetails.getUserEmail());
        assertEquals(ROLE, userDetails.getUserRole());
        assertTrue(DateUtils.isSameDay(userDetails.getUserStartDate(), DATE));
        assertEquals(DURATION, userDetails.getUserWorkingDayDuration().longValue());

        dsl.delete(USER_DETAILS)
                .where(USER_DETAILS.USER_ID.eq(newId))
                .execute();

        List<UserDetails> result2 = dsl.selectFrom(USER_DETAILS)
                .where(USER_DETAILS.USER_ID.eq(newId))
                .fetch()
                .into(UserDetails.class);

        assertEquals(0, result2.size());
    }

    @Test
    void holidaysTest() {
        Long newId = dsl.nextval(HOLIDAYS_SEQ);
        dsl.insertInto(HOLIDAYS)
                .set(HOLIDAYS.H_ID, newId)
                .set(HOLIDAYS.H_DATE, DATE)
                .set(HOLIDAYS.H_DESCRIPTION, DESCRIPTION)
                .set(HOLIDAYS.H_NAME, NAME)
                .execute();

        List<Holidays> result = dsl.selectFrom(HOLIDAYS)
                .where(HOLIDAYS.H_ID.eq(newId))
                .fetch()
                .into(Holidays.class);

        assertEquals(1, result.size());
        Holidays holidays = result.get(0);
        assertTrue(DateUtils.isSameDay(holidays.getHDate(), DATE));
        assertEquals(holidays.getHName(), NAME);
        assertEquals(holidays.getHDescription(), DESCRIPTION);

        dsl.delete(HOLIDAYS).where(HOLIDAYS.H_ID.eq(newId)).execute();

        List<Holidays> result2 = dsl.selectFrom(HOLIDAYS)
                .where(HOLIDAYS.H_ID.eq(newId))
                .fetch()
                .into(Holidays.class);

        assertEquals(0, result2.size());
    }

    @Test
    void requestTest() {
        Long userId = dsl.nextval(USER_DETAILS_SEQ);
        dsl.insertInto(USER_DETAILS)
                .set(USER_DETAILS.USER_ID, userId)
                .set(USER_DETAILS.USER_NAME, NAME)
                .set(USER_DETAILS.USER_EMAIL, EMAIL)
                .set(USER_DETAILS.USER_ROLE, ROLE)
                .set(USER_DETAILS.USER_START_DATE, DATE)
                .set(USER_DETAILS.USER_WORKING_DAY_DURATION, DURATION)
                .execute();

        Long typeId = dsl.nextval(REQUEST_TYPE_SEQ);
        dsl.insertInto(REQUEST_TYPE)
                .set(REQUEST_TYPE.RT_DESCRIPTION, DESCRIPTION)
                .set(REQUEST_TYPE.RT_TYPE, TYPE)
                .set(REQUEST_TYPE.RT_ID, typeId)
                .execute();

        Long requestId = dsl.nextval(REQUEST_SEQ);
        dsl.insertInto(REQUEST)
                .set(REQUEST.R_ID, requestId)
                .set(REQUEST.R_USER_ID, userId)
                .set(REQUEST.R_START_DATE, START_TIMESTAMP)
                .set(REQUEST.R_END_DATE, END_TIMESTAMP)
                .set(REQUEST.R_TYPE_ID, typeId)
                .set(REQUEST.R_STATUS, STATUS)
                .execute();

        List<Request> result = dsl.selectFrom(REQUEST)
                .where(REQUEST.R_ID.eq(requestId))
                .fetch()
                .into(Request.class);

        assertEquals(1, result.size());
        Request request = result.get(0);
        assertEquals(request.getRStartDate(), START_TIMESTAMP);
        assertEquals(request.getREndDate(), END_TIMESTAMP);
        assertEquals(request.getRStatus(), STATUS);
        assertEquals(request.getRTypeId(), typeId);
        assertEquals(request.getRUserId(), userId);

        dsl.delete(REQUEST).where(REQUEST.R_ID.eq(requestId)).execute();
        dsl.delete(REQUEST_TYPE).where(REQUEST_TYPE.RT_ID.eq(requestId)).execute();
        dsl.delete(USER_DETAILS).where(USER_DETAILS.USER_ID.eq(userId)).execute();

        List<Request> result2 = dsl.selectFrom(REQUEST)
                .where(REQUEST.R_ID.eq(requestId))
                .fetch()
                .into(Request.class);

        assertEquals(0, result2.size());
    }

    @Test
    void userGroupTest() {

        Long groupId = dsl.nextval(USER_GROUPS_SEQ);

        dsl.insertInto(USER_GROUPS)
                .set(USER_GROUPS.GROUP_ID, groupId)
                .set(USER_GROUPS.GROUP_DESCRIPTION, DESCRIPTION)
                .set(USER_GROUPS.GROUP_NAME, GROUP_NAME)
                .execute();

        List<UserGroups> result = dsl.selectFrom(USER_GROUPS)
                .where(USER_GROUPS.GROUP_ID.eq(groupId))
                .fetch()
                .into(UserGroups.class);

        assertEquals(1, result.size());
        UserGroups groups = result.get(0);
        assertEquals(GROUP_NAME, groups.getGroupName());
        assertEquals(DESCRIPTION, groups.getGroupDescription());

        dsl.delete(USER_GROUPS).where(USER_GROUPS.GROUP_ID.eq(groupId)).execute();

        List<UserGroups> result2 = dsl.selectFrom(USER_GROUPS)
                .where(USER_GROUPS.GROUP_ID.eq(groupId))
                .fetch()
                .into(UserGroups.class);

        assertEquals(0, result2.size());
    }
}
