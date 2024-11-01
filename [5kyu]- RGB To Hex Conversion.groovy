class Kata {
  static String rgb(int r, int g, int b) {
    List<Integer> colours = [r,g,b]
    return colours.collect{ 
           String.format("%02x", Math.max(0, Math.min(255, it))).toUpperCase()
    }.join('')
  }
}