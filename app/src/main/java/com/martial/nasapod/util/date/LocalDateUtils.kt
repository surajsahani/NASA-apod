package com.martial.nasapod.util.date


import com.martial.nasapod.data.model.PictureDetail
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * Convenience method to convert a [String] conforming with [DateTimeFormatter.ISO_DATE] format
 * into [LocalDate]
 */
fun String.toLocalDate(): LocalDate {
  return LocalDate.parse(this, DateTimeFormatter.ISO_DATE)
}

/**
 * A [Comparator] that can take two [PictureDetail]s and sort them based on their date.
 */
object PictureDetailComparator : Comparator<PictureDetail> {
  override fun compare(first: PictureDetail, second: PictureDetail): Int {
    val firstTime = first.date.toLocalDate()
    val secondTime = second.date.toLocalDate()
    return when {
      firstTime.isAfter(secondTime) -> {
        1
      }
      firstTime.isBefore(secondTime) -> {
        -1
      }
      else -> {
        0
      }
    }
  }
}
