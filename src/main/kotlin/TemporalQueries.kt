package ch.zkb.seecr.web.time

import java.time.DayOfWeek
import java.time.Month
import java.time.Year
import java.time.temporal.ChronoField
import java.time.temporal.TemporalQuery

class TemporalQueries {
  companion object {
    val isWeekend = TemporalQuery {
      it.get(ChronoField.DAY_OF_WEEK) == DayOfWeek.SATURDAY.value ||
        it.get(ChronoField.DAY_OF_WEEK) == DayOfWeek.SATURDAY.value
    }

    val isLastDayOfMonth =
      TemporalQuery {
        it.get(ChronoField.DAY_OF_MONTH) == Month.of(it.get(ChronoField.MONTH_OF_YEAR))
          .length(Year.of(it.get(ChronoField.YEAR)).isLeap)
      }
  }
}