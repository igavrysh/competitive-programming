Як зрозуміти, чи можна застосовувати метод двoх вказівників?
Має виконуватися одна з двух властивостей:
• якщо відрізок хороший, то будь який вкладений в нього відрізок також хороший (в такому випадку можна застосувати код з першої задачі)
• якщо відрізок хороший, то будь який відрізок, який містить його також хороший  (в такому випадку можна застосувати код з другої задачі)
+ маємо вміти перераховувати нашу ф-ю (перевіряти хороший відрізок чи поганий) при збільшенні лівої чи правої межі на одиницю вправо.
Тоді код буде виглядати наступним чином:

```
L = 0
for R = 0..n-1
    add(a[R])
    while not good():
        remove(a[L])
        L++
```

Для вирішення такого роду задач достатньо реалізувати 3 функції - add, remove та good (edited) 
Дан масив а, потрібно знайти відрізок [𝐿,𝑅] максимальної довжини, на якому не більше 𝑘 різних чисел.
Перевіримо, що ця задача вирішується методом двох вказівників.
Якщо на відрізку [L,R] не більше ніж k унікальних чисел, то на будь-якому вкладеному в нього відрізку також буде не більше ніж k унікальних чисел.
Друге питання — як перевірити, що після руху вказівників відрізок залишиться хорошим?
Можна підтримувати структуру, яка буде рахувати к-ть унікальних чисел на відрізку.
Заведемо масив лічільників, який для кожного числа зберігає к-ть його входжень на відрізку, а також заведемо окремий лічільник, який зберігатиме к-ть унікальних елементів на відрізку.

```
cnt[x] - скільки існує позицій L <= i <= R, таких що a[i] == x

good():
    return num <= k

add(x):
    cnt[x]++
    if cnt[x] == 1:
        num++

remove(x):
    cnt[x]--
    if cnt[x] == 0:
        num--
```

Шаблон для генератора тестів:
```
test = 0
while True:
    if test % 10 == 0:
        print(f"test {test}")
    test += 1
    n = random.randint(2, 10)
    arr = [0] * n
    for i in range(n):
        arr[i] = random.randint(-10, 10)

    if slow(arr) != fast(arr):
        print(...)
        break
```
