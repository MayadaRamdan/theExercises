package org.example.exercises.primesandnonprimes;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.*;

import static org.example.exercises.primesandnonprimes.PrimeNonPrimePartitioner.isPrime;


public class PrimeNonPrimeCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, Integer>> {

    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        // توفير خريطة تحتوي على قائمتين: واحدة للأعداد الأولية والأخرى للأعداد غير الأولية
        return () -> new HashMap<Boolean, List<Integer>>() {{
            put(true, new ArrayList<>()); // قائمة الأعداد الأولية
            put(false, new ArrayList<>()); // قائمة الأعداد غير الأولية
        }};
    }

    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        // إضافة العدد إلى القائمة المناسبة (أولي أو غير أولي)
        return (map, value) -> {
            if (isPrime(value)) {
                map.get(true).add(value); // إضافة العدد إلى الأعداد الأولية
            } else {
                map.get(false).add(value); // إضافة العدد إلى الأعداد غير الأولية
            }
        };
    }

    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        // دمج الخريطتين في حالة المعالجة المتوازية
        return (map1, map2) -> {
            map1.get(true).addAll(map2.get(true));
            map1.get(false).addAll(map2.get(false));
            return map1;
        };
    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, Integer>> finisher() {
        // بعد التجميع، نحسب مجموع الأعداد الأولية وناتج ضرب الأعداد غير الأولية
        return map -> {
            int sumPrimes = map.get(true).stream().mapToInt(Integer::intValue).sum(); // مجموع الأعداد الأولية
            int productNonPrimes = map.get(false).stream().reduce(1, (a, b) -> a * b); // ضرب الأعداد غير الأولية
            return new HashMap<Boolean, Integer>() {{
                put(true, sumPrimes); // تخزين مجموع الأعداد الأولية
                put(false, productNonPrimes); // تخزين ناتج ضرب الأعداد غير الأولية
            }};
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        // نتركها فارغة أو نعيد خصائص معينة إذا كان لدينا حاجة
        return Collections.emptySet();
    }
}



