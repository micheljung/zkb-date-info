package ch.zkb.seecr.web.time

enum class DayType(val id: Int, val title: String) {
    BANKING_DAY(1, "Bankwerktag"),
    WEEKEND(2, "Wochenende"),
    HOLIDAY(3, "Feiertag");
}