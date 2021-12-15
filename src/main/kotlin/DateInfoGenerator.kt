package ch.zkb.seecr.web.time

import de.jollyday.HolidayManager
import de.jollyday.ManagerParameters
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters
import java.util.*
import java.util.stream.Stream

class DateInfoGenerator {

  private val holidayManager: HolidayManager =
    HolidayManager.getInstance(ManagerParameters.create(Locale("de", "CH")))

  fun generate(from: LocalDate, to: LocalDate): Stream<DateInfo> {
    val holidays = holidayManager.getHolidays(from, to, "zh").associateBy { it.date }

    return from.datesUntil(to.plusDays(1)).map {
      if (isWeekend(it)) {
        return@map DateInfo(it, DayType.WEEKEND)
      }

      val isHoliday = holidays[it] != null
      if (isHoliday) {
        return@map DateInfo(it, DayType.HOLIDAY)
      }

      val lastBankingDayOfMonth = determineBankingDayOfMonth(it, isHoliday)

      DateInfo(it, DayType.BANKING_DAY, lastBankingDayOfMonth)
    }
  }

  private fun determineBankingDayOfMonth(date: LocalDate, isHoliday: Boolean): Int? =
    if (isLastBankingDayOfMonth(date, isHoliday)) date.monthValue else null

  private fun isLastBankingDayOfMonth(date: LocalDate, isHoliday: Boolean) =
    !isHoliday && isThereAnyBankingDayUntilMonthEndAfter(date)

  private fun isThereAnyBankingDayUntilMonthEndAfter(date: LocalDate) =
    !date.query(TemporalQueries.isLastDayOfMonth) &&
      date.plusDays(1).datesUntil(date.with(TemporalAdjusters.firstDayOfNextMonth()))
        .anyMatch { isBankingDay(it) }

  private fun isBankingDay(date: LocalDate) =
    !isWeekend(date) && !holidayManager.isHoliday(date)

  private fun isWeekend(it: LocalDate) = it.query(TemporalQueries.isWeekend)
}