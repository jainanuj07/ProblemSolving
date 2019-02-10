public class QuickUnionUF {

    int id[];
    int count;

    public QuickUnionUF(int N) {
        id = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int root(int p) {
        while(p!=id[p]) {
            p = id[p];
        }
        return p;
    }


    public void union(int p , int q) {
        int proot = root(p);
        int qroot = root(q);
        if(proot!=qroot ){
            id[proot] = qroot;
            count--;
        }
    }

    public boolean connected(int p , int q) {
        return root(p) == root(q);
    }

    public void printIdArray() {
        for(int i =0 ;i<id.length;i++) {
            System.out.print(id[i]);
        }
    }

}
