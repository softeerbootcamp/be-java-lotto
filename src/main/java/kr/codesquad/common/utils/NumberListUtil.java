package kr.codesquad.common.utils;

import java.util.Comparator;
import java.util.List;

public final class NumberListUtil {

  private NumberListUtil() {}

  public static int max(List<Integer> list) {
    return list.stream()
               .max(Comparator.naturalOrder())
               .orElseThrow(() -> new IllegalArgumentException("빈 컬렉션 입니다"));
  }

  public static int min(List<Integer> list) {
    return list.stream()
               .min(Comparator.naturalOrder())
               .orElseThrow(() -> new IllegalArgumentException("빈 컬렉션 입니다"));
  }

}
