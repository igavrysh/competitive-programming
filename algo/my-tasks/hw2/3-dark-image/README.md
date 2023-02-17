# 3 Dark Image

Пришвидшіть код, який обробляє картинку з рандомними значеннями пікселів.

```
const int N = 4096;
byte [,] image = new byte[N, N];
public bool isDark() {
    count = 0
    for (int j = 0; j < N; ++j) {
        for (int i = 0; i < N; ++i) {
             if (image[i, j] >= 128) {
                count += 1; 
            }
        } 
    }
    return count < N * N / 2;
}
```