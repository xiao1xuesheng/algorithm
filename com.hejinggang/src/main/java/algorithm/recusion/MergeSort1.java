package algorithm.recusion;

import java.io.*;

public class MergeSort1 {

   public static int MAXN = 100001;

   public static int[]arr = new int[MAXN];

   public static int[]help = new int[MAXN];

   public static int n;

   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StreamTokenizer in = new StreamTokenizer(br);

       PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
       in.nextToken();
       n = (int) in.nval;

       for (int i = 0; i < n; i++) {
           in.nextToken();
           arr[i] = (int) in.nval;
       }

       mergeSort1(0, n - 1);

       for (int i = 0; i < n - 1; i++) {
           out.print(arr[i] + " ");
       }
       out.println(arr[n - 1]);
       out.flush();
       out.close();
       br.close();
   }

   public static void mergeSort1(int l, int r) {
       if (l == r) {
           return;
       }
       int m = l + ((r - l) >> 1);
       mergeSort1(l, m);
       mergeSort1(m + 1, r);
       merge(l, m, r);
   }

   // 归并 非递归方式
    public static void mergeSort2() {
       for (int l, m, r , step = 1; step < n; step <<= 1) {
           l = 0;
           while (l < n) {
               m = l + step - 1;
               if (m + 1 >= n) {
                   break;
               }
               r = Math.min(l + (step << 1) - 1, n - 1);
               merge(l, m, r);
               l = r + 1;
           }
       }
    }

    private static void merge(int l, int m, int r) {
       int i = l;
       int j = m + 1;
       int p = l;
       while (i <= m && j <= r) {
           if (arr[i] <= arr[j]) {
               help[p++] = arr[i++];
           } else {
               help[p++] = arr[j++];
           }
       }
       while (i <= m) {
           help[p++] = arr[i++];
       }
       while (j <= r) {
           help[p++] = arr[j++];
       }
       for (i = l; i <=r; i++) {
           arr[i] = help[i];
       }
    }
}
