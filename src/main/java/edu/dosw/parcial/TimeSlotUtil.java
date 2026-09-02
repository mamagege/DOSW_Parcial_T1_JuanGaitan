package edu.dosw.parcial;

/**
 * Parsea strings tipo "Martes 10:00 AM" -> día ("Martes") y hora en formato 24h (10).
 */
final class TimeSlotUtil {

    private TimeSlotUtil() {}

    static String extractDay(String timeSlot) {
        return timeSlot.trim().split("\\s+")[0];
    }

    static int extractHour24(String timeSlot) {
        String[] parts = timeSlot.trim().split("\\s+");
        String[] hourMinute = parts[1].split(":");
        int hour = Integer.parseInt(hourMinute[0]);
        String meridiem = parts[2].toUpperCase();

        if (meridiem.equals("PM") && hour != 12) {
            hour += 12;
        } else if (meridiem.equals("AM") && hour == 12) {
            hour = 0;
        }
        return hour;
    }
}
