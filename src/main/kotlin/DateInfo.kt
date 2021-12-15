package ch.zkb.seecr.web.time

import java.time.LocalDate


data class DateInfo(
  val date: LocalDate,
  val type: DayType,
  val lastBankingDayOfMonth: Int? = null
)