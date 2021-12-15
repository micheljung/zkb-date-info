package ch.zkb.seecr.web.time

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import java.time.LocalDate

class DateInfoGeneratorTest {

  private val underTest = DateInfoGenerator()

  @Test
  fun `Friday 31 July is banking day`() {
    val date = LocalDate.of(2020, 7, 31)

    val result = underTest.generate(date, date).findFirst().get()

    result.date shouldBe date
    result.isLastBankingDayOfMonth shouldBe true
    result.type shouldBe DayType.BANKING_DAY
  }

  @Test
  fun `Saturday 31 July is weekend`() {
    val date = LocalDate.of(2021, 7, 31)

    val result = underTest.generate(date, date).findFirst().get()

    result.date shouldBe date
    result.isLastBankingDayOfMonth shouldBe false
    result.type shouldBe DayType.WEEKEND
  }

  @Test
  fun `Friday 30 July is last banking day of month`() {
    val date = LocalDate.of(2021, 7, 30)

    val result = underTest.generate(date, date).findFirst().get()

    result.date shouldBe date
    result.isLastBankingDayOfMonth shouldBe true
    result.type shouldBe DayType.BANKING_DAY
  }

  @Test
  fun `Mittwoch 24 December is last banking day`() {
    val date = LocalDate.of(2019, 12, 24)

    val result = underTest.generate(date, date).findFirst().get()

    result.date shouldBe date
    result.isLastBankingDayOfMonth shouldBe false
    result.type shouldBe DayType.BANKING_DAY
  }

  @Test
  fun `Mittwoch 29 December is last banking day`() {
    val date = LocalDate.of(2017, 12, 29)

    val result = underTest.generate(date, date).findFirst().get()

    result.date shouldBe date
    result.isLastBankingDayOfMonth shouldBe true
    result.type shouldBe DayType.BANKING_DAY
  }

  @Test
  fun `Thursday 25 December is holiday`() {
    val date = LocalDate.of(2019, 12, 25)

    val result = underTest.generate(date, date).findFirst().get()

    result.date shouldBe date
    result.isLastBankingDayOfMonth shouldBe false
    result.type shouldBe DayType.HOLIDAY
  }

  @Test
  fun `Friday 26 December is holiday`() {
    val date = LocalDate.of(2019, 12, 26)

    val result = underTest.generate(date, date).findFirst().get()

    result.date shouldBe date
    result.isLastBankingDayOfMonth shouldBe false
    result.type shouldBe DayType.HOLIDAY
  }

  @Test
  fun `Saturday 25 December is weekend`() {
    val date = LocalDate.of(2021, 12, 25)

    val result = underTest.generate(date, date).findFirst().get()

    result.date shouldBe date
    result.isLastBankingDayOfMonth shouldBe false
    result.type shouldBe DayType.WEEKEND
  }

  @Test
  fun `Sunday 26 December is weekend`() {
    val date = LocalDate.of(2021, 12, 26)

    val result = underTest.generate(date, date).findFirst().get()

    result.date shouldBe date
    result.isLastBankingDayOfMonth shouldBe false
    result.type shouldBe DayType.WEEKEND
  }

  @Test
  fun `Saturday 1 January is weekend`() {
    val date = LocalDate.of(2022, 1, 1)

    val result = underTest.generate(date, date).findFirst().get()

    result.date shouldBe date
    result.isLastBankingDayOfMonth shouldBe false
    result.type shouldBe DayType.WEEKEND
  }

  @Test
  fun `Sunday 2 January is weekend`() {
    val date = LocalDate.of(2022, 1, 2)

    val result = underTest.generate(date, date).findFirst().get()

    result.date shouldBe date
    result.isLastBankingDayOfMonth shouldBe false
    result.type shouldBe DayType.WEEKEND
  }

  @Test
  fun `Monday 1 January is Holiday`() {
    val date = LocalDate.of(2024, 1, 1)

    val result = underTest.generate(date, date).findFirst().get()

    result.date shouldBe date
    result.isLastBankingDayOfMonth shouldBe false
    result.type shouldBe DayType.HOLIDAY
  }

  @Test
  fun `Tuesday 2 January is Holiday`() {
    val date = LocalDate.of(2024, 1, 2)

    val result = underTest.generate(date, date).findFirst().get()

    result.date shouldBe date
    result.isLastBankingDayOfMonth shouldBe false
    result.type shouldBe DayType.HOLIDAY
  }

  @Test
  fun `Sunday 1 August is weekend`() {
    val date = LocalDate.of(2021, 8, 1)

    val result = underTest.generate(date, date).findFirst().get()

    result.date shouldBe date
    result.isLastBankingDayOfMonth shouldBe false
    result.type shouldBe DayType.WEEKEND
  }

  @Test
  fun `Monday 1 August is holiday`() {
    val date = LocalDate.of(2022, 8, 1)

    val result = underTest.generate(date, date).findFirst().get()

    result.date shouldBe date
    result.isLastBankingDayOfMonth shouldBe false
    result.type shouldBe DayType.HOLIDAY
  }

  @Test
  fun `Friday 29 March is last banking day`() {
    val date = LocalDate.of(2018, 3, 29)

    val result = underTest.generate(date, date).findFirst().get()

    result.date shouldBe date
    result.isLastBankingDayOfMonth shouldBe true
    result.type shouldBe DayType.BANKING_DAY
  }

  @Test
  fun `Friday 2 April is Easter`() {
    val date = LocalDate.of(2021, 4, 2)

    val result = underTest.generate(date, date).findFirst().get()

    result.date shouldBe date
    result.isLastBankingDayOfMonth shouldBe false
    result.type shouldBe DayType.HOLIDAY
  }

  @Test
  fun `Saturday 3 April is weekend`() {
    val date = LocalDate.of(2021, 4, 3)

    val result = underTest.generate(date, date).findFirst().get()

    result.date shouldBe date
    result.isLastBankingDayOfMonth shouldBe false
    result.type shouldBe DayType.WEEKEND
  }

  @Test
  fun `Sunday 4 April is weekend`() {
    val date = LocalDate.of(2021, 4, 4)

    val result = underTest.generate(date, date).findFirst().get()

    result.date shouldBe date
    result.isLastBankingDayOfMonth shouldBe false
    result.type shouldBe DayType.WEEKEND
  }

  @Test
  fun `Monday 5 April is weekend`() {
    val date = LocalDate.of(2021, 4, 5)

    val result = underTest.generate(date, date).findFirst().get()

    result.date shouldBe date
    result.isLastBankingDayOfMonth shouldBe false
    result.type shouldBe DayType.HOLIDAY
  }

  @Test
  fun `Friday 1 May is holiday`() {
    val date = LocalDate.of(2020, 5, 1)

    val result = underTest.generate(date, date).findFirst().get()

    result.date shouldBe date
    result.isLastBankingDayOfMonth shouldBe false
    result.type shouldBe DayType.HOLIDAY
  }

  @Test
  fun `Saturday 1 May is weekend`() {
    val date = LocalDate.of(2021, 5, 1)

    val result = underTest.generate(date, date).findFirst().get()

    result.date shouldBe date
    result.isLastBankingDayOfMonth shouldBe false
    result.type shouldBe DayType.WEEKEND
  }

  @Test
  fun `Thursday 13 May is weekend`() {
    val date = LocalDate.of(2021, 5, 13)

    val result = underTest.generate(date, date).findFirst().get()

    result.date shouldBe date
    result.isLastBankingDayOfMonth shouldBe false
    result.type shouldBe DayType.HOLIDAY
  }
}