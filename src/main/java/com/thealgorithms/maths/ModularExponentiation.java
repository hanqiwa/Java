package com.thealgorithms.maths;
public class ModularExponentiation {
  /**
   * Calculate modular exponentiation, exponentiation with modulus
   * @param x base number
   * @param y exponent
   * @param m modulus
   * @return (x^y)%m
   */
  public int modExp(int x, int y, int m) {
    int result = 1;
    if (m < 1) {
      throw new IllegalArgumentException("Modulus must be positive integer");
    }
    if (x == 0 || m == 1) {
      return 0;
    }
    while (y > 0) {
      if ((y & 1) == 1) {
        result = (result * x) % m;
      }
      y = y >> 1;
      x = (x * x) % m;
    }
    if (y == 0 && m > 1) {
      return 1;
    }
    return result;
  }
}
