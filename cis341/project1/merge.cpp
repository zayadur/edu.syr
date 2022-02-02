void merge(int a[], int low, int high, int mid) {
    int i, j, k;
    i = low;
    k = low;
    j = mid + 1;
    while(i <= mid && j <= high) {
        if(a[i] < a[j]) {
            c[k] = a[i];
            k++; i++;
        } else {
            c[k] = a[j];
            k++; j++;
        }
    }
    while(j <= high) {
        c[k] = a[j];
        k++; j++;
    }
    for(i = low; i < k; i++) {
        a[i] = c[i];
    }
}

