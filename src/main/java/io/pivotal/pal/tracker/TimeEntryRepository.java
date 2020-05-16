package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.List;


public interface TimeEntryRepository {

    public TimeEntry create(TimeEntry any);

    public void delete(long timeEntryId);

    public TimeEntry update(long timeEntryId, TimeEntry expected);

    public TimeEntry find(long nonExistentTimeEntryId);

    public List<TimeEntry> list();
}
