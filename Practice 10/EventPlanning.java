import java.util.ArrayList;
import java.util.Arrays;

class EventPlanning {
    public static void main(String[] args) {
        EventRegistry er = new EventRegistry();
        er.add(new Event(1, "D", "D", "A", "D", 202101011800L));
        er.add(new Event(2, "D", "E", "C", "D", 202201011800L));
        er.add(new Event(3, "A", "A", "C", "D", 202001011800L));
        er.add(new Event(3, "A", "A", "C", "D", 202101011800L));
        er.add(new Event(3, "A", "A", "C", "D", 201901011800L));
        er.add(new Event(4, "B", "A", "A", "D", 202301011800L));
        er.add(new Event(5, "B", "B", "B", "D", 202401011800L));
        er.add(new Event(6, "B", "B", "A", "D", 201901011800L));
        er.add(new Event(7, "B", "B", "C", "D", 201801011800L));
        System.out.println(er.getEventsByDate(20190101L, 20220101L).toString() + "\n\n");
        System.out.println(er.sort().toString());
    }
}

class Event {
    private final int id;
    private final String name;
    private final String location;
    private final String organizer;
    private final String type;
    private final long datetime; //yyyymmddhhmm

    public Event(int id, String name, String location, String type, String organizer, long datetime) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.organizer = organizer;
        this.type = type;
        this.datetime = datetime;
    }

    public Event(Event e) {
        this.id = e.id;
        this.name = e.name;
        this.location = e.location;
        this.organizer = e.organizer;
        this.type = e.type;
        this.datetime = e.datetime;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getOrganizer() {
        return organizer;
    }

    public String getType() {
        return type;
    }

    public long getDatetime() {
        return datetime;
    }

    public long getDate() {
        return getDatetime() / 10000; //date = (long) yyyymmdd.hhmm = yyyymmdd
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", organizer='" + organizer + '\'' +
                ", type='" + type + '\'' +
                ", datetime=" + datetime +
                '}';
    }
}

class EventRegistry {
    private final ArrayList<Event> events = new ArrayList<>();

    public EventRegistry() {}

    public EventRegistry(Event[] events) {
        this.events.addAll(Arrays.asList(events));
    }

    public void add(Event e) {
        events.add(new Event(e));
    }


    public EventRegistry sort() {
        ArrayList<Event> e = new ArrayList<>(events);
        e.sort((e1, e2) -> {
            if (e1.getDatetime() != e2.getDatetime())
                return e1.getDatetime() > e2.getDatetime() ? 1 : -1;

            if (e1.getLocation().compareTo(e2.getLocation()) != 0)
                return e1.getLocation().compareTo(e2.getLocation());

            if (e1.getType().compareTo(e2.getType()) != 0)
                return e1.getType().compareTo(e2.getType());

            return 0;
        });
        return new EventRegistry(e.toArray(new Event[0]));
    }

    private Event[] getEventsList() {
        return events.toArray(new Event[0]);
    }

    public EventRegistry getEventsByLocation(String location) {
        EventRegistry result = new EventRegistry();

        for(Event e : events) {
            if(e.getLocation().equalsIgnoreCase(location))
                result.add(e);
        }

        return result;
    }

    public EventRegistry getEventsByDate(long date) {
        EventRegistry result = new EventRegistry();

        for(Event e : events) {
            if(e.getDate() == date)
                result.add(e);
        }

        return result;
    }

    public EventRegistry getEventsByDate(long fromDate, long toDate) {
        ArrayList<Event> res = new ArrayList<>();

        for(Event e : events) {
            if(e.getDate() >= fromDate && e.getDate() <= toDate)
                res.add(e);
        }

        return new EventRegistry(res.toArray(new Event[0])).sort();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for(Event e : events) {
            res.append(e.toString());
            res.append("\n");
        }
        return res.toString();
    }
}