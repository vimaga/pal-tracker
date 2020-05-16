package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;

@Component
public class InMemoryTimeEntryRepository implements TimeEntryRepository{
    private HashMap<Long,TimeEntry> timeEntries = new HashMap<Long,TimeEntry>();
    private Long currentId = 1L;

    public TimeEntry create(TimeEntry timeEntry) {
        Long id=currentId++;
        TimeEntry createTimeEntry = new TimeEntry(id,timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
        timeEntries.put(id,createTimeEntry);
        return createTimeEntry;

    }

    public TimeEntry find(long id) {
       return timeEntries.get(id);
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        if(timeEntries.get(id)==null){
            return null;
        }
        timeEntry.setId(id);
        timeEntries.replace(id,timeEntry);
        return timeEntry;
    }

    public void delete(long id) {
        timeEntries.remove(id);
    }

    public List<TimeEntry> list(){

        return new ArrayList<>(timeEntries.values());
    }

}
