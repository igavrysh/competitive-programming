# 4. Game Optimization

В ігровій індустрії часто доводиться мати справу з тригонометричними ф-ми.Ваша задача пришвидшити код який обчислює `sin(x)` за допомогою ряду Тейлора. Типові приклади оптимізацій [тут](https://ocw.mit.edu/courses/6-172-performance-engineering-of-software-systems-fall-2018/resources/lecture-2-bentley-rules-for-optimizing-work/).

```
void sinx(int N, int terms, float[] x, float[] result) {
    for (int i = 0; i < N; i++) {
        float value = x[i];
        float numer = x[i] * x[i] * x[i];
        int denom = 6; // 3!
        int sign = -1;
        for (int j = 1; j <= terms; j++) {
            value += sign * numer / denom;
            numer *= x[i] * x[i];
            denom *= (2*j+2) * (2*j+3);
            sign *= -1;
        }
        result[i] = value;
    }
}
```

