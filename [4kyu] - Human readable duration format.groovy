class Kata {
    final static Integer MINUTE = 60
    final static Integer HOUR = 60 * MINUTE
    final static Integer DAY = 24 * HOUR
    final static Integer YEAR = 365 * DAY

    static String formatDuration(Long seconds) {
        if (seconds < 1) return "now"  // Return "now" for negative or zero seconds

        List<String> timeParts = [
            calculateTime(seconds, YEAR, "year"),
            calculateTime(seconds % YEAR, DAY, "day"),
            calculateTime(seconds % DAY, HOUR, "hour"),
            calculateTime(seconds % HOUR, MINUTE, "minute"),
            calculateTime(seconds % MINUTE, 1, "second")
        ].minus(null)  // Remove null or empty components

        return formatOutput(timeParts)
    }

    static String calculateTime(Long seconds, Integer unit, String label) {
        Integer quantity = (Integer) (seconds / unit)
        return quantity > 0 ? "${quantity} ${label}${quantity > 1 ? 's' : ''}" : null
    }

    static String formatOutput(List<String> timeParts) {

        // Join parts with commas, then combine the last part with "and"
        return timeParts.size() == 1 ? timeParts.getAt(0) : 
               "${timeParts.dropRight(1).join(', ')} and ${timeParts.getAt(-1)}"
    }
}